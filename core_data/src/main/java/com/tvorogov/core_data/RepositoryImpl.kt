package com.tvorogov.core_data

import android.util.Log
import com.tvorogov.core_data.mappers.toDB
import com.tvorogov.core_data.mappers.toProduct
import com.tvorogov.core_data.models.Product
import com.tvorogov.core_db.models.ProductDatabase
import com.tvorogov.core_db.models.entitity.ProductDB
import com.tvorogov.core_network.SpoonacularApi
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val productDatabase: ProductDatabase,
    private val spoonacularApi: SpoonacularApi
) : Repository {

    override suspend fun getProductsByBreadcrumbs(breadcrumbs: String): List<Product> {


        val searchResponse = spoonacularApi.searchByBreadcrumbs(breadcrumbs, 5)

//        val productList: List<Product>

        for (product in searchResponse.products) {
            saveProduct(getProductById(product.id))
        }

        return productDatabase.productDao().getAllProducts().map {
            it.toProduct()
        }

    }

    override suspend fun getProductById(id: Int): Product {

        return spoonacularApi.searchByProductId(id).toProduct()
    }

    override suspend fun saveProduct(product: Product) {

        productDatabase.productDao().insertAll(product.toDB())
    }
}