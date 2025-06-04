package com.asemlab.mycart.repositories

import com.asemlab.mycart.data.ProductDao
import com.asemlab.mycart.models.Category
import com.asemlab.mycart.models.Product
import com.asemlab.mycart.models.ServerResponse
import com.asemlab.mycart.models.onSuccess
import com.asemlab.mycart.remote.ProductsService
import com.asemlab.mycart.utils.performRequest

class ProductsRepository(
    private val productsService: ProductsService,
    private val productDao: ProductDao
) {

    suspend fun getCategories(): ServerResponse<List<Category>> {

        val categories = productDao.getAllCategories()

        return if (categories.isEmpty())
            performRequest<List<Category>> {
                productsService.getCategories()
            }.onSuccess {
                addCategories(it)
            }
        else
            ServerResponse.Success(categories)

    }

    suspend fun getProducts(): ServerResponse<List<Product>> {
        val products = productDao.getAllProducts()

        return if (products.isEmpty())
            performRequest<List<Product>> {
                productsService.getProducts()
            }.onSuccess {
                addProducts(it)
            }
        else {
            ServerResponse.Success(products)
        }
    }

    suspend fun addCategories(list: List<Category>) {
        productDao.addCategories(list)
    }

    suspend fun addProducts(list: List<Product>) {
        productDao.addProducts(list)
    }

}