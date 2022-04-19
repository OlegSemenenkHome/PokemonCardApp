package com.example.PokemonCardApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObservable()
    }

    private fun setupObservable() {

        viewModel._pokemonList.observe(this) {
            var viewAdapter: RecyclerView.Adapter<*>
            println(it)
            findViewById<RecyclerView>(R.id.pokemon).apply {
                viewAdapter = ViewAdapter(it)
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = viewAdapter
            }
        }
    }
}