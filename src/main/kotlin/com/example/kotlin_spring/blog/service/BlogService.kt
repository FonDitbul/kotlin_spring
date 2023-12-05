package com.example.kotlin_spring.blog.service

import com.example.kotlin_spring.blog.dto.BlogDto
import com.example.kotlin_spring.core.exception.InvalidInputException
import org.springframework.stereotype.Service

@Service
class BlogService {
    fun search(blogDto: BlogDto): String? {
        val msgList = mutableListOf<ExceptionMsg>()

        if (blogDto.query.trim().isEmpty()) {
            msgList.add(ExceptionMsg.EMPTY_QUERY)
        }

        if (blogDto.sort.trim() !in arrayOf("accuracy", "recency")) {
            msgList.add(ExceptionMsg.NOT_IN_SORT)
        }

        when {
            blogDto.page < 1 -> msgList.add(ExceptionMsg.LESS_THAN_MIN)
            blogDto.page > 50 -> msgList.add(ExceptionMsg.MORE_THAN_MAX)
        }

        if (msgList.isNotEmpty()) {
            val message = msgList.joinToString { it.msg }
            throw InvalidInputException(message)
        }

        println(blogDto.toString())
        return "Search"
    }
}

private enum class ExceptionMsg(val msg: String) {
    EMPTY_QUERY("query parameter required"),
    NOT_IN_SORT("sort parameter one of accuracy and recency"),
    LESS_THAN_MIN("page is less than min"),
    MORE_THAN_MAX("page is more than max")
}
