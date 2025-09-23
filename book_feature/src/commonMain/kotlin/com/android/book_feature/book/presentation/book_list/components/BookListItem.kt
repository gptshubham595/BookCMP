package com.android.book_feature.book.presentation.book_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import bookcmp.book_feature.generated.resources.Res
import bookcmp.book_feature.generated.resources.book_error
import coil3.compose.rememberAsyncImagePainter
import com.android.book_feature.book.domain.Book
import com.android.core.presentation.Dimens
import com.android.core.presentation.LightBlue
import com.android.core.presentation.SandYellow
import org.jetbrains.compose.resources.painterResource
import kotlin.math.round

@Composable
fun BookListItem(
    book: Book, onClick: () -> Unit, modifier: Modifier
) {
    Surface(
        shape = RoundedCornerShape(Dimens.dp_32),
        modifier = modifier.clickable { onClick },
        color = LightBlue.copy(alpha = 0.2f)
    ) {
        Row(
            modifier = Modifier.padding(Dimens.dp_16).fillMaxWidth().height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.height(Dimens.dp_100).padding(end = Dimens.dp_16),
                contentAlignment = Alignment.Center
            ) {
                var imageLoadResult by remember { mutableStateOf<Result<Painter>?>(null) }
                val painter = rememberAsyncImagePainter(model = book.imageUrl, onSuccess = {
                    if (it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                        imageLoadResult = Result.success(it.painter)
                    } else {
                        imageLoadResult =
                            Result.failure(Exception("Image load failed: Invalid Image Size!"))
                    }
                }, onError = {
                    it.result.throwable.printStackTrace()
                    imageLoadResult = Result.failure(it.result.throwable)
                })

                when (val result = imageLoadResult) {
                    null -> CircularProgressIndicator()
                    else -> Image(
                        painter =
                            if (result.isSuccess)
                                painter
                            else
                                painterResource(Res.drawable.book_error),
                        contentDescription = "Book image",
                        contentScale =
                            if (result.isSuccess)
                                ContentScale.Crop
                            else
                                ContentScale.Fit,
                        modifier = Modifier.aspectRatio(
                            ratio = 0.65F, matchHeightConstraintsFirst = true
                        )
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1F), verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                book.authors?.firstOrNull()?.let { authorName ->
                    Text(
                        text = authorName,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                book.averageRating?.let { rating ->
                    Row(
                        modifier = Modifier, verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${round((rating * 10) / 10.0)}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star Rating",
                            tint = SandYellow,
                        )
                    }
                }
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Right Arrow",
                modifier = Modifier.size(Dimens.dp_36)
            )

        }
    }

}