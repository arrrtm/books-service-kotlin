package com.demo.booksservice.util

enum class CustomResponseStatus(val code: Int, val message: String) {

    SUCCESS(0, "Success"),
    NOT_FOUND(1, "Not Found"),
    EXCEPTION(2, "Exception")

}