package com.example.cryptocomposeapp.presentation.detail_coin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocomposeapp.domain.use_case.DetailCoinUseCase
import com.example.cryptocomposeapp.utils.Constants
import com.example.cryptocomposeapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailCoinViewModel @Inject constructor(
    private val detailCoinUseCase: DetailCoinUseCase,
    stateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(StateDetailCoin())
    val state : State<StateDetailCoin> = _state

    init {
        stateHandle.get<String>(Constants.COIN_DETAIL)?.let { coin_detail->
            detailCoin(coin_detail)
        }
    }

    private fun detailCoin(id : String) {
        detailCoinUseCase(id).onEach { result->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StateDetailCoin(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = StateDetailCoin(detailCoin = result.data)
                }
                is Resource.Error -> {
                    _state.value = StateDetailCoin(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}