package com.demo.booksservice.util

data class CustomResponseBody<T>(

    val status: CustomResponseStatus,
    val body: T?

)