package com.robdich.pokedexkmp

import android.app.Application
import com.robdich.pokedexkmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MainApplication)
        }
    }
}