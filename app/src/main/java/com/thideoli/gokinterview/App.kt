package com.thideoli.gokinterview

import android.app.Application
import com.thideoli.gokinterview.module.appModule
import com.thideoli.gokinterview.module.repositoryModule
import com.thideoli.gokinterview.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule,
                repositoryModule,
                viewModelModule
            ))
        }
    }
}