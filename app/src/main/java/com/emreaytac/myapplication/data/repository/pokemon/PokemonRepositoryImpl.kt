package com.emreaytac.myapplication.data.repository.pokemon

import com.emreaytac.myapplication.data.api.PokemonResponse
import com.emreaytac.myapplication.data.repository.BaseDataSource
import com.emreaytac.myapplication.domain.Resource
import com.emreaytac.myapplication.domain.repository.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val dataSource: PokemonRemoteDataSource): BaseDataSource(), PokemonRepository  {

    override suspend fun getPokemonList(limit: Int, offset: Int): Flow<Resource<PokemonResponse>> = dataSource.getPokemonList(limit, offset)

}