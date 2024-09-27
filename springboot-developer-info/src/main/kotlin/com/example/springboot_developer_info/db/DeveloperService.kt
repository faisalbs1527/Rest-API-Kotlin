package com.example.springboot_developer_info.db

import com.example.springboot_developer_info.model.Developer
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class DeveloperService(private val developerRepository: DeveloperRepository) {

    fun getAllDevelopers(): List<Developer> = developerRepository.findAll().map { it.toModel() }

    fun createDevelopers(developer: Developer): Developer = developerRepository.save(developer.toEntity()).toModel()

    fun getDeveloperById(id: String): Developer =
        developerRepository.findById(id).orElseThrow { NotFoundException() }.toModel()

    fun updateDeveloperById(id: String, developer: Developer): Developer {
        return if (developerRepository.existsById(id)) {
            developerRepository.save(
                developer.toEntity()
            ).toModel()
        } else {
            throw NotFoundException()
        }
    }

    fun getDeveloperBySbu(sbu: String): List<Developer> =
        developerRepository.getDevelopersBysbu(sbu).map { it.toModel() }

    fun getDeveloperByTech(tech: String): List<Developer> =
        developerRepository.getDevelopersBytech(tech).map { it.toModel() }

    fun getDeveloperByDesignation(designation: String): List<Developer> =
        developerRepository.getDevelopersBydesignation(designation).map { it.toModel() }
}