package com.android.core

actual fun platform() = "Java ${System.getProperty("java.version")}"