package cz.covid19cz.erouska.db

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPrefsRepository(c : Context) {

    companion object{
        const val DEVICE_BUID = "DEVICE_BUID"
        const val APP_PAUSED = "preference.app_paused"
        const val LAST_UPLOAD_TIMESTAMP = "preference.last_upload_timestamp"
    }

    val prefs : SharedPreferences = c.getSharedPreferences("prefs", MODE_PRIVATE)

    fun putDeviceBuid(buid : String){
        prefs.edit().putString(DEVICE_BUID, buid).apply()
    }

    fun removeDeviceBuid(){
        prefs.edit().remove(DEVICE_BUID).apply()
    }

    fun getDeviceBuid() : String?{
        return prefs.getString(DEVICE_BUID, null)
    }

    fun setAppPaused(appPaused: Boolean) {
        prefs.edit().putBoolean(APP_PAUSED, appPaused).apply()
    }

    fun saveLastUploadTimestamp(timestamp: Long) {
        prefs.edit().putLong(LAST_UPLOAD_TIMESTAMP, timestamp).apply()
    }

    fun getLastUploadTimestamp(): Long {
        return prefs.getLong(LAST_UPLOAD_TIMESTAMP, -1)
    }

    fun getAppPaused() = prefs.getBoolean(APP_PAUSED, false)

    fun clear(){
        prefs.edit().clear().apply()
    }
}