fun taskRef(name: String) {
    gradle.includedBuilds.flatMap {
        val prefix = it.name
        listOf(
            it.task(":$name")
        )
    }
}

tasks {
    arrayOf("assemble", "build", "clean").forEach {
        register(it) {
            group = LifecycleBasePlugin.BUILD_GROUP
            dependsOn(taskRef(it))
        }
    }

    arrayOf("check", "test").forEach {
        register(it) {
            group = LifecycleBasePlugin.VERIFICATION_GROUP
            dependsOn(taskRef(it))
        }
    }
}