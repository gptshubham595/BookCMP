package com.android.book_feature.book.data.mappers

import com.android.book_feature.book.data.dto.SearchBookDTO
import com.android.book_feature.book.domain.Book

fun SearchBookDTO.toBook(): Book =
    Book(
        id = this.id.substringAfterLast("/"),
        title = this.title,
        imageUrl = coverEditionKey?.let {
            "https://covers.openlibrary.org/b/olid/${this.coverEditionKey}-L.jpg"
        }
            ?: "https://covers.openlibrary.org/b/olid/${this.coverAlternativeKey}-L.jpg",
        authors = this.authorName ?: emptyList(),
        firstPublishYear = this.firstPublishYear?.toString(),
        description = null,
        language = this.language ?: emptyList(),
        pageCount = this.numberOfPagesMedian,
        averageRating = this.ratingAverage,
        numEditions = this.editionCount,
        ratingsCount = this.ratingsCount,
    )