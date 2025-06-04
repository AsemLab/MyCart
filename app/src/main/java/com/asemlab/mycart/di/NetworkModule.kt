package com.asemlab.mycart.di

import com.asemlab.mycart.MainViewModel
import com.asemlab.mycart.data.ProductDao
import com.asemlab.mycart.remote.ProductsService
import com.asemlab.mycart.remote.ProductsServiceImp
import com.asemlab.mycart.remote.Routes
import com.asemlab.mycart.repositories.ProductsRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.gson.gson
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single<HttpClient> {
        HttpClient(Android) {
            install(ContentNegotiation) {
                gson {
                }
            }
            defaultRequest {
                url(Routes.BASE_URL)
                header("X-API-Key", "c29039e0")
            }
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.BODY
            }

        }
    }

    single<ProductsService> {
        ProductsServiceImp(get<HttpClient>())
    }

    single<ProductsRepository> {
        ProductsRepository(get<ProductsService>(), get<ProductDao>())
    }

    viewModel { MainViewModel(get<ProductsRepository>()) }

}