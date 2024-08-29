package com.example.geckoview_example

import android.content.Context
import org.mozilla.geckoview.GeckoRuntime

object GeckoRuntimeSingleton {
    private var instance: GeckoRuntime? = null

    fun getInstance(context: Context): GeckoRuntime {
        if (instance == null) {
            instance = GeckoRuntime.create(context.applicationContext)
        }
        return instance!!
    }
}
