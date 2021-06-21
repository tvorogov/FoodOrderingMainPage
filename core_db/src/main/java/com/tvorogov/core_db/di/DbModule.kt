package com.tvorogov.core_db.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.tvorogov.core_db.models.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Provides
    @Singleton
    fun providesProductDatabase(app: Application): ProductDatabase {
        return Room.databaseBuilder(app, ProductDatabase::class.java, "product_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}