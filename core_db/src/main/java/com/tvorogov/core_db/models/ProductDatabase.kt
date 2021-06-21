package com.tvorogov.core_db.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tvorogov.core_db.models.entitity.ProductDB

@Database(entities = [ProductDB::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}