package com.example.cafemovoie.ui.state

import com.example.cafemovoie.data.model.Movie


data class MovieListState(
    val isLoading: Boolean = false,

    val checkConnection: Boolean = false,
    val upcomingMovieListPage: Int = 1,

    val isCurrentPopularScreen: Boolean = true,

    val upcomingMovieList: List<Movie> = emptyList()
)
