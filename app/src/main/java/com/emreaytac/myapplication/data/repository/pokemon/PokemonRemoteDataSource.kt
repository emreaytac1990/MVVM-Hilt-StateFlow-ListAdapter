package com.emreaytac.myapplication.data.repository.pokemon

import com.emreaytac.myapplication.data.api.PokemonResponse
import com.emreaytac.myapplication.domain.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {

    suspend fun getPokemonList(limit: Int, offset: Int): Flow<Resource<PokemonResponse>>
}