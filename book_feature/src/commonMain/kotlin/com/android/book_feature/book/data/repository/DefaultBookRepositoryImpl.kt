package com.android.book_feature.book.data.repository

import com.android.core.domain.DataError
import com.android.core.domain.Result
import com.android.core.domain.map
import com.android.book_feature.book.data.dto.SearchResponseDTO
import com.android.book_feature.book.data.mappers.toBook
import com.android.book_feature.book.data.network.RemoteBookDataSource
import com.android.book_feature.book.domain.Book
import com.android.book_feature.book.domain.repository.BookRepository

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