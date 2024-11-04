package ru.vood.gradle

import freemarker.cache.FileTemplateLoader
import freemarker.cache.NullCacheStorage
import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateExceptionHandler
import org.gradle.api.logging.Logger
import java.io.File
import java.io.IOException
import java.io.Writer
import java.nio.file.Path
import java.util.*

class TemplateProcessor(
    projectName: String,
    private val baseDir: File,
    private val rootBasedFtlPath: Boolean,
    properties: Properties,
    private val logger: Logger
) : Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS) {
    private val dataModel: MutableMap<String, Any>

    init {
        try {
            this.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
            this.localizedLookup = false
            this.templateLoader = FileTemplateLoader(baseDir, false)
            if (rootBasedFtlPath) {
                this.setDirectoryForTemplateLoading(baseDir)
            }
            this.defaultEncoding = "UTF-8"
            this.numberFormat = "computer"
            this.dateFormat = "yyyy-MM-dd"
            this.dateTimeFormat = "yyyy-MM-dd HH:mm:ss"
            this.cacheStorage = NullCacheStorage()
            this.setSharedVariable("project", projectName)
            this.dataModel = HashMap()
            Optional.ofNullable(properties)
                .ifPresent { p: Properties ->
                    p.forEach { k, v -> this.dataModel[k.toString()] = v }
                }
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }

    override fun getTemplate(templateName: String): Template =
        try {
            super.getTemplate(templateName.replace("\\", "/"))
        } catch (e: IOException) {
            throw IllegalArgumentException("Unable to get template '$templateName'", e)
        }

    fun process(writer: Writer, templatePath: Path) {
        try {
            val dir = templatePath.parent.toFile()
            val templatePthStr = if (!rootBasedFtlPath)
                templatePath.fileName.toString()
            else baseDir.toPath().relativize(templatePath).toString()
            logger.info("rootBasedFtlPath => $rootBasedFtlPath")
            logger.info("templatePath => $templatePath")
            logger.info("templatePthStr => $templatePthStr")
            logger.info(
                "  * processing template %s%s",
                if (rootBasedFtlPath) "" else String.format("[%s]%s", dir, File.separator),
                templatePthStr
            )
            if (!rootBasedFtlPath) {
                this.setDirectoryForTemplateLoading(dir)
            }

            val template = getTemplate(templatePthStr)
            template.process(dataModel, writer)
        } catch (e: Exception) {
            throw IllegalStateException("ftl processing exeption", e)
        }
    }
}