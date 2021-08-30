package net.xkern.passenger.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import net.xkern.passenger.R
import net.xkern.passenger.databinding.ActivityMainBinding
import net.xkern.passenger.ui.base.BaseActivity
import net.xkern.passenger.utils.network.monitor.ConnectivityStateHolder
import net.xkern.passenger.utils.network.monitor.Event
import net.xkern.passenger.utils.network.monitor.NetworkEvents

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>() {

    private var mCurrentDest = 0
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun getBinding(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun setup(savedInstanceState: Bundle?) {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            mCurrentDest = destination.id
        }


        NetworkEvents.observe(this) {
            if (it is Event.ConnectivityEvent) {
                val isConnected = ConnectivityStateHolder.isConnected
            }
        }

    }

    override fun getViewModel() = mainViewModel

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }
}