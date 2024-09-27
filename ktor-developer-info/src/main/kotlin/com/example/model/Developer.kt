package com.example.model

import kotlinx.serialization.Serializable

enum class Designation {
    Trainee,
    Associate,
    Software,
    Senior
}

enum class SBU {
    Europe,
    America,
    FinTech,
    NopCommerce,
    HealthTech
}

enum class Tech {
    Android,
    IOS,
    Flutter,
    React,
    Java
}

@Serializable
data class Developer(
    val id: String,
    val name: String,
    val designation: Designation,
    val tech: Tech,
    val sbu: SBU
)