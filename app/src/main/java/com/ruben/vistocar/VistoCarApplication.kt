package com.ruben.vistocar

import android.app.Application
import java.lang.IllegalStateException

class VistoCarApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: VistoCarApplication? = null

        fun getInstance(): VistoCarApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}