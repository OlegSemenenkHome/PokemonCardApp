package com.example.PokemonCardApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ViewAdapter(private val data: List<Data>) :
    RecyclerView.Adapter<ViewAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: Data) {
            val title = view.findViewById<TextView>(R.id.pokemonName)
            val imageView = view.findViewById<ImageView>(R.id.pokemonPicture)
            title.text = data.name
            Glide.with(view.context).load(data.images.small).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_row, parent, false)
        return PokemonViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(data[position])
    }
}