package net.xkern.passenger.data.local.prefs

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import net.xkern.passenger.di.PreferenceInfo
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@SuppressLint("HardwareIds")
class AppPreferences @Inject constructor(
        @ApplicationContext context: Context,
        @PreferenceInfo prefFileName: String?
) {

    private val mPrefs: SharedPreferences =
            context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    companion object {

        private const val KEY_DEVICE_ID = "device_id"
        private const val KEY_DEVICE_TYPE = "device_type"
        private const val KEY_TOKEN = "token"
        private const val KEY_IS_LOGIN = "is_login"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_EMAIL_ID = "email_id"
    }

    init {
        setDeviceID(Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID))
        setDeviceType("2")
    }

    fun getDeviceID(): String {
        return mPrefs.getString(KEY_DEVICE_ID, null) ?: ""
    }

    private fun setDeviceID(id: String) {
        mPrefs.edit().putString(KEY_DEVICE_ID, id).apply()
    }

    fun getDeviceType(): String {
        return mPrefs.getString(KEY_DEVICE_TYPE, null)!!
    }

    private fun setDeviceType(type: String) {
        mPrefs.edit().putString(KEY_DEVICE_TYPE, type).apply()
    }

    fun getToken(): String {
        return mPrefs.getString(KEY_TOKEN, null) ?: ""
    }

    fun setToken(token: String) {
        mPrefs.edit().putString(KEY_TOKEN, token).apply()
    }

    fun isLogin() = mPrefs.getBoolean(KEY_IS_LOGIN, false)

    fun setLogin(status: Boolean) {
        mPrefs.edit().putBoolean(KEY_IS_LOGIN, status).apply()
    }

    fun userId(): String {
        return mPrefs.getString(KEY_USER_ID, null) ?: ""
    }

    fun userId(id: String) {
        mPrefs.edit().putString(KEY_USER_ID, id).apply()
    }

    fun setEmail(email: String) {
        mPrefs.edit().putString(KEY_EMAIL_ID, email).apply()
    }

    fun getEmail(): String {
        return mPrefs.getString(KEY_EMAIL_ID, null) ?: ""
    }
}