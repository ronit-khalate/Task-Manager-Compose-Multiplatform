package com.ronit.project

import KoinInitializer
import android.app.Application

class TaskManagerApp:Application() {

    override fun onCreate() {
        super.onCreate()

        KoinInitializer(applicationContext).init()
    }
}