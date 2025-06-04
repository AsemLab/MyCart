package com.asemlab.mycart.base

import android.app.Application
import com.asemlab.mycart.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyCartApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyCartApp)
            modules(networkModule)
        }
    }
}