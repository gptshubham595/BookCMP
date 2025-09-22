package com.android.bookcmp.book.presentation

import androidx.lifecycle.ViewModel
import com.android.bookcmp.book.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedBookViewModel : ViewModel() {

    private val _selectedBook = MutableStateFlow<Book?>(null)
    val selectedBook: StateFlow<Book?> = _selectedBook.asStateFlow()

    fun onSelectBook(book: Book?){
        _selectedBook.value = book
    }
}

