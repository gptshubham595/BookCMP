package com.android.bookcmp.book.data.mappers

import com.android.bookcmp.book.data.dto.SearchBookDTO
import com.android.bookcmp.book.domain.Book

fun SearchBookDTO.toBook(): Book =
    Book(
        id = this.id,
        title = this.title,
        imageUrl = coverEditionKey?.let { "https://covers.openlibrary.org/b/olid/${this.coverEditionKey}-L.jpg" }
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