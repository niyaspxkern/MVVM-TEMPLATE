package net.xkern.passenger.ui.home

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import net.xkern.passenger.data.repository.UserRepository
import net.xkern.passenger.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val userRepository: UserRepository,
) : BaseViewModel() {

    init {
        Log.i("ffffffHomeViewModel","""
            $userRepository
        """.trimIndent())
    }
}