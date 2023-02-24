package com.example.cryptocomposeapp.presentation.list_coin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocomposeapp.domain.model.FavouriteCoin
import com.example.cryptocomposeapp.domain.use_case.favourite.AddFavouriteUseCase
import com.example.cryptocomposeapp.domain.use_case.list.ListCoinsUseCase
import com.example.cryptocomposeapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListCoinsViewModel @Inject constructor(
    private val listCoinsUseCase: ListCoinsUseCase,
    private val addFavouriteUseCase: AddFavouriteUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StateListCoins())
    val state : State<StateListCoins> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        listCoinsUseCase().onEach { result->
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

    fun addFavourite(favouriteCoin: FavouriteCoin) {
        viewModelScope.launch {
            addFavouriteUseCase.invoke(favouriteCoin)
        }
    }
}