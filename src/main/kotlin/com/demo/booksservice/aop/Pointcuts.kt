package com.demo.booksservice.aop

import org.aspectj.lang.annotation.Pointcut

class Pointcuts {

    @Pointcut("execution(* com.demo.booksservice.db.service.impl.BookServiceImpl.get*(..)) ")
    fun getMethodsHandler() {
    }

    @Pointcut("execution(* com.demo.booksservice.db.service.impl.BookServiceImpl.add*(..)) ")
    fun addMethodsHandler() {
    }

}