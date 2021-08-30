package net.xkern.passenger

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import net.xkern.passenger.utils.network.monitor.ConnectivityStateHolder.initNetworkMonitorConfig


@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        //monitors network
        initNetworkMonitorConfig()
    }
}