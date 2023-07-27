package com.emreaytac.myapplication.data.repository.pokemon

import com.emreaytac.myapplication.data.api.ApiService
import com.emreaytac.myapplication.data.api.PokemonResponse
import com.emreaytac.myapplication.data.repository.BaseDataSource
import com.emreaytac.myapplication.domain.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService): BaseDataSource(), PokemonRemoteDataSource {

    override suspend fun getPokemonList(limit: Int, offset: Int): Flow<Resource<PokemonResponse>> = flow{
        emit( safeApiCall { apiService.getPokemonList(limit, offset) } )
    }.flowOn(Dispatchers.IO)
}