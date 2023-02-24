package com.example.cryptocomposeapp.presentation.favourite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocomposeapp.domain.model.FavouriteCoin
import com.example.cryptocomposeapp.domain.use_case.favourite.DeleteFavouriteUseCase
import com.example.cryptocomposeapp.domain.use_case.favourite.ListFavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val listFavouriteUseCase: ListFavouriteUseCase,
    private val deleteFavouriteUseCase: DeleteFavouriteUseCase
) : ViewModel() {

    private val _state = mutableStateOf(FavouriteState())
    val state: State<FavouriteState> = _state

    init {
        getFavourite()
    }

    private fun getFavourite() {
        listFavouriteUseCase.invoke().onEach { listFav ->
            _state.value = state.value.copy(
                favourite = listFav
            )
        }.launchIn(viewModelScope)
    }

    fun deleteFavCoin(favouriteCoin: FavouriteCoin) {
        viewModelScope.launch {
            deleteFavouriteUseCase.invoke(favouriteCoin)
        }
    }
}