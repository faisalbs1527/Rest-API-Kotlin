
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.20"
    id("io.ktor.plugin") version "3.0.0-rc-1"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.20"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-host-common-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // Exposed ORM dependencies
    implementation("org.jetbrains.exposed:exposed-core:0.38.2")
    implementation("org.jetbrains.exposed:exposed-dao:0.38.2")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.38.2")

    // MySQL Driver
    implementation("mysql:mysql-connector-java:8.0.32")

    // HikariCP for connection pooling
    implementation("com.zaxxer:HikariCP:5.0.1")
}
