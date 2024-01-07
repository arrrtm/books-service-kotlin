package com.demo.booksservice.aop

import com.demo.booksservice.util.CustomResponseBody
import com.demo.booksservice.util.CustomResponseStatus
import com.demo.booksservice.web.dto.BookDto
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.stereotype.Component

@Aspect
@Component
class BookAspect {

    @Around("Pointcuts.getMethodsHandler()")
    fun aroundGettingAdvice(joinPoint: ProceedingJoinPoint): Any {
        var title: Any? = null;
        val methodSignature = joinPoint.signature as MethodSignature
        if (methodSignature.name == "getAll") {
            log.info("try get all books")
        } else if (methodSignature.name == "getBookByTitle") {
            title = joinPoint.args
            log.info(String.format("try get book by title %s", title))
        }

        val bookResult: Any = try {
            joinPoint.proceed()
        } catch (nsex: NoSuchElementException) {
            log.error(String.format("ERROR: %s", nsex.localizedMessage))
            return CustomResponseBody(CustomResponseStatus.NOT_FOUND, null)
        } catch (ex: Throwable) {
            log.error(String.format("ERROR: %s", ex.localizedMessage))
            CustomResponseBody(CustomResponseStatus.EXCEPTION, ex.localizedMessage)
        }

        if (methodSignature.name == "getAll") {
            log.info(String.format("list of books: %s", bookResult))
        } else if (methodSignature.name == "getBookByTitle") {
            log.info(String.format("book with title %s is found: %s", title, bookResult))
        }
        return bookResult

    }

    @Around("Pointcuts.addMethodsHandler()")
    fun aroundAddingAdvice(joinPoint: ProceedingJoinPoint): Any {
        val methodSignature = joinPoint.signature as MethodSignature
        if (methodSignature.name == "addBook") {
            val arguments = joinPoint.args
            for (arg in arguments) {
                if (arg is BookDto) {
                    log.info(String.format("save book object: %s", arg))
                }
            }
        }

        val result: Any = try {
            joinPoint.proceed()
        } catch (ex: Throwable) {
            log.error(String.format("ERROR: %s", ex.localizedMessage))
            CustomResponseBody(CustomResponseStatus.EXCEPTION, ex.localizedMessage)
        }
        return result

    }

}