package com.tvorogov.core_db.models.entitity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductDB(
    @PrimaryKey val id: Int = 0,
    val title: String,
    val price: Float,
    val breadcrumbs: String,
    val description: String,
    val ingredientList: String,
    val images: String
) {
}