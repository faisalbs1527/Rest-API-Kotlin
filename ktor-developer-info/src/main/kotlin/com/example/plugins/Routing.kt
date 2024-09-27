package com.example.plugins

import com.example.model.*
import com.example.route.routeDeveloper
import io.ktor.server.application.*

fun Application.configureRouting() {
    val developerRepository = ExposedDeveloperRepository()
    routeDeveloper(developerRepository)
}
