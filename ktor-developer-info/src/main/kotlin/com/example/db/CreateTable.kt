package com.example.db

import com.example.db.entity.DeveloperEntity
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.createTable() {
    transaction {
        SchemaUtils.create(DeveloperEntity)
    }
}