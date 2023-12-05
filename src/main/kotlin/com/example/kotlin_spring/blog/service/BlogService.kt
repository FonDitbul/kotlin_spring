package com.example.kotlin_spring.blog.service

import com.example.kotlin_spring.blog.dto.BlogDto
import com.example.kotlin_spring.blog.entity.Wordcount
import com.example.kotlin_spring.blog.repository.WordRepository
import org.springframework.stereotype.Service

@Service
class BlogService (
    val wordRepository: WordRepository
){
    fun search(blogDto: BlogDto): String? {

        val lowQuery: String = blogDto.query.lowercase()
        val word: Wordcount = wordRepository.findById(lowQuery).orElse(Wordcount(lowQuery))
        word.cnt++

        wordRepository.save(word)

        println(blogDto.toString())
        return "Search"
    }

    fun searchWordRank(): List<Wordcount> = wordRepository.findTop10ByOrderByCntDesc()
}
