package ru.vood.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

abstract class FtlTask : DefaultTask() {

    /** расширение шаблона
     * */
    @get:Input
    abstract val templateExtension: Property<String>

    /** расширение файла результата
     * */
    @get:Input
    abstract val resultExtension: Property<String>


    /** использовать пути для import/include внутри ftl относительно root
     * */
    @get:Input
    abstract val rootBasedFtlPath: Property<Boolean>

    /** директория источник шаблонов
     * */
    @get:InputDirectory
    abstract val sourceDirectory: DirectoryProperty

    /** директория приемник шаблонов
     * */
    @get:InputDirectory
    abstract val outputDirectory: DirectoryProperty

    /** св-ва для шаблона
     * */
//    @get:Input
//    abstract val templateProperty: Property<Map<String, String>>

    @TaskAction
    open fun ftlProcess() {
        sourceDirectory.get().asFile.walk()
            .filter { it.isFile }
            .forEach {
                with(
                    DirectoryProcessor(
                        name,
                        outputDirectory.get().asFile,
                        rootBasedFtlPath.get(),
                        templateExtension.get(),
                        resultExtension.get(),
                        logger = logger,
                        mapOf()//templateProperty.get
                    )
                ) {
                    process(sourceDirectory.get().asFile)
                }

            }

    }

}