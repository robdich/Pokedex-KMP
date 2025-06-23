package com.robdich.pokedexkmp.data

import com.robdich.pokedexkmp.database.PokemonEntity
import com.robdich.pokedexkmp.database.PokemonInfoEntity
import com.robdich.pokedexkmp.model.Pokemon
import com.robdich.pokedexkmp.model.PokemonInfo
import kotlinx.serialization.json.Json

fun Pokemon.toPokemonEntity(page: Long) = PokemonEntity(
    page = page,
    name = name,
    url = url
)

fun PokemonEntity.toPokemon() = Pokemon(
    page = page,
    name = name,
    url = url
)

fun PokemonInfo.toPokemonInfoEntity() = PokemonInfoEntity(
    id = id,
    name = name,
    height = height,
    weight = weight,
    types = Json.encodeToString(types)
)

fun PokemonInfoEntity.toPokemonInfo() = PokemonInfo(
    id = id,
    name = name,
    height = height,
    weight = weight,
    types = Json.decodeFromString(types)
)