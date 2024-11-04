import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    `kotlin-dsl`
    `maven-publish`
    id("com.github.gmazzo.buildconfig") version "5.3.5"
}

repositories {
    mavenCentral()
}


buildscript {
    dependencies {
        constraints {
            val kotlinPluginVersion = "2.0.0"
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinPluginVersion")
            classpath("org.jetbrains.kotlin:kotlin-sam-with-receiver:$kotlinPluginVersion")
        }
    }
}

buildConfig {
    packageName(project.group as String)
    buildConfigField("String", "FTL_TASK_PLUGINS_VERSION", "\"${project.version}\"")
}

dependencies {
    implementation("org.freemarker:freemarker:2.3.33")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinJvmCompile> {
    compilerOptions {
        jvmTarget.set(provider { JvmTarget.fromTarget(java.targetCompatibility.toString()) })
    }
}

tasks.withType<Jar> {
    archiveFileName.set(providers.provider {
        listOfNotNull(
            listOf(archiveBaseName, archiveAppendix, archiveClassifier)
                .map { it.orNull }
                .filterNot { it.isNullOrEmpty() }
                .joinToString("-")
        ).joinToString(".")
    })

}