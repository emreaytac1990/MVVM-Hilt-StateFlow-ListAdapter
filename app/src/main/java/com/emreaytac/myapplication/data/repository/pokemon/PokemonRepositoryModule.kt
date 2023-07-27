package com.emreaytac.myapplication.data.repository.pokemon

import com.emreaytac.myapplication.domain.repository.pokemon.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PokemonRepositoryModule {

    @Binds
    fun providePokemonRepositoryImpl(repository: PokemonRepositoryImpl): PokemonRepository
}