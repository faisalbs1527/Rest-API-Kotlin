package com.example.model

import com.example.db.entity.DeveloperEntity
import com.example.db.insertDeveloper
import com.example.db.toModel
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ExposedDeveloperRepository : DeveloperRepository {
    override fun getAllDevelopers(): List<Developer> {
        return transaction {
            DeveloperEntity.selectAll().map {
                it.toModel()
            }
        }
    }

    override fun getDeveloperById(id: String): Developer? {
        return transaction {
            DeveloperEntity.select { DeveloperEntity.userId eq id }
                .mapNotNull { it.toModel() }
                .singleOrNull()
        }
    }

    override fun getDevelopersByTech(tech: Tech): List<Developer> {
        return transaction {
            DeveloperEntity.select { DeveloperEntity.tech eq tech.name }
                .map { it.toModel() }
        }
    }

    override fun getDevelopersBySBU(sbu: SBU): List<Developer> {
        return transaction {
            DeveloperEntity.select { DeveloperEntity.sbu eq sbu.name }
                .map { it.toModel() }
        }
    }

    override fun getDevelopersByDesignation(designation: Designation): List<Developer> {
        return transaction {
            DeveloperEntity.select { DeveloperEntity.designation eq designation.name }
                .map { it.toModel() }
        }
    }

    override fun addDeveloper(developer: Developer): Boolean {
        return transaction {
            if (getDeveloperById(developer.id) != null) {
                throw IllegalStateException("Cannot duplicate developer by Id!!")
            }
            DeveloperEntity.insertDeveloper(developer).resultedValues?.isNotEmpty() ?: false
        }
    }
}