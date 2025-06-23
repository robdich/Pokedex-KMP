package com.robdich.pokedexkmp.database.dao

import com.robdich.pokedexkmp.database.PokedexDatabase
import com.robdich.pokedexkmp.database.PokemonInfoEntity

class PokemonInfoDao(database: PokedexDatabase) {
    private val query = database.pokemonInfoEntityQueries

    internal fun selectOneByName(name: String): PokemonInfoEntity? {
        return query.selectOneByName(name = name).executeAsOneOrNull()
    }

    internal fun insert(pokemonInfoEntity: PokemonInfoEntity) {
        query.insertInfo(pokemonInfoEntity)
    }
}