package com.example.cafemovoie.di

import android.app.Application
import androidx.room.Room
import com.example.cafemovoie.data.api.MovieApiService
import com.example.cafemovoie.data.db.MovieDatabase
import com.example.cafemovoie.utils.Constance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun providesMovieApi(): MovieApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constance.BASE_URL)
        .client(client)
        .build()
        .create(MovieApiService::class.java)

    @Provides
    @Singleton
    fun providesMovieDatabase(application: Application): MovieDatabase =
        Room.databaseBuilder(
            application,
            MovieDatabase::class.java,
            "movie.db"
        ).build()

}