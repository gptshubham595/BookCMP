package com.android.book_feature.book.presentation.book_list

import com.android.book_feature.book.domain.Book
import com.android.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favouriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorText: UiText? = null,
)