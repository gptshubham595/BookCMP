package com.android.bookcmp.book.presentation.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bookcmp.composeapp.generated.resources.Res
import bookcmp.composeapp.generated.resources.favorites
import bookcmp.composeapp.generated.resources.no_fav_results
import bookcmp.composeapp.generated.resources.no_search_results
import bookcmp.composeapp.generated.resources.search_results
import com.android.bookcmp.book.presentation.book_list.components.BookSearchBar
import com.android.bookcmp.core.presentation.DarkBlue
import com.android.bookcmp.core.presentation.DesertWhite
import com.android.bookcmp.core.presentation.Dimens
import com.android.bookcmp.core.presentation.SandYellow
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreenRoot(
    viewmodel: BookListViewmodel = koinViewModel(),
    onBookClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val state by viewmodel.state.collectAsStateWithLifecycle()

    BookListScreen(
        state, { action ->
            when (action) {
                is BookListAction.OnBookClicked -> onBookClicked(action.bookId)
                else -> Unit
            }
            viewmodel.onAction(action)
        }, modifier
    )

}

@Composable
fun BookListScreen(
    state: BookListState, onAction: (BookListAction) -> Unit = {}, modifier: Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val pagerState = rememberPagerState { 2 }

    val searchResultsListState = rememberLazyListState()
    val favResultsListState = rememberLazyListState()

    LaunchedEffect(state.searchResults) {
        searchResultsListState.animateScrollToItem(0)
    }

    LaunchedEffect(state.favouriteBooks) {
        favResultsListState.animateScrollToItem(0)
    }

    LaunchedEffect(state.selectedTabIndex) {
        pagerState.animateScrollToPage(state.selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
        onAction(BookListAction.OnTabSelected(pagerState.currentPage))
    }

    Column(
        modifier = Modifier.fillMaxSize().background(DarkBlue).statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BookSearchBar(
            state.searchQuery, {
                onAction(BookListAction.OnSearchQueryChange(it))
            }, {
                keyboardController?.hide()
            }, modifier = Modifier.widthIn(max = Dimens.dp_400).fillMaxWidth().padding(Dimens.dp_16)
        )
        Surface(
            modifier = Modifier.weight(1F).fillMaxWidth(),
            color = DesertWhite,
            shape = RoundedCornerShape(
                topStart = Dimens.dp_32, topEnd = Dimens.dp_32
            )
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TabRow(
                    selectedTabIndex = state.selectedTabIndex,
                    modifier = Modifier.padding(vertical = Dimens.dp_12)
                        .widthIn(max = Dimens.dp_700).fillMaxWidth(),
                    containerColor = DesertWhite,
                    contentColor = SandYellow,
                    indicator = { tabs ->
                        TabRowDefaults.SecondaryIndicator(
                            color = SandYellow,
                            modifier = Modifier.tabIndicatorOffset(tabs[state.selectedTabIndex])
                        )
                    }) {
                    Tab(
                        selected = state.selectedTabIndex == 0,
                        onClick = {
                            onAction(BookListAction.OnTabSelected(0))
                        },
                        text = {
                            Text(text = stringResource(Res.string.search_results))
                        },
                        modifier = Modifier.weight(1F),
                        selectedContentColor = SandYellow,
                        unselectedContentColor = Color.Black.copy(alpha = 0.5F)
                    )

                    Tab(
                        selected = state.selectedTabIndex == 1,
                        onClick = {
                            onAction(BookListAction.OnTabSelected(1))
                        },
                        text = {
                            Text(text = stringResource(Res.string.favorites))
                        },
                        modifier = Modifier.weight(1F),
                        selectedContentColor = SandYellow,
                        unselectedContentColor = Color.Black.copy(alpha = 0.5F)
                    )
                }

                Spacer(modifier = Modifier.height(Dimens.dp_4))
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize().weight(1F),
                ) { pagerIndex ->
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        when (pagerIndex) {
                            0 -> if (state.isLoading) {
                                CircularProgressIndicator()
                            } else {
                                when {
                                    state.errorText != null -> {
                                        Text(
                                            text = state.errorText.asString(),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }

                                    state.searchResults.isEmpty() -> {
                                        Text(
                                            text = stringResource(Res.string.no_search_results),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }

                                    else -> {
                                        BookList(
                                            books = state.searchResults,
                                            onBookClick = { book ->
                                                onAction(BookListAction.OnBookClicked(book.id))
                                            },
                                            modifier = modifier.padding(top = Dimens.dp_12),
                                            scrollState = searchResultsListState
                                        )
                                    }
                                }
                            }


                            1 -> if (state.isLoading) {
                                CircularProgressIndicator()
                            } else {
                                when {
                                    state.favouriteBooks.isEmpty() -> {
                                        Text(
                                            text = stringResource(Res.string.no_fav_results),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.headlineSmall,
                                        )
                                    }

                                    else -> BookList(
                                        books = state.favouriteBooks,
                                        onBookClick = { book ->
                                            onAction(BookListAction.OnBookClicked(book.id))
                                        },
                                        modifier = modifier.padding(top = Dimens.dp_12),
                                        scrollState = favResultsListState
                                    )
                                }
                            }

                        }
                    }
                }
            }

        }
    }
}
