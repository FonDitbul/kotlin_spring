package com.example.kotlin_spring.core.exception

import java.lang.RuntimeException

class InvalidInputException(
    message: String = "Invalid Input"
) : RuntimeException(message)
