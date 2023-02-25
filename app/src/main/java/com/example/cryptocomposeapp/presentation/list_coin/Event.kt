package com.example.cryptocomposeapp.presentation.list_coin

sealed class Event {
    data class SearchQuery(val query : String) : Event()
}
