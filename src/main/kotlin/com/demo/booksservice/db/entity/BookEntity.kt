package com.demo.booksservice.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
data class BookEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @NotNull(message = "title can not be empty")
    @Size(min = 3, max = 30)
    val title: String,

    @NotNull(message = "author can not be empty")
    @Size(min = 3, max = 30)
    val author: String

) {
    constructor() : this(null, "", "")
}