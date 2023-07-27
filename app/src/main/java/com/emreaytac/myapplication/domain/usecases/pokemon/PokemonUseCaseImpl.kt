package com.emreaytac.myapplication.domain.usecases.pokemon

import com.emreaytac.myapplication.data.api.PokemonResponse
import com.emreaytac.myapplication.domain.Resource
import com.emreaytac.myapplication.domain.repository.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PokemonUseCaseImpl @Inject constructor(private val repository: PokemonRepository) : PokemonUseCase {

    override suspend fun execute(param: PokemonUseCase.PokemonListParams): Flow<Resource<PokemonResponse>> = repository.getPokemonList(param.limit, param.offset)

}