package com.demo.booksservice.db.service

import com.demo.booksservice.util.CustomResponseBody
import com.demo.booksservice.web.dto.BookDto

interface BookService {

    fun getAll(): CustomResponseBody<List<BookDto>>

    fun getBookByTitle(title: String): CustomResponseBody<BookDto>

    fun addBook(book: BookDto): CustomResponseBody<BookDto>

}