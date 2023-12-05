package com.example.kotlin_spring.blog.repository

import com.example.kotlin_spring.blog.entity.Wordcount
import org.springframework.data.repository.CrudRepository

interface WordRepository: CrudRepository<Wordcount, String>{
    fun findTop10ByOrderByCntDesc(): List<Wordcount>
}