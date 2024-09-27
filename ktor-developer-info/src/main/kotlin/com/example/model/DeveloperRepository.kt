package com.example.model

interface DeveloperRepository {
    fun getAllDevelopers(): List<Developer>
    fun getDeveloperById(id: String): Developer?
    fun getDevelopersByTech(tech: Tech): List<Developer>
    fun getDevelopersBySBU(sbu: SBU): List<Developer>
    fun getDevelopersByDesignation(designation: Designation): List<Developer>
    fun addDeveloper(developer: Developer): Boolean
}