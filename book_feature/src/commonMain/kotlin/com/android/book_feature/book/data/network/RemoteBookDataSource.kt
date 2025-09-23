package com.android.book_feature.book.data.network

import com.android.book_feature.book.data.dto.SearchResponseDTO
import com.android.core.domain.DataError
import com.android.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDTO, DataError.RemoteError>
}