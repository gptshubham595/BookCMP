package com.android.bookcmp.di

import com.android.bookcmp.book.data.network.KTorRemoteBookDataSource
import com.android.bookcmp.book.data.network.RemoteBookDataSource
import com.android.bookcmp.book.data.repository.DefaultBookRepository
import com.android.bookcmp.book.domain.repository.BookRepository
import com.android.bookcmp.book.presentation.book_list.BookListViewmodel
import com.android.bookcmp.core.data.HTTPClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

// for platform specific dependencies
expect val platformModule: Module

val sharedModule = module {
    single { HTTPClientFactory.create(get()) }
    singleOf(::KTorRemoteBookDataSource).bind<RemoteBookDataSource>() // instead of single { KTorRemoteBookDataSource(get(), get(), get() ) }
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewmodel)
}