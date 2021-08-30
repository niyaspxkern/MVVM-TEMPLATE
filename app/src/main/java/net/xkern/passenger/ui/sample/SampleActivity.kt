package net.xkern.passenger.ui.sample

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import net.xkern.passenger.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import net.xkern.passenger.databinding.SampleActivityBinding

@AndroidEntryPoint
class SampleActivity : BaseActivity<ActivityViewModel>() {

    private lateinit var binding: SampleActivityBinding
    private val activityViewModel: ActivityViewModel by viewModels()
    override fun getBinding(): View {
        binding = SampleActivityBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun getViewModel() = activityViewModel
    override fun setup(savedInstanceState: Bundle?) {
    }

}