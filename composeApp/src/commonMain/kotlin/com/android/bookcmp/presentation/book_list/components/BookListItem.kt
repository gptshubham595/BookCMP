package com.android.bookcmp.presentation.book_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import bookcmp.composeapp.generated.resources.Res
import bookcmp.composeapp.generated.resources.book_error
import coil3.compose.rememberAsyncImagePainter
import com.android.bookcmp.core.domain.Book
import com.android.bookcmp.presentation.ui.Dimens
import com.android.bookcmp.presentation.ui.LightBlue
import org.jetbrains.compose.resources.painterResource

@Composable
fun BookListItem(
    book: Book,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Surface(
        shape = RoundedCornerShape(Dimens.dp_32),
        modifier = modifier.clickable { onClick },
        color = LightBlue.copy(alpha = 0.2f)
    ) {
        Row(
            modifier = Modifier
                .padding(Dimens.dp_16)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Box(
                modifier = Modifier
                    .height(Dimens.dp_100),
                contentAlignment = Alignment.Center
            ) {
                var imageLoadResult by remember { mutableStateOf<Result<Painter>?>(null) }
                val painter = rememberAsyncImagePainter(
                    model = book.imageUrl,
                    onSuccess = {
                        if (it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                            Result.success(it.painter)
                        } else {
                            Result.failure(Exception("Image load failed: Invalid Image Size!"))
                        }
                    },
                    onError = {
                        it.result.throwable.printStackTrace()
                        imageLoadResult = Result.failure(it.result.throwable)
                    }
                )

                when (val result = imageLoadResult) {
                    null -> CircularProgressIndicator()
                    else -> Image(
                        painter = if (result.isSuccess) painter else painterResource(Res.drawable.book_error),
                        contentDescription = "Book image",
                        contentScale = if (result.isSuccess) ContentScale.Crop else ContentScale.Fit,
                        modifier = Modifier.aspectRatio(
                            ratio = 0.65F,
                            matchHeightConstraintsFirst = true
                        )
                    )
                }

            }

        }
    }

}