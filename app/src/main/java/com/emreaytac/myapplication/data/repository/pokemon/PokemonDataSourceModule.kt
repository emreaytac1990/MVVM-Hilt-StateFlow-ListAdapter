package com.emreaytac.myapplication.data.repository.pokemon

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface PokemonDataSourceModule {

    @Binds
    fun providePokemonDataSourceImpl(dataSource: PokemonRemoteDataSourceImpl): PokemonRemoteDataSource
}