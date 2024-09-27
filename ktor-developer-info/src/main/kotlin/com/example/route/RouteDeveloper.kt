package com.example.route

import com.example.model.*
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.routeDeveloper(developerRepository: DeveloperRepository) {
    routing {
        route("/developers") {
            get {
                val developers = developerRepository.getAllDevelopers()
                call.respond(developers)
            }

            get("/{id}") {
                val id = call.parameters["id"]
                val developer = id?.let { developerRepository.getDeveloperById(it) }
                if (developer != null) {
                    call.respond(developer)
                } else {
                    call.respond(HttpStatusCode.NotFound, "Developer not found")
                }
            }

            get("/bySbu/{sbuName}") {
                val sbuAsText = call.parameters["sbuName"]
                if (sbuAsText == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }
                try {
                    val sbu = SBU.valueOf(sbuAsText)
                    val developers = developerRepository.getDevelopersBySBU(sbu)

                    if (developers.isEmpty()) {
                        call.respond(HttpStatusCode.NotFound)
                        return@get
                    }

                    call.respond(developers)

                } catch (ex: IllegalArgumentException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            get("/byTech/{techName}") {
                val techAsText = call.parameters["techName"]
                if (techAsText == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }
                try {
                    val tech = Tech.valueOf(techAsText)
                    val developers = developerRepository.getDevelopersByTech(tech)

                    if (developers.isEmpty()) {
                        call.respond(HttpStatusCode.NotFound)
                        return@get
                    }

                    call.respond(developers)

                } catch (ex: IllegalArgumentException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            get("/byDesignation/{designation}") {
                val designationAsText = call.parameters["designation"]
                if (designationAsText == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }
                try {
                    val designation = Designation.valueOf(designationAsText)
                    val developers = developerRepository.getDevelopersByDesignation(designation)

                    if (developers.isEmpty()) {
                        call.respond(HttpStatusCode.NotFound)
                        return@get
                    }

                    call.respond(developers)

                } catch (ex: IllegalArgumentException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            post {
                try {
                    val developer = call.receive<Developer>()
                    developerRepository.addDeveloper(developer)
                    call.respond(HttpStatusCode.NoContent)
                } catch (ex: IllegalStateException) {
                    call.respond(HttpStatusCode.BadRequest)
                } catch (ex: JsonConvertException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }
    }
}