package com.tvorogov.core_data.mappers

import com.tvorogov.core_data.models.Product
import com.tvorogov.core_db.models.entitity.ProductDB
import com.tvorogov.core_network.models.SpoonacularProductResponse


fun SpoonacularProductResponse.toProduct(): Product = Product(
    id = id.toInt(),
    title = title,
    price = price.toFloat(),
    breadcrumbs = breadcrumbs.first(),
    description = description,
    ingredientList = ingredientList,
    images = images.first()
)

fun Product.toDB(): ProductDB = ProductDB(
    id = id,
    title = title,
    price = price,
    breadcrumbs = breadcrumbs,
    description = description,
    ingredientList = ingredientList,
    images = images
)

fun ProductDB.toProduct(): Product = Product(
    id = id,
    title = title,
    price = price,
    breadcrumbs = breadcrumbs,
    description = description,
    ingredientList = ingredientList,
    images = images
)
