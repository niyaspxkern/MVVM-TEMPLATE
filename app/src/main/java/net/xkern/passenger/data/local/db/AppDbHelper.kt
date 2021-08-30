package net.xkern.passenger.data.local.db

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject constructor(private val appDatabase: AppDatabase) : DbHelper {
    init {
        Log.i("ffffffAppDbHelper","""
            $appDatabase
        """.trimIndent())
    }
}