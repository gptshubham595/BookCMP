package com.android.book_feature.book.presentation.nav

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object BookList : Route

    @Serializable
    data class BookDetails(val bookId: String) : Route

    @Serializable
    data object BookGraph: Route
}