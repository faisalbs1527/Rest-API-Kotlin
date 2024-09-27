package com.example.springboot_developer_info.model


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

data class Developer(
    val id: String,
    val name: String,
    val designation: Designation,
    val tech: Tech,
    val sbu: SBU
)