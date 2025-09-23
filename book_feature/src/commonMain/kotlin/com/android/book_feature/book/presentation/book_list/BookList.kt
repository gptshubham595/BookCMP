package com.android.book_feature.book.presentation.book_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.book_feature.book.domain.Book
import com.android.book_feature.book.presentation.book_list.components.BookListItem
import com.android.core.presentation.Dimens

@Composable
fun BookList(
    books: List<Book>,
    onBookClick: (Book) -> Unit,
    modifier: Modifier = Modifier,
    scrollState: LazyListState = rememberLazyListState(),
) {
    LazyColumn(
        modifier = modifier,
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(Dimens.dp_12),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(books, key = {
            it.id
        }) { book ->
            BookListItem(
                book,
                onClick = { onBookClick(book) },
                modifier = Modifier
                    .widthIn(max = Dimens.dp_700)
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.dp_16)
            )
        }
    }
}


