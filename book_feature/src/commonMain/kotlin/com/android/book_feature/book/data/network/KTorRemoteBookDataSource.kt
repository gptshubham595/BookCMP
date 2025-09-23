package com.android.book_feature.book.data.network

import com.android.book_feature.book.data.dto.SearchResponseDTO
import com.android.core.data.safeApiCall
import com.android.core.domain.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import com.android.core.domain.Result
private const val BASE_URL = "https://openlibrary.org/"

class KTorRemoteBookDataSource(
    private val httpClient: HttpClient
):RemoteBookDataSource {
    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDTO, DataError.RemoteError> {

        return safeApiCall {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ){
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter("fields", "key,title,langauge,cover_i,author_name,author_key,cover_edition_key,first_publish_year,ratings_average,ratings_count,number_of_pages_median,edition_count")
            }
        }
    }
}