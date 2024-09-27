package com.example.springboot_developer_info.db

import com.example.springboot_developer_info.db.entity.DeveloperEntity
import com.example.springboot_developer_info.model.Designation
import com.example.springboot_developer_info.model.Developer
import com.example.springboot_developer_info.model.SBU
import com.example.springboot_developer_info.model.Tech

fun Developer.toEntity() = DeveloperEntity(
    userId = id,
    name = name,
    designation = designation.name,
    sbu = sbu.name,
    tech = tech.name
)

fun DeveloperEntity.toModel() = Developer(
    id = userId,
    name = name,
    designation = Designation.valueOf(designation),
    sbu = SBU.valueOf(sbu),
    tech = Tech.valueOf(tech)
)