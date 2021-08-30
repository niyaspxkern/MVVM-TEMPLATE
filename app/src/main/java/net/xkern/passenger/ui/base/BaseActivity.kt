package net.xkern.passenger.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import net.xkern.passenger.data.ErrorBody
import net.xkern.passenger.utils.network.NoInternetException
import net.xkern.passenger.R

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    private lateinit var mViewModel: T

    abstract fun getViewModel(): T

    private val loadingDialog = LoadingDialog.newInstance()
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getBinding())
        mViewModel = getViewModel()
        setUpLoadingObservers()
        setup(savedInstanceState)
    }

    private fun setUpLoadingObservers() {
        mViewModel.loading.observe(this, {
            if (it) showLoading()
            else hideLoading()
        })
        mViewModel.exceptionEvent.observe(this, {
            when (it) {
                is ExceptionEvent.Throw -> {
                    handleError(it.errorBody, it.throwable)
                    mViewModel.settleExceptionEvent()
                }
                ExceptionEvent.Finish -> {
                }
            }.exhaustive
        })
        mViewModel.toastEvent.observe(this, {
            when (it) {
                is Event.Data -> {
                    toast(it.id)
                    mViewModel.settleToastEvent()
                }
                Event.Finish -> {
                }
            }.exhaustive
        })
    }

    fun hideLoading() {
        if (isLoading) {
            loadingDialog.dismiss()
            isLoading = false
        }
    }

    fun showLoading() {
        if (!isLoading) {
            loadingDialog.show(supportFragmentManager, loadingDialog.tag)
            isLoading = true
        }
    }

    abstract fun getBinding(): View
    abstract fun setup(savedInstanceState: Bundle?)

    fun handleError(body: ErrorBody?, throwable: Throwable?) {
        body?.message?.let { message ->
            if (message.isNotBlank())
                toast(message)
        } ?: kotlin.run {
            throwable?.let { t ->
                if (t is NoInternetException) {
                    toast(t.message)
                } else toast(R.string.common_text_api_failure_message)
            }
        }
    }
}