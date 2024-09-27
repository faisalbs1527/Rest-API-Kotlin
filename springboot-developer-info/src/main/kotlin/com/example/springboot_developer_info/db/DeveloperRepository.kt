package com.example.springboot_developer_info.db

import com.example.springboot_developer_info.db.entity.DeveloperEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeveloperRepository : JpaRepository<DeveloperEntity, String> {
    fun getDevelopersBytech(tech: String): List<DeveloperEntity>
    fun getDevelopersBysbu(sbu: String): List<DeveloperEntity>
    fun getDevelopersBydesignation(designation: String): List<DeveloperEntity>
}