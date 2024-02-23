package com.example.cafemovoie.data.model.dto

import com.example.cafemovoie.data.model.dto.MovieDto
import com.google.gson.annotations.SerializedName

data class MovieListDto(
    val page: Int,
    val results: List<MovieDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
