package com.example.cafemovoie.ui.event

sealed interface MovieListUiEvent{
    data class Paginate(val category: String) : MovieListUiEvent
}