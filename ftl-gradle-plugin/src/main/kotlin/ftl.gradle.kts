package ru.vood.gradle

plugins {
    java
}


val ftlTask by tasks.registering(FtlTask::class) {
    val dir = "src/main/resources"
    resultExtension.set("xml")
    templateExtension.set("cl.ftl")
    rootBasedFtlPath.set(true)
    sourceDirectory.set(layout.projectDirectory.dir(dir))
    outputDirectory.set(layout.buildDirectory.dir(dir))
}

tasks.processResources {
    dependsOn(ftlTask)
}
