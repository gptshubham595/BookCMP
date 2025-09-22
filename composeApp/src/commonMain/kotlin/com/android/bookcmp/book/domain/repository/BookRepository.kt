package com.android.bookcmp.book.domain.repository

import com.android.bookcmp.core.domain.DataError
import com.android.bookcmp.core.domain.Result
import com.android.bookcmp.book.domain.Book

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.RemoteError>
}