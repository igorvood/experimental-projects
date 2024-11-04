package ru.vood.dictionaries.abstraction

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import java.io.File
import java.util.*

val delimiterScripts = "/"
val pathSeparator = "/"


abstract class AbstractJunit5DatasourceTest(val doExecuteSql: Boolean = false) : AbstractTests() {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    private val setupClass = "setup.sql"
    private val setupTest = "setup.each.sql"

    private val teardownClass = "teardown.sql"
    private val teardownTest = "teardown.each.sql"

    private val javaClass = this::class.java
    private val fullPathToScripts = javaClass.name.replace(".", pathSeparator)

    @BeforeAll
    fun beforeAll() = run {
        if (doExecuteSql) {
            afterAll()
            runScriptsFromFile(setupClass)
        }
    }

    @AfterAll
    fun afterAll() = kotlin.run {
        if (doExecuteSql) {
            runScriptsFromFile(teardownClass)
        }
    }


    @BeforeEach
    fun beforeEach() = run {
        if (doExecuteSql) {
            afterEach()
            runScriptsFromFile(setupTest)
        }
    }

    @AfterEach
    fun afterEach() = kotlin.run {
        if (doExecuteSql) {
            runScriptsFromFile(teardownTest)
        }
    }

    private fun runScriptsFromFile(fileName: String) {
        val fullFilename = fullPathToScripts + pathSeparator + fileName
        val file = Optional.ofNullable(javaClass.classLoader.getResource(fullFilename))
            .map { File(it.path) }
            .orElseGet { throw java.lang.IllegalArgumentException("Unable to read $fullFilename") }

        file.bufferedReader().readLines().joinToString("\n").split(delimiterScripts)
            .forEach { sql -> jdbcTemplate.execute(sql) }
    }

}