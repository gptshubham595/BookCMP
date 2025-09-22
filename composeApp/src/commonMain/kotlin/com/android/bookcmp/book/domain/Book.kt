package com.android.bookcmp.book.domain

data class Book(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val authors: List<String>?,
    val firstPublishYear: String?,
    val description: String?,
    val pageCount: Int?,
    val averageRating: Double?,
    val ratingsCount: Int?,
    val language: List<String>?,
    val numEditions: Int?,
)
