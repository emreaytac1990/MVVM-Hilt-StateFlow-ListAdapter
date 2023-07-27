package com.emreaytac.myapplication.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon/")
    suspend fun getPokemonList(@Query("limit") limit: Int = 0, @Query("offset") offset: Int = 0) : Response<PokemonResponse>
}