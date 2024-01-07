package com.demo.booksservice.util

import com.demo.booksservice.db.entity.BookEntity
import com.demo.booksservice.web.dto.BookDto
import org.springframework.stereotype.Component

/**
 * Custom mapper realisation
 */
@Component
class BookMapperImpl : BookMapper {

    override fun toBookDto(bookEntity: BookEntity): BookDto {
        return BookDto(bookEntity.title, bookEntity.author)
    }

    override fun toBookEntity(bookDto: BookDto): BookEntity {
        return BookEntity(0, bookDto.title, bookDto.author)
    }

}