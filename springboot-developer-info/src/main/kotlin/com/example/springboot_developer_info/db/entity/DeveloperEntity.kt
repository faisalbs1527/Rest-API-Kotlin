package com.example.springboot_developer_info.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "developers")
data class DeveloperEntity(
    @Id
    val userId: String,
    val name: String,
    val designation: String,
    val tech: String,
    val sbu: String
)