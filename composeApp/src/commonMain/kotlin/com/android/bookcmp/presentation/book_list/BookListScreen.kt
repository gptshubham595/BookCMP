package com.android.bookcmp.presentation.book_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreenRoot(
    viewmodel: BookListViewmodel = koinViewModel(),
    onBookClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val state by viewmodel.state.collectAsStateWithLifecycle()

    BookListScreen(
        state,
        { action ->
            when (action) {
                is BookListAction.OnBookClicked -> onBookClicked(action.bookId)
                else -> Unit
            }
            viewmodel.onAction(action)
        },
        modifier
    )

}

@Composable
fun BookListScreen(
    state: BookListState,
    onAction: (BookListAction) -> Unit = {},
    modifier: Modifier
) {

}
