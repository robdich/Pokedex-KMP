package com.robdich.pokedexkmp.ui.pokemonInfo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.robdich.pokedexkmp.model.PokemonInfo
import com.robdich.pokedexkmp.navigation.InfoScreen
import com.robdich.pokedexkmp.repository.PokemonInfoRepository
import kotlinx.coroutines.launch

class PokemonInfoViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: PokemonInfoRepository
) : ViewModel() {
    private val infoScreen = savedStateHandle.toRoute<InfoScreen>()

    private val _pokemonInfoState = mutableStateOf(PokemonInfoViewState())
    val pokemonInfoState: State<PokemonInfoViewState> get() = _pokemonInfoState

    init {
        loadPokemonInfo()
    }

    fun loadPokemonInfo() = viewModelScope.launch {
        println("PokedexLogs loadPokemonInfo infoScreen.name: ${infoScreen.name}")
        val result = repository.getPokemonInfo(name = infoScreen.name)
        when {
            result.isSuccess -> {
                val info = result.getOrDefault(PokemonInfo())
                _pokemonInfoState.value = PokemonInfoViewState(info = info)
            }
            result.isFailure -> {
                _pokemonInfoState.value = PokemonInfoViewState(isError = true)
            }
        }
    }

}

data class PokemonInfoViewState(
    val info: PokemonInfo = PokemonInfo(),
    val isError: Boolean = false
)