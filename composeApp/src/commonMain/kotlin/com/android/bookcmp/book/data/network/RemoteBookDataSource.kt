package com.android.bookcmp.book.data.network

import com.android.bookcmp.core.domain.DataError
import com.android.bookcmp.core.domain.Result
import com.android.bookcmp.book.data.dto.SearchResponseDTO

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDTO, DataError.RemoteError>
}