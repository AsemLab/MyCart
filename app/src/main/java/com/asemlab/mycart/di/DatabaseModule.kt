package com.asemlab.mycart.di

import androidx.room.Room
import com.asemlab.mycart.data.ProductDB
import com.asemlab.mycart.data.ProductDao
import org.koin.dsl.module


val databaseModule = module {

    single<ProductDB> {
        Room.databaseBuilder(
            get(),
            ProductDB::class.java,
            "products_db"
        ).build()
    }

    single<ProductDao> {
        get<ProductDB>().getProductDao()
    }

}