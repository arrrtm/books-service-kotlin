package com.demo.booksservice

import com.demo.booksservice.db.dao.BookRepository
import com.demo.booksservice.db.entity.BookEntity
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BooksServiceApplication(private val bookRepository: BookRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        this.bookRepository.saveAllAndFlush(
            listOf(
                BookEntity(null, "1984", "George Orwell"),
                BookEntity(null, "A Confederacy of Dunces", "John Kennedy Toole"),
                BookEntity(null, "A Game of Thrones", "George R. R. Martin")
            )
        )
    }

}

fun main(args: Array<String>) {
    log.info("Book Service is Starting...")
    runApplication<BooksServiceApplication>(*args)
}