import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val dependenciesVersions = mapOf(
        "springBoot" to "2.1.6.RELEASE",
        "ktorOkHttpClient" to "1.2.2",
        "kotlin" to "1.3.40"
)

plugins {
    id("org.springframework.boot") version "2.1.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.40"
    kotlin("plugin.spring") version "1.3.40"
}

group = "com.cristiadu.expenses"
version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${dependenciesVersions["springBoot"]}")
    implementation("io.ktor:ktor-client-okhttp:${dependenciesVersions["ktorOkHttpClient"]}")
    implementation("org.springframework.boot:spring-boot-starter-web:${dependenciesVersions["springBoot"]}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${dependenciesVersions["kotlin"]}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${dependenciesVersions["kotlin"]}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${dependenciesVersions["springBoot"]}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
