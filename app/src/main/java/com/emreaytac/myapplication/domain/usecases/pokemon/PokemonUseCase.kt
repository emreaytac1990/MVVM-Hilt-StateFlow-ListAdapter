package com.emreaytac.myapplication.domain.usecases.pokemon

import com.emreaytac.myapplication.data.api.PokemonResponse
import com.emreaytac.myapplication.domain.Resource
import com.emreaytac.myapplication.domain.usecases.UseCase
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase: UseCase<PokemonUseCase.PokemonListParams, Flow<Resource<PokemonResponse>>> {

    data class PokemonListParams(val limit: Int, val offset: Int)

}