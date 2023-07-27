package com.emreaytac.myapplication.ui.pokemon.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emreaytac.myapplication.data.api.Results
import com.emreaytac.myapplication.databinding.CardPokemonBinding

class PokemonListAdapter : androidx.recyclerview.widget.ListAdapter<Results, PokemonListAdapter.PokemonListViewHolder>(PokemonListAdapterDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val binding = CardPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PokemonListViewHolder(private val binding: CardPokemonBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(res: Results){
            binding.pokemonTv.text = res.name ?: ""
        }
    }

    private class PokemonListAdapterDiffCallBack : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean =
            oldItem == newItem
    }

}