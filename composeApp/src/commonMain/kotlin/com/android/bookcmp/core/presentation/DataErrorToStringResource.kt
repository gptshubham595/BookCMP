package com.android.bookcmp.core.presentation

import bookcmp.composeapp.generated.resources.Res
import bookcmp.composeapp.generated.resources.disk_full
import bookcmp.composeapp.generated.resources.no_internet
import bookcmp.composeapp.generated.resources.request_timeout
import bookcmp.composeapp.generated.resources.serialization_error
import bookcmp.composeapp.generated.resources.server_error
import bookcmp.composeapp.generated.resources.too_many_request
import bookcmp.composeapp.generated.resources.unknown_error
import com.android.bookcmp.core.domain.DataError

fun DataError.toUiText(): UiText {
    val stringRes = when (this) {
        DataError.LocalError.DISK_FULL -> Res.string.disk_full
        DataError.LocalError.UNKNOWN -> Res.string.unknown_error

        DataError.RemoteError.TOO_MANY_REQUEST -> Res.string.too_many_request
        DataError.RemoteError.NO_INTERNET -> Res.string.no_internet
        DataError.RemoteError.SERVER -> Res.string.server_error
        DataError.RemoteError.SERIALIZATION -> Res.string.serialization_error
        DataError.RemoteError.UNKNOWN -> Res.string.unknown_error
        DataError.RemoteError.REQUEST_TIMEOUT -> Res.string.request_timeout
    }

    return UiText.StringResourceId(stringRes)
}
