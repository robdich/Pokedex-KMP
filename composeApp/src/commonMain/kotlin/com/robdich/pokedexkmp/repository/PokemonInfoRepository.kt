package com.robdich.pokedexkmp.repository

import com.robdich.pokedexkmp.data.toPokemonInfo
import com.robdich.pokedexkmp.data.toPokemonInfoEntity
import com.robdich.pokedexkmp.database.dao.PokemonInfoDao
import com.robdich.pokedexkmp.model.PokemonInfo
import com.robdich.pokedexkmp.network.PokemonApiService

class PokemonInfoRepository(
    private val apiService: PokemonApiService,
    private val pokemonInfoDao: PokemonInfoDao
) {

    suspend fun getPokemonInfo(name: String): Result<PokemonInfo> {
        val localPokemonInfo = pokemonInfoDao.selectOneByName(name = name)
        return if (localPokemonInfo == null) {
            try {
                val response = apiService.getPokemonInfo(name = name)
                pokemonInfoDao.insert(response.toPokemonInfoEntity())
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(e)
            }
        } else {
            Result.success(localPokemonInfo.toPokemonInfo())
        }
    }
}