package com.demo.booksservice.web.controller

import com.demo.booksservice.util.CustomResponseBody
import com.demo.booksservice.web.dto.BookDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface BookController {

    @GetMapping("books")
    fun getAll(): CustomResponseBody<List<BookDto>>

    @GetMapping("books/{title}")
    fun getBookByTitle(@PathVariable("title") title: String): CustomResponseBody<BookDto>

    @PostMapping("books")
    fun addBook(@RequestBody book: BookDto): CustomResponseBody<BookDto>

}