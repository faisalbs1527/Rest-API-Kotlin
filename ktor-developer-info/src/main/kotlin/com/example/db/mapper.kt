package com.example.db

import com.example.db.entity.DeveloperEntity
import com.example.model.Designation
import com.example.model.Developer
import com.example.model.SBU
import com.example.model.Tech
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.statements.InsertStatement

fun ResultRow.toModel() = Developer(
    id = this[DeveloperEntity.userId],
    name = this[DeveloperEntity.name],
    designation = Designation.valueOf(this[DeveloperEntity.designation]),
    tech = Tech.valueOf(this[DeveloperEntity.tech]),
    sbu = SBU.valueOf(this[DeveloperEntity.sbu])
)

// Extension function to map a Developer instance to an InsertStatement
fun DeveloperEntity.insertDeveloper(developer: Developer): InsertStatement<Number> {
    return insert {
        it[userId] = developer.id
        it[name] = developer.name
        it[designation] = developer.designation.name // Convert enum to string
        it[tech] = developer.tech.name              // Convert enum to string
        it[sbu] = developer.sbu.name                // Convert enum to string
    }
}