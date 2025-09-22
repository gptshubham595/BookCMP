package com.android.bookcmp.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponseDTO(
    @SerialName("docs")
    val result: List<SearchBookDTO>?,
)