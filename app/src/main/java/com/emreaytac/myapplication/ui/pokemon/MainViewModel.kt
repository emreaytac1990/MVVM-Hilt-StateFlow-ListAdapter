package com.emreaytac.myapplication.ui.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreaytac.myapplication.domain.Resource
import com.emreaytac.myapplication.domain.usecases.pokemon.PokemonUseCase
import com.emreaytac.myapplication.ui.pokemon.events.PokemonListEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: PokemonUseCase): ViewModel() {

    private val _pokemonListState = MutableStateFlow<PokemonListEvents>(PokemonListEvents.ShowEmptyList)
    val pokemonListState = _pokemonListState.asStateFlow()

    private fun onEvent(event: PokemonListEvents){
        _pokemonListState.value = event
    }

    private fun getPokemonList(){

        onEvent(PokemonListEvents.ShowLoading)

        viewModelScope.launch(Dispatchers.IO) {
            useCase.execute(PokemonUseCase.PokemonListParams(20, 0)).collect{
                when(it){
                    is Resource.Success -> {
                        it.data?.let { res ->
                            onEvent(PokemonListEvents.ShowPokemonList(res))
                        }
                    }
                    is Resource.Empty -> {
                        onEvent(PokemonListEvents.ShowEmptyList)
                    }
                    is Resource.Error -> {
                        onEvent(PokemonListEvents.ShowToastMessage(it.message))
                    }
                    is Resource.Loading -> {
                        onEvent(PokemonListEvents.ShowLoading)
                    }
                }
            }
        }
    }

    init {
        getPokemonList()
    }

}