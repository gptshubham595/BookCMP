package com.android.book_feature.book.domain.repository

import com.android.core.domain.DataError
import com.android.core.domain.Result
import com.android.book_feature.book.domain.Book

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.RemoteError>
}