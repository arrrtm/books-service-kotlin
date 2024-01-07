package com.demo.booksservice.config

import com.demo.booksservice.util.BookMapper
import com.demo.booksservice.util.BookMapperImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    /**
     * For custom mapper realisation
     */
    @Bean
    fun bookMapper(): BookMapper {
        return BookMapperImpl()
    }

}