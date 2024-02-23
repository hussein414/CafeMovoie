package com.example.cafemovoie.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cafemovoie.data.model.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}