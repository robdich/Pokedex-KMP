package com.robdich.pokedexkmp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import com.robdich.pokedexkmp.navigation.AppNavigation
import com.robdich.pokedexkmp.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    AppTheme {
        AppNavigation()
    }
}