import java.nio.file.Files

fun taskRef(name: String): List<TaskReference> =
    gradle.includedBuilds.flatMap {
        val prefix = it.name
        listOf(
            it.task(":$name")
        )
    }


tasks {
    val gradleDir = "/gradle/wrapper"
    val absoluteRootDir = project.projectDir.toString()

    val propertiesFileName = "/gradle-wrapper.properties"
    val sourse = File(absoluteRootDir + gradleDir+ propertiesFileName)

    gradle.includedBuilds.forEach {
        val file = File(absoluteRootDir + "/" + it.name + gradleDir + propertiesFileName)
        sourse.copyTo(file, overwrite = true)
        println(it.name)
    }

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