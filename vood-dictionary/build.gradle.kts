import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "2.0.20"
    id("com.google.devtools.ksp") version "2.0.20-1.0.25"
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("plugin.serialization") version "2.0.0"//"1.9.21"
    kotlin("plugin.spring") version "2.0.0"

}

repositories {
    mavenCentral()
}


dependencies {
    val koTest = "5.9.1"
    val koTestExtensionSpring = "1.3.0"
    implementation("org.springframework.boot:spring-boot-starter-webflux")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json")



    implementation(platform("io.kotest:kotest-bom:$koTest"))

    testImplementation(kotlin("test"))
    testImplementation ("io.kotest.extensions:kotest-extensions-spring:$koTestExtensionSpring")
    testImplementation ("io.kotest:kotest-assertions-core")
    testImplementation ("io.kotest:kotest-runner-junit5")
    testImplementation ("io.kotest:kotest-property")
    testImplementation ("io.kotest:kotest-framework-datatest")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

//tasks.withType<KotlinCompile>().configureEach {
//    kotlinOptions{
//        freeCompilerArgs= freeCompilerArgs + "-Xcontext-receivers"
//    }
//}

kotlin {
    jvmToolchain(17)
}