package com.robdich.pokedexkmp.database.di

import com.robdich.pokedexkmp.database.PokedexDatabase
import com.robdich.pokedexkmp.database.dao.PokemonDao
import com.robdich.pokedexkmp.database.dao.PokemonInfoDao
import com.robdich.pokedexkmp.database.databaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    factory { databaseDriverFactory() }
    single<PokedexDatabase> { PokedexDatabase(driver = get()) }
    single<PokemonDao> { PokemonDao(database = get()) }
    single<PokemonInfoDao> { PokemonInfoDao(database = get()) }
}