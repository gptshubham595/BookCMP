package com.android.bookcmp.presentation.book_list

sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String) : BookListAction
    data class OnBookClicked(val bookId: String) : BookListAction
    data class OnTabSelected(val index: Int) : BookListAction
}