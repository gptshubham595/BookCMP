package com.android.bookcmp.di

import com.android.book_feature.di.bookModule
import com.android.core.di.coreModule
import com.android.core.di.platformModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(platformModule, coreModule, bookModule)
    }
}