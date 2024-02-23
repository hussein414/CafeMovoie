package com.example.cafemovoie.data.repository

import com.example.cafemovoie.data.api.MovieApiService
import com.example.cafemovoie.data.db.MovieDatabase
import com.example.cafemovoie.data.mapper.toMovie
import com.example.cafemovoie.data.mapper.toMovieEntity
import com.example.cafemovoie.data.model.Movie
import com.example.cafemovoie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieApiService: MovieApiService,
    private val movieDatabase: MovieDatabase
) : MovieListRepository {
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> =
        flow {
            emit(Resource.Loading(true))
            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)
            val shouldLocalMovie = localMovieList.isNotEmpty() && !forceFetchFromRemote
            if (shouldLocalMovie) {
                emit(
                    Resource.Success(data = localMovieList.map { movieEntity ->
                        movieEntity.toMovie(category)
                    })
                )
                emit(Resource.Loading(true))
                return@flow
            }
            val movieListFromApi = try {
                movieApiService.getMoviesList(category, page)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error Loading Movies"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error Loading Movies"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error Loading Movies"))
                return@flow
            }
            val movieEntity = movieListFromApi.results.let {
                it.map { movieDto ->
                    movieDto.toMovieEntity(category)
                }
            }
            movieDatabase.movieDao.upsertMovieList(movieEntity)
            emit(Resource.Success(movieEntity.map {
                it.toMovie(category)
            }))
            emit(Resource.Loading(false))
        }
}