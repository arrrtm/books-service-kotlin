package com.demo.booksservice.db.dao

import com.demo.booksservice.db.entity.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BookRepository : JpaRepository<BookEntity, Long> {

    fun findFirstByTitle(title: String): Optional<BookEntity>

}