package com.example.PokemonCardApp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {

    val _pokemonList = MutableLiveData<List<Data>>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            _pokemonList.postValue(PokemonAPI().getPokemonCards().data)
        }
    }
}