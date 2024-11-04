package ru.vood.dictionaries

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DictionaryApplication

fun main(args: Array<String>) {
    runApplication<DictionaryApplication>(*args)
}
