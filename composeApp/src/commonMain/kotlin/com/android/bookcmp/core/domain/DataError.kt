package com.android.bookcmp.core.domain

sealed interface DataError: IFailure {
    enum class RemoteError: DataError{
        REQUEST_TIMEOUT,
        TOO_MANY_REQUEST,
        NO_INTERNET,
        SERVER,
        SERIALIZATION,
        UNKNOWN
    }

    enum class LocalError: DataError {
        DISK_FULL,
        UNKNOWN
    }
}