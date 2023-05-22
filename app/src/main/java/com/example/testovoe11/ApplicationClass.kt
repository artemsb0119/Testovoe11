package com.example.testovoe11

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "e8914bbc-fe46-4951-9067-2b73d03806fd"

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}