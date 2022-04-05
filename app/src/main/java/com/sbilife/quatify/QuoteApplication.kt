package com.sbilife.quatify

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class QuoteApplication: Application() {



    override fun onCreate() {
        super.onCreate()
    }
}