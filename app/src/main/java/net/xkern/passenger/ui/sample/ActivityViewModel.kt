package net.xkern.passenger.ui.sample

import net.xkern.passenger.data.local.prefs.AppPreferences
import net.xkern.passenger.data.remote.ApiInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import net.xkern.passenger.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
        val api: ApiInterface,
        val appPreferences: AppPreferences,
) : BaseViewModel() {

}