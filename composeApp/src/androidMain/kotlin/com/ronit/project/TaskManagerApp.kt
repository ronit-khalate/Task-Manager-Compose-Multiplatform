package com.ronit.project

import di.KoinInitializer
import android.app.Application

class TaskManagerApp:Application() {

    override fun onCreate() {
        super.onCreate()

        KoinInitializer(applicationContext).init()
    }
}