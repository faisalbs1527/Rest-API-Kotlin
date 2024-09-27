package com.example.springboot_developer_info.controller

import com.example.springboot_developer_info.db.DeveloperService
import com.example.springboot_developer_info.model.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/developers")
class DeveloperController(private val developerService: DeveloperService) {

    @GetMapping
    fun getAllDevelopers(): List<Developer> {
        return developerService.getAllDevelopers()
    }

    @GetMapping("/Sbu/{sbuName}")
    fun getDevelopersBySbu(@PathVariable sbuName: String): List<Developer> {
        try {
            val sbu = SBU.valueOf(sbuName)
            val developers = developerService.getDeveloperBySbu(sbu.name)
            if (developers.isEmpty()) {
                return emptyList()
            }
            return developers

        } catch (ex: IllegalArgumentException) {
            return emptyList()
        }
    }

    @GetMapping("/Tech/{techName}")
    fun getDevelopersByTech(@PathVariable techName: String): List<Developer> {
        try {
            val tech = Tech.valueOf(techName)
            val developers = developerService.getDeveloperByTech(tech.name)
            if (developers.isEmpty()) {
                return emptyList()
            }
            return developers

        } catch (ex: IllegalArgumentException) {
            return emptyList()
        }
    }

    @GetMapping("/Designation/{designationName}")
    fun getDevelopersByDesignation(@PathVariable designationName: String): List<Developer> {
        try {
            val designation = Designation.valueOf(designationName)
            val developers = developerService.getDeveloperByDesignation(designation.name)
            if (developers.isEmpty()) {
                return emptyList()
            }
            return developers

        } catch (ex: IllegalArgumentException) {
            return emptyList()
        }
    }

    @PostMapping
    fun saveDeveloper(@RequestBody developer: Developer):Developer {
        return developerService.createDevelopers(developer)
    }

    @PutMapping("/update/{id}")
    fun updateDesignation(@PathVariable("id") id: String, @RequestBody developer: Developer):Developer {
        return developerService.updateDeveloperById(id, developer)
    }
}