package com.android.book_feature.di

import com.android.book_feature.book.data.network.KTorRemoteBookDataSource
import com.android.book_feature.book.data.network.RemoteBookDataSource
import com.android.book_feature.book.data.repository.DefaultBookRepository
import com.android.book_feature.book.domain.repository.BookRepository
import com.android.book_feature.book.presentation.book_list.BookListViewmodel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val bookModule = module {
    singleOf(::KTorRemoteBookDataSource).bind<RemoteBookDataSource>() // instead of single { KTorRemoteBookDataSource(get(), get(), get() ) }
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewmodel)
}
