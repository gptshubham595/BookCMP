package com.android.boomcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform