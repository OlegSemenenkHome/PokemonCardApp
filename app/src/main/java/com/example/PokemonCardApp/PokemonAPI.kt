package com.example.PokemonCardApp

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val POKEMON_URL = "https://api.pokemontcg.io/v2/"

interface PokemonAPI {
    @GET("cards/?orderBy=name")
    suspend fun getPokemonCards(): PokemonData

    companion object {
        operator fun invoke(): PokemonAPI =
            Retrofit.Builder()
                .baseUrl(POKEMON_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(PokemonAPI::class.java)
    }
}

data class PokemonData(
    val data: List<Data>
)

data class Data(
    val name: String,
    val images: Images,
    val supertype: String
)

data class Images(
    val small: String,
    val large: String
)
