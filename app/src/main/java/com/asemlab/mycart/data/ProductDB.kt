package com.asemlab.mycart.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.asemlab.mycart.data.converters.CategoryTypeConverter
import com.asemlab.mycart.models.Category
import com.asemlab.mycart.models.Product

@Database(entities = [Category::class, Product::class], exportSchema = false, version = 1)
@TypeConverters(value = [CategoryTypeConverter::class])
abstract class ProductDB : RoomDatabase() {

    abstract fun getProductDao(): ProductDao

}