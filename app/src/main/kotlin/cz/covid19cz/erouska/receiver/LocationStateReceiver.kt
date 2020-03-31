package cz.covid19cz.erouska.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import cz.covid19cz.erouska.service.CovidService
import cz.covid19cz.erouska.utils.L

class LocationStateReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent?) {
        val action = intent?.action
        L.d("Location state changed")
        if (action.equals("android.location.PROVIDERS_CHANGED")) {
            CovidService.update(context)
        }
    }
}