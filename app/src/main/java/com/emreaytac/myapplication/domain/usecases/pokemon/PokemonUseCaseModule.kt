package com.emreaytac.myapplication.domain.usecases.pokemon

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PokemonUseCaseModule {

    @Binds
    fun providePokemonUseCaseImpl(useCase: PokemonUseCaseImpl): PokemonUseCase

}