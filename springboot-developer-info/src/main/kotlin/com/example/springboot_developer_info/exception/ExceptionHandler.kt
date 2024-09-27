package com.example.springboot_developer_info.exception

import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ChangeSetPersister.NotFoundException::class)
    fun handleNotFoundException(e: ChangeSetPersister.NotFoundException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.message)
    }
}