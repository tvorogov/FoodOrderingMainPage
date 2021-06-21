package com.tvorogov.core_data.models


data class Product(
    val id: Int = 0,
    val title: String,
    val price: Float,
    val breadcrumbs: String,
    val description: String,
    val ingredientList: String,
    val images: String
) {
}