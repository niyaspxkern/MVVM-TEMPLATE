package net.xkern.passenger.ui.main

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import net.xkern.passenger.data.repository.UserRepository
import net.xkern.passenger.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val userRepository: UserRepository,
) : BaseViewModel() {
    companion object {
        val TAG = MainViewModel::class.java.simpleName
    }
    init {
        Log.i("ffffffMainViewModel","""
            $userRepository
        """.trimIndent())
    }

}