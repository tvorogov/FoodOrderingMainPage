package com.tvorogov.core_network

import com.tvorogov.core_network.models.SpoonacularProductResponse
import com.tvorogov.core_network.models.SpoonacularSearchResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

import retrofit2.http.Query

interface SpoonacularApi {

    companion object {
        const val BASE_URL = "https://api.spoonacular.com/"
        const val API_KEY = "54fbfdf0eb0b4e72a828a5834e127479"
    }



    @GET("food/products/search")
    suspend fun searchByBreadcrumbs(
        @Query("query") query: String,
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String = API_KEY

    ): SpoonacularSearchResponse

//    @Headers("apiKey=$API_KEY")
    @GET("food/products/{id}")
    suspend fun searchByProductId(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): SpoonacularProductResponse
}