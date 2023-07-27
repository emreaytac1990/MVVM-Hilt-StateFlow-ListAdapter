package com.emreaytac.myapplication.domain.repository.pokemon

import com.emreaytac.myapplication.data.api.PokemonResponse
import com.emreaytac.myapplication.domain.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemonList(limit: Int, offset: Int): Flow<Resource<PokemonResponse>>

}