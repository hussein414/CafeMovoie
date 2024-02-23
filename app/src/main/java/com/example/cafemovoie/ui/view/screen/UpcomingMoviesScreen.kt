package com.example.cafemovoie.ui.view.screen


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cafemovoie.ui.event.MovieListUiEvent
import com.example.cafemovoie.ui.view.component.LoadingConnection
import com.example.cafemovoie.ui.view.component.MovieItem
import com.example.cafemovoie.ui.view.component.Test
import com.example.cafemovoie.ui.viewmodel.MovieListViewModel
import com.example.cafemovoie.utils.Constance

@Preview(showSystemUi = true)
@Composable
fun UpcomingScreen() {
    val movieListViewModel = hiltViewModel<MovieListViewModel>()
    val movieState = movieListViewModel.movieListState.collectAsState().value
    when {
        movieState.checkConnection -> {
            Test()
        }
        movieState.upcomingMovieList.isEmpty() -> {
            LoadingConnection()
        }
        else -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
            ) {
                items(movieState.upcomingMovieList.size) { index ->
                    MovieItem(
                        movie = movieState.upcomingMovieList[index]
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    if (index >= movieState.upcomingMovieList.size - 1 && !movieState.isLoading) {
                        movieListViewModel.onEvent(MovieListUiEvent.Paginate(Constance.UPCOMING))
                    }
                }
            }
        }
    }
}
