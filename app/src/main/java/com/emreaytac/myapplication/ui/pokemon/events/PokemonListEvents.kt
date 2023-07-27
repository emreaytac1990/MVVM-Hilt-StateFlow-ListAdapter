package com.emreaytac.myapplication.ui.pokemon.events

import com.emreaytac.myapplication.data.api.PokemonResponse

sealed interface PokemonListEvents {

    data class ShowPokemonList(val data: PokemonResponse): PokemonListEvents

    object ShowEmptyList : PokemonListEvents

    object ShowLoading : PokemonListEvents

    data class ShowToastMessage(val message: String): PokemonListEvents

}