package net.xkern.passenger.ui.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.xkern.passenger.databinding.SampleFragmentBinding
import net.xkern.passenger.ui.base.BaseFragment

@AndroidEntryPoint
class SampleFragment : BaseFragment<FragmentViewModel>() {
    private var _binding: SampleFragmentBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: FragmentViewModel by viewModels()

    override fun setup() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SampleFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModel() = homeViewModel

}