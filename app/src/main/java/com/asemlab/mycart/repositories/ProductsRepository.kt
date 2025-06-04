package com.asemlab.mycart.repositories

import com.asemlab.mycart.models.Category
import com.asemlab.mycart.models.Product
import com.asemlab.mycart.models.ServerResponse
import com.asemlab.mycart.remote.ProductsService
import com.asemlab.mycart.utils.performRequest

class ProductsRepository(private val productsService: ProductsService) {

    suspend fun getCategories(): ServerResponse<List<Category>> {
        return performRequest<List<Category>> {
            productsService.getCategories()
        }


    }

    suspend fun getProducts(): ServerResponse<List<Product>> {
        return performRequest<List<Product>> {
            productsService.getProducts()
        }
    }

}