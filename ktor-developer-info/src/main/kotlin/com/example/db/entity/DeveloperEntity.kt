package com.example.db.entity

import org.jetbrains.exposed.sql.Table

object DeveloperEntity : Table("developers") {
    val userId = varchar(name = "userId", length = 10)
    val name = varchar(name = "name", length = 30)
    val designation = varchar(name = "designation", length = 20)
    val tech = varchar(name = "tech", length = 20)
    val sbu = varchar(name = "sbu", length = 20)

    override val primaryKey = PrimaryKey(userId)
}