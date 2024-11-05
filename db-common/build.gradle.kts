

plugins {
    java
    `java-library`
    `maven-publish`
    id("ru.vood.gradle.ftl") version "1.0.0"
}

repositories {
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

//jar {
//    baseName = 'analytics'
//    from('src/main/java') {
//        include 'config/**/*.xml'
//    }
//
//    manifest {
//        attributes 'Implementation-Title': 'Analytics Library', 'Implementation-Version': version
//    }
//}