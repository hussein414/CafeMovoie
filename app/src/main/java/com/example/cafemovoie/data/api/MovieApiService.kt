package com.example.cafemovoie.data.api

import com.example.cafemovoie.data.model.dto.MovieListDto
import com.example.cafemovoie.utils.Constance
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET(Constance.END_POINT)
    suspend fun getMoviesList(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = Constance.API_KEY
    ): MovieListDto
}