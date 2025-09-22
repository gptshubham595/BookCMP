package com.android.bookcmp.book.presentation.book_list

import com.android.bookcmp.core.presentation.UiText
import com.android.bookcmp.book.domain.Book
import kotlin.random.Random.Default.nextDouble

data class BookListState(
    val searchQuery: String = "",
    val searchResults: List<Book> = sampleBooks,
    val favouriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorText: UiText? = null,
)

val sampleBooks = (1..10).map {
    Book(
        id = it.toString(),
        title = "Sample Book Title $it",
        authors = listOf("Author One", "Author Two"),
        description = "This is a sample description of the book. It provides an overview of the content.",
        imageUrl = "https://via.placeholder.com/150",
        firstPublishYear = "2020",
        pageCount = 200,
        averageRating = nextDouble(1.0, 5.0),
        ratingsCount = 100,
        language = listOf("eng"),
        numEditions = 1
    )
}