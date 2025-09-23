package com.android.book_feature.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponseDTO(
    @SerialName("docs")
    val result: List<SearchBookDTO>?,
)