package com.tvorogov.core_data

import com.tvorogov.core_data.models.Product


interface Repository {

    suspend fun getProductsByBreadcrumbs(breadcrumbs: String): List<Product>

    suspend fun getProductById(id: Int): Product

    suspend fun saveProduct(product: Product)
}