package com.android.bookcmp.book.data.repository

import com.android.bookcmp.core.domain.DataError
import com.android.bookcmp.core.domain.Result
import com.android.bookcmp.core.domain.map
import com.android.bookcmp.book.data.dto.SearchResponseDTO
import com.android.bookcmp.book.data.mappers.toBook
import com.android.bookcmp.book.data.network.RemoteBookDataSource
import com.android.bookcmp.book.domain.Book
import com.android.bookcmp.book.domain.repository.BookRepository

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
) : BookRepository {
    override suspend fun searchBooks(
        query: String
    ): Result<List<Book>, DataError.RemoteError> {
        return remoteBookDataSource.searchBooks(query).map { dto: SearchResponseDTO ->
            dto.result?.map { it.toBook() } ?: emptyList()
        }
    }
}