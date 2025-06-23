package com.robdich.pokedexkmp.di

import com.robdich.pokedexkmp.database.di.databaseModule
import com.robdich.pokedexkmp.network.PokemonApiService
import com.robdich.pokedexkmp.repository.PokemonInfoRepository
import com.robdich.pokedexkmp.repository.PokemonListRepository
import com.robdich.pokedexkmp.ui.pokemonInfo.PokemonInfoViewModel
import com.robdich.pokedexkmp.ui.pokemonlist.PokemonListViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val appModule = module {
    single<PokemonApiService> { PokemonApiService() }

    single<PokemonListRepository> { PokemonListRepository(apiService = get(), pokemonDao = get()) }
    viewModel { PokemonListViewModel(repository = get()) }

    single<PokemonInfoRepository> { PokemonInfoRepository(apiService = get(), pokemonInfoDao = get()) }
    viewModel { PokemonInfoViewModel(get(), repository = get()) }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(appModule, databaseModule)
    }