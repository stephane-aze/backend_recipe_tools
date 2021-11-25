val exposedVersion: String= "0.36.1"

val koin_version: String = "3.1.3"

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
}
tasks.create("stage") {
    dependsOn("installDist")
}
dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")
    implementation ("io.ktor:ktor-jackson:$ktor_version")
    implementation ("io.ktor:ktor-client-gson:${ktor_version}")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation ("io.ktor:ktor-server-tomcat:$ktor_version")
    implementation ("io.ktor:ktor-client-okhttp:$ktor_version")
    implementation ("io.ktor:ktor-client-logging-jvm:${ktor_version}")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.postgresql:postgresql:42.3.1")

    //koin
    implementation("io.insert-koin:koin-ktor:$koin_version")
    implementation ("io.insert-koin:koin-logger-slf4j:$koin_version")
    //exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jodatime:$exposedVersion")

    testImplementation("org.slf4j:slf4j-nop:1.7.30")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    annotationProcessor("android.arch.persistence.room:compiler:1.1.1")

}