package com.android.bookcmp.book.presentation.book_list

import com.android.bookcmp.core.presentation.UiText
import com.android.bookcmp.book.domain.Book
import kotlin.random.Random.Default.nextDouble

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favouriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorText: UiText? = null,
)