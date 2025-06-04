package com.asemlab.mycart.remote

import io.ktor.client.statement.HttpResponse


interface ProductsService {

    suspend fun getCategories(): HttpResponse

    suspend fun getProducts(): HttpResponse

}