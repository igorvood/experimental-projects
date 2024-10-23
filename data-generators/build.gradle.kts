import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "2.0.20"
//    id("com.google.devtools.ksp") version "2.0.20-1.0.25"
}

repositories {
    mavenCentral()
}


dependencies {
    val koTest = "5.9.1"
    val koTestExtensionSpring = "1.3.0"
    val genthz = "3.1.3"
    implementation(platform("io.kotest:kotest-bom:$koTest"))

    testImplementation ("org.genthz:genthz-core:$genthz")

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