package com.example.springboot_developer_info

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication()
@EnableJpaRepositories("com.example.springboot_developer_info.db")
class SpringbootDeveloperInfoApplication

fun main(args: Array<String>) {
    runApplication<SpringbootDeveloperInfoApplication>(*args)
}
