package com.example.cryptocomposeapp.presentation.list_coin

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocomposeapp.domain.model.FavouriteCoin
import com.example.cryptocomposeapp.domain.repository.RepositoryCoins
import com.example.cryptocomposeapp.domain.use_case.favourite.AddFavouriteUseCase
import com.example.cryptocomposeapp.domain.use_case.list.ListCoinsUseCase
import com.example.cryptocomposeapp.domain.use_case.list.SearchCoinsUseCase
import com.example.cryptocomposeapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListCoinsViewModel @Inject constructor(
    private val listCoinsUseCase: ListCoinsUseCase,
    private val addFavouriteUseCase: AddFavouriteUseCase,
    private val repositoryCoins: RepositoryCoins
    //private val searchCoinsUseCase: SearchCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StateListCoins())
    val state: State<StateListCoins> = _state

    private var searchJob: Job? = null

    init {
        getCoins()
    }

    private fun getCoins() {
        listCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateListCoins(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateListCoins(listCoins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = StateListCoins(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: Event) {
        when (event) {
            is Event.SearchQuery -> {
                _state.value = state.value.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500)
                    searchQueryCoins()
                }
            }
        }
    }

    private fun searchQueryCoins(query: String = state.value.searchQuery.lowercase()) {
        viewModelScope.launch {
            repositoryCoins
                .searchCoins(query)
                .collect { res ->
                    when (res) {
                        is Resource.Loading -> {
                            _state.value = state.value.copy(isLoading = res.isLoading)
                        }
                        is Resource.Success -> {
                            res.data?.let {
                                _state.value = state.value.copy(listCoins = it)
                            }
                            Log.d("TAG", "${res.data} ----- Resource.Success")
                        }
                        is Resource.Error -> Unit
                    }
                }
        }
    }

    fun addFavourite(favouriteCoin: FavouriteCoin) {
        viewModelScope.launch {
            addFavouriteUseCase.invoke(favouriteCoin)
            //_state.value = state.value.copy(isAddFav = !state.value.isAddFav)
        }
    }
}