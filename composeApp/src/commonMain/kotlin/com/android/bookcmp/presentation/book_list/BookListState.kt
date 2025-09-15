package com.android.bookcmp.presentation.book_list

import com.android.bookcmp.core.domain.Book

data class BookListState(
    val searchQuery: String = "",
    val searchResults: List<Book> = emptyList(),
    val favouriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorText: String? = null,
)