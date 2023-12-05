package com.example.kotlin_spring.blog.service

import com.example.kotlin_spring.blog.dto.BlogDto
import org.springframework.stereotype.Service

@Service
class BlogService {
    fun search(blogDto: BlogDto): String? {
        println(blogDto)
        return "Search"
    }
}