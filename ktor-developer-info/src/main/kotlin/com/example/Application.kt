package com.example

import com.example.db.createTable
import com.example.db.dbConnection
import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    dbConnection()
    createTable()
    configureSerialization()
    configureRouting()
}
