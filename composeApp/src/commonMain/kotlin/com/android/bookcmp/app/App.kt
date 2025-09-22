package com.android.bookcmp.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.android.bookcmp.book.presentation.book_list.BookListScreenRoot
import com.android.bookcmp.book.presentation.book_list.BookListViewmodel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = Route.BookGraph
    ) {
        navigation<Route.BookGraph>(
            startDestination = Route.BookList
        ) {
            composable<Route.BookList> {
                val viewmodel = koinViewModel<BookListViewmodel>()
                BookListScreenRoot(
                    viewmodel = viewmodel,
                    onBookClicked = { bookId ->
                        navController.navigate(
                            Route.BookDetails(bookId = bookId)
                        )
                    },
                )
            }

            composable<Route.BookDetails> { entry ->
                val args = entry.toRoute<Route.BookDetails>()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Book Details for ${args.bookId}")
                }
            }
        }
    }

    MaterialTheme {

    }
}