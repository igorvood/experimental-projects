

plugins {
    java
    `java-library`
    `maven-publish`
    id("ru.vood.gradle.ftl") version "1.0.0"
}

repositories {
    mavenLocal()
    mavenCentral()
}

publishing{
    publications{
        create<MavenPublication>("java"){
            from(components["java"])
            versionMapping {
                allVariants {
                    fromResolutionResult()
                }
            }
        }
    }
}
