package com.tvorogov.core_data.di

import com.tvorogov.core_data.Repository
import com.tvorogov.core_data.RepositoryImpl
import com.tvorogov.core_db.models.ProductDatabase
import com.tvorogov.core_network.SpoonacularApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideRepository(
        productDatabase: ProductDatabase,
        spoonacularApi: SpoonacularApi
    ): Repository {
        return RepositoryImpl(productDatabase, spoonacularApi)
    }
}