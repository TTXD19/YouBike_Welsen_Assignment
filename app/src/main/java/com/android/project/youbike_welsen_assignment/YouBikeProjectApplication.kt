package com.android.project.youbike_welsen_assignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class YouBikeProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}