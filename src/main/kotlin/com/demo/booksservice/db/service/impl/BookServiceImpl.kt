package com.demo.booksservice.db.service.impl

import com.demo.booksservice.db.dao.BookRepository
import com.demo.booksservice.db.entity.BookEntity
import com.demo.booksservice.db.service.BookService
import com.demo.booksservice.util.BookMapper
import com.demo.booksservice.util.CustomResponseBody
import com.demo.booksservice.util.CustomResponseStatus
import com.demo.booksservice.web.dto.BookDto
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val bookMapper: BookMapper
) : BookService {

    override fun getAll(): CustomResponseBody<List<BookDto>> {
        val books: List<BookEntity> = this.bookRepository.findAll()

        return if (books.isEmpty()) {
            CustomResponseBody(
                CustomResponseStatus.NOT_FOUND, emptyList()
            )
        } else CustomResponseBody(
            CustomResponseStatus.SUCCESS,
            books.stream().map { bookEntity: BookEntity ->
                bookMapper.toBookDto(bookEntity)
            }.toList()
        )
    }

    override fun getBookByTitle(title: String): CustomResponseBody<BookDto> {
        return CustomResponseBody(
            CustomResponseStatus.SUCCESS,
            bookMapper.toBookDto(this.bookRepository.findFirstByTitle(title).orElseThrow())
        )
    }

    override fun addBook(book: BookDto): CustomResponseBody<BookDto> {
        return CustomResponseBody(
            CustomResponseStatus.SUCCESS,
            bookMapper.toBookDto(this.bookRepository.save(bookMapper.toBookEntity(book)))
        )
    }

}