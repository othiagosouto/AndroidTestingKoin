package com.soutoss.myappteste

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class TesteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@TesteApp)
            // declare modules

            val myModule = module {
                single { RepoLocal() as RepoSource }
                single { MainViewModel(get()) }

            }
            modules(myModule)
        }
    }

}