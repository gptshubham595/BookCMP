package com.android.bookcmp.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchBookDTO(
    @SerialName("author_key")
    val authorKey: List<String>? = null,
    @SerialName("author_name")
    val authorName: List<String>? = null,
    @SerialName("cover_edition_key")
    val coverEditionKey: String? = null,
    @SerialName("cover_i")
    val coverAlternativeKey: Int? = null,
    @SerialName("edition_count")
    val editionCount: Int? = null,
    @SerialName("number_of_pages_median")
    val numberOfPagesMedian: Int? = null,
    @SerialName("ratings_average")
    val ratingAverage: Double? = null,
    @SerialName("ratings_count")
    val ratingsCount: Int? = null,
    @SerialName("first_publish_year")
    val firstPublishYear: Int? = null,
    @SerialName("language")
    val language: List<String>? = null,
    @SerialName("title")
    val title: String,
    @SerialName("key")
    val id: String,
)