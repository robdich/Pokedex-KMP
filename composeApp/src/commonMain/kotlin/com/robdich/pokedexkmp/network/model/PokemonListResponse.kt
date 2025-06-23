package com.robdich.pokedexkmp.network.model

import com.robdich.pokedexkmp.model.Pokemon
import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    val results: List<Pokemon>
)
