package com.demo.booksservice.util

import com.demo.booksservice.db.entity.BookEntity
import com.demo.booksservice.web.dto.BookDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface BookMapper {

    fun toBookDto(bookEntity: BookEntity): BookDto

    @Mapping(target = "id", ignore = true)
    fun toBookEntity(bookDto: BookDto): BookEntity

}