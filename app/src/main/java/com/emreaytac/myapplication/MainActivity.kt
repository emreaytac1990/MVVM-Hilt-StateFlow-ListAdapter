package com.emreaytac.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emreaytac.myapplication.databinding.ActivityMainBinding
import com.emreaytac.myapplication.ui.pokemon.MainViewModel
import com.emreaytac.myapplication.ui.pokemon.adapter.PokemonListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: PokemonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buildUI()
        initUIEvents()
    }


    private fun buildUI(){
        binding.apply {
            adapter = PokemonListAdapter()
            val layoutManager: RecyclerView.LayoutManager =
                LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
            binding.fatRv.layoutManager = layoutManager
            fatRv.adapter = adapter
        }
    }

    private fun initUIEvents(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                vm.pokemonListState.collect{ event ->

                    when(event){
                        is PokemonListEvents.ShowPokemonList ->{
                            val list = event.data.results.toList()
                            adapter.submitList(list)
                            binding.noItemTv.visibility = View.GONE
                            binding.progressCircular.visibility = View.GONE
                        }
                        is PokemonListEvents.ShowEmptyList -> {
                            binding.noItemTv.visibility = View.VISIBLE
                            binding.progressCircular.visibility = View.GONE
                        }
                        is PokemonListEvents.ShowLoading -> {
                            binding.progressCircular.visibility = View.VISIBLE
                        }
                        is PokemonListEvents.ShowToastMessage -> {
                            binding.progressCircular.visibility = View.GONE
                            Toast.makeText(baseContext, event.message, Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }
    }

}