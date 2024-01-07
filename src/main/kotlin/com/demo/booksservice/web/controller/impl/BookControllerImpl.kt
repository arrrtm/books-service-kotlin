package com.demo.booksservice.web.controller.impl

import com.demo.booksservice.db.service.BookService
import com.demo.booksservice.util.CustomResponseBody
import com.demo.booksservice.web.controller.BookController
import com.demo.booksservice.web.dto.BookDto
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class BookControllerImpl(private val bookService: BookService) : BookController {

    override fun getAll(): CustomResponseBody<List<BookDto>> {
        return this.bookService.getAll()
    }

    override fun getBookByTitle(title: String): CustomResponseBody<BookDto> {
        return this.bookService.getBookByTitle(title)
    }

    override fun addBook(book: BookDto): CustomResponseBody<BookDto> {
        return this.bookService.addBook(book)
    }

}