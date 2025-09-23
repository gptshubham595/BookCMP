package com.android.core.di

import com.android.core.data.HTTPClientFactory
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val coreModule = module {
    single<HttpClient> { HTTPClientFactory.create(get()) }
}
