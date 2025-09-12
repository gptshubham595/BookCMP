package com.android.bookcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform