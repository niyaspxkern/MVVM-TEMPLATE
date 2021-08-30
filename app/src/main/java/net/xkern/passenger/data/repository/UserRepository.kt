package net.xkern.passenger.data.repository

import android.util.Log
import net.xkern.passenger.data.local.db.AppDbHelper
import net.xkern.passenger.data.local.prefs.AppPreferences
import net.xkern.passenger.data.remote.ApiInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    val api: ApiInterface,
    val appPreferences: AppPreferences,
    val appDbHelper: AppDbHelper,
) {

    init {
        Log.i("ffffffUserRepository","""
            $api
            $appPreferences
            $appDbHelper
        """.trimIndent())
    }
}