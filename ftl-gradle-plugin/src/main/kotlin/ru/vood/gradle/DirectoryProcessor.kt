package ru.vood.gradle

import org.gradle.api.logging.Logger
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.regex.Pattern

class DirectoryProcessor(
    private val projectName: String,
    private val outDir: File,
    private val rootBasedFtlPath: Boolean,
    private val templateExt: String,
    private val resultExt: String,
    private val logger: Logger,
    templateProperties: Map<String, String>
) {

    private val templateProperties: Properties = Properties()

    private val templatePattern: Pattern

    private val outputCharset: Charset

    /**
    Обработчик входящих с генерацией результирующих файлов в out-директорию
     */
    init {
        this.templateProperties.putAll(
            (templateProperties.ifEmpty { emptyMap<Any, Any>() })
        )
        this.templatePattern = Pattern.compile(
            String.format(
                ".*\\.%s$", templateExt.replace("\\.".toRegex(), "\\\\\\.")
            ), Pattern.CASE_INSENSITIVE
        )

        outputCharset = Charset.forName(System.getProperty(CHARSET_PROP_NAME))
        logger.info(String.format("outputCharset=%s", outputCharset))
    }

    companion object {
        private const val CHARSET_PROP_NAME = "file.encoding"
    }

    fun process(dir: File) {
        try {
            if (!outDir.exists()) {
                Files.createDirectory(outDir.toPath())
            }
        } catch (e: Exception) {
            throw IllegalArgumentException(String.format("cannot create directory '%s'", outDir), e)
        }
        val rootDir = dir.absolutePath
        val templateProcessor = TemplateProcessor(
            projectName,
            Paths.get(rootDir).toFile(),
            rootBasedFtlPath,
            this.templateProperties,
            logger
        )
        logger.info("- directory $rootDir")
        processDir(dir, rootDir, templateProcessor)
    }

    private fun processDir(dir: File, rootDir: String, templateProcessor: TemplateProcessor) {
        try {
            Files.walk(dir.toPath()).use { dirPath ->
                dirPath.filter { p ->
                    !p.toFile().isDirectory && templatePattern.matcher(p.fileName.toString()).find()
                }
                    .sorted()
                    .forEach { p ->
                        val templatePath = Paths.get(rootDir).relativize(p).toString()
                        val outName = Paths.get(outDir.toPath().toString(), templatePath).toString()
                            .replace(
                                String.format("\\.%s", templateExt).toRegex(),
                                if (resultExt.isBlank()) "" else String.format(
                                    ".%s", resultExt
                                )
                            )
                        val outDirPath = Paths.get(outName).parent
                        try {
                            if (!outDirPath.toFile().exists())
                                Files.createDirectories(outDirPath)
                        } catch (e: Exception) {
                            throw IllegalStateException("cannot create dirrectory $outDirPath", e)
                        }
                        try {
                            if (Paths.get(outName).toFile().exists()) {
                                Files.delete(Paths.get(outName))
                            }
                        } catch (e: Exception) {
                            throw IllegalStateException("cannot remove already existed file $outName", e)
                        }
                        try {
                            OutputStreamWriter(FileOutputStream(outName), outputCharset).use { writer ->
                                templateProcessor.process(writer, p)
                                logger.info("      $outName created")
                            }
                        } catch (e: Exception) {

                        }

                    }

            }
        } catch (e: Exception) {

        }
    }
}
/*
fun process (dir: File) 1 & Balitskiy if (loutDir. exists()) t

Files.createDirectory(outDir.toPath())

Gil gradle properties x 2 build.gradle.kts (hashcode-ftl-gradle-plugin; X fl.gradle.kts X

FtlTask.kt X

TemplateProcessor.kt x

hashcode-ftl-gradle-plugi

DirectoryProcessor.

catch (e: Exception) {

throw IllegalArgumentException (String format ("cannot create directory '%'", outDir), e)

val

templateProcessor = TemplateProcessor

projectName, Paths. get (dir.absolutePath). toFile(), rootBasedFtlPath, this.templateProperties,

Logger,

val

rootDir: String - dir. absolutePath

logger. info("- directory $fdir.absolutePath}")

processDir(dir, rootDir, templateProcessor)

3

4

55

66

67

68

69

70

向

白

71

72

13

74

75

76

77

78

79

Bookmarks

品a Structure

80

81

82

83

84

85

86

87

88

I Git

# TODO

© Problems

private fun processDirdir: File, rootDir: String, templateProcessor: TemplateProcessor) { Balitskiy

try {

Files. walk(dir.toPath()).use { dirPath: Stream<Path!>! ->

dirPath

filter & p: Path ->
1p. toFile.isDirectory
templatePattern.matcher (p.fileName.toString()) find(
sorted (
forEach { p: Path ->
val templatePath: String = Paths.get(rootDir) relativize(p).toString)
val
outName: String
=

Paths.get (outDir. toPath() toString(), templatePath). toString(

• replace (
String format ("\\.%s", templateExt).toRegex,
if (resultExt.isBlank) "*

else String. format

".%s",

resultExt

val

outDirPath: Path! = Paths.get(outName) .parent

Python Packages

Language Servers

> Terminal



File

Edit View Navigate Code

Refactor

Build

Run Tools

hashcode-ftl-gradle-plugin 2) src) main) kotlin) ru) sberbank) hashcode ) gradle

Git Window DB Navigator Help

hashcode-ftl-gradle-plugin - DirectoryProcessor.kt [hashcode-ftl-gradle-plugin.main)

Directory Processor

process

Project

gitignore X

15

68

(6 DB Browser

70

- settings.gradle.kts (hashcode-ftl-gradle-plugin) X

il gradle properties X

N build.gradle.kts (hashcode-ftl-gradle-plugin; X

N' ftl.gradle.kts X 1g

Ft/Task.kt X

class

DirectoryProcessor & Balitskiy

private fun processDir(dir: File, rootDir: String, templateProcessor: TemplateProcessor) / & Balitskiy

Files.walk(dir.toPath()).use { dirPath: Stream<Path!>!

->

•forEach { p: Path ->

87

A Kotest

88

val outDirPath: Path! = Paths.get (outName). parent

89

try {

90

I

if (loutDirPath. toFile() .exists)) t

Files.createDirectories(outDirPath)

§ Commit

91

92

93

94

白

白

｝

catch (e: IOException) {

throw IllegalStateException ("cannot create directory $outDirPath", e)

95

96

97

98

白

｝

try {

if (Paths.get (outName). toFile() .exists()) {

Files delete (Paths. get (outName))

99

白

100

101

102

103

104

105

106

107

108

109

110

111

112

113

114

115

Structure

】 Bookmarks

116

117

118

119

120

121

catch (e: IOException) f

Logger. error ("cannot create directory $outDirPath", e)

throw IllegalStateException ("cannot remove already existed file $outName", e)

try

{

OutputStreamWriter (FileOutputStream (outName), outputCharset).use f writer: OutputStreamWriter

templateProcessor process (writer, p)

Logger.info("

SoutName created")

白

catch (e: Exception) {

throw IllegalStateException ("Cannot create output file: $outName", e)

白

｝

} catch (e: IOException) {

throw IllegalStateException("cannot processing dir ${dir.absolutePath}", e)

白

白

companion object {

• Balitskiy

private const val CHARSET_ PROP_NAME = "file.encoding"

TemplateProcessor.kt X

hashcode-fti-gradle-plugin_2 [publishToM,

DirectoryProcessor.kt



*/