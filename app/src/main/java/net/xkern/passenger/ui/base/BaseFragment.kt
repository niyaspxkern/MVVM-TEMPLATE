package net.xkern.passenger.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    lateinit var baseActivity: BaseActivity<*>
    lateinit var mContext: Context
    private lateinit var mViewModel: T

    abstract fun getViewModel(): T
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = getViewModel()
        setUpLoadingObservers()
        setup()
    }

    abstract fun setup()

    private fun setUpLoadingObservers() {
        mViewModel.loading.observe(viewLifecycleOwner, {
            if (it)
                baseActivity.showLoading()
            else
                baseActivity.hideLoading()
        })
        mViewModel.exceptionEvent.observe(viewLifecycleOwner, {
            when (it) {
                is ExceptionEvent.Throw -> {
                    baseActivity.handleError(it.errorBody, it.throwable)
                    mViewModel.settleExceptionEvent()
                }
                ExceptionEvent.Finish -> {
                }
            }.exhaustive
        })
        mViewModel.toastEvent.observe(viewLifecycleOwner, {
            when (it) {
                is Event.Data -> {
                    toast(it.id)
                    mViewModel.settleToastEvent()
                }
                Event.Finish -> {
                }
            }.exhaustive
        })
        mViewModel.backEvent.observe(viewLifecycleOwner, {
            when (it) {
                is Event.Data -> {
                    mViewModel.settlebackEvent()
                    findNavController().popBackStack()
                }
                Event.Finish -> {
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        baseActivity = context as BaseActivity<*>
    }

    internal fun popBack() {
        findNavController().popBackStack()
    }
}