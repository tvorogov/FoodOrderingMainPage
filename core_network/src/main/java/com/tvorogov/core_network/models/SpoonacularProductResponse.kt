package com.tvorogov.core_network.models

data class SpoonacularProductResponse(
    val id: String,
    val title: String,
    val price: String,
    val breadcrumbs: List<String>,
    val description: String,
    val ingredientList: String,
    val images: List<String>

) {

}