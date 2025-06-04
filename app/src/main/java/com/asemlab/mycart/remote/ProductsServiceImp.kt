package com.asemlab.mycart.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse


class ProductsServiceImp(private val client: HttpClient) : ProductsService {

    override suspend fun getCategories(): HttpResponse {
        return client.get(Routes.CATEGORIES_ENDPOINT)
    }

    override suspend fun getProducts(): HttpResponse {

        return client.get(Routes.PRODUCTS_ENDPOINT)
    }
}