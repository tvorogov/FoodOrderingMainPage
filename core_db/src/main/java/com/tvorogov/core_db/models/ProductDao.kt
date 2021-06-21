package com.tvorogov.core_db.models

import androidx.room.*
import com.tvorogov.core_db.models.entitity.ProductDB

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    suspend fun getAllProducts(): List<ProductDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(productDB: ProductDB)

    @Query("DELETE FROM product WHERE id = :id")
    suspend fun delete(id: Int)
}