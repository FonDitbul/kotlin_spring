package com.example.kotlin_spring.core.exception.response

data class ErrorResponse (
    val message: String,
    val errorType: String = "Invalid Argument"
)