package com.example.db

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.dbConnection() {
    try {
        Database.connect(
            url = "jdbc:mysql://localhost:3306/ktorDemo",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "123456" // Consider storing sensitive data like this in environment variables
        )
        log.info("Database connection established successfully.")
    } catch (e: Exception) {
        log.error("Database connection failed: ${e.localizedMessage}")
        throw e // Rethrow to stop application if DB connection fails
    }
}