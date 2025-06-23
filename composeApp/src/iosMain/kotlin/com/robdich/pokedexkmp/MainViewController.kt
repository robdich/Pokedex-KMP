package com.robdich.pokedexkmp

import androidx.compose.ui.window.ComposeUIViewController
import com.robdich.pokedexkmp.di.initKoin
import platform.UIKit.*

fun MainViewController() : UIViewController {
    initKoin()
    return ComposeUIViewController {
        App()
    }
}