package com.example.cafemovoie.data.repository

import com.example.cafemovoie.data.model.Movie
import com.example.cafemovoie.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>


}