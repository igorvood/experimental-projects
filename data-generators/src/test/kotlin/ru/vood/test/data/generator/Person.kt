package ru.vood.test.data.generator

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

class Person {
    private val id: Long? = null

    private val name: String? = null

    private val lastName: String? = null

    private val birthDate: LocalDate? = null
}

data class PersonData(
    val id: Long? = null,

    val name: String? = null,

    val lastName: String? = null,

    val birthDate: LocalDate? = null
)

data class PersonDataNotNull(
    val id: Long,

    val salary: BigDecimal,

    val lastName: String,

    val birthDate: LocalDateTime,

    val names: List<String>,

    val cars: List<Car>
)

data class Car (
    val colour: Colour,
)

enum class Colour{
    RED, GREEN, BLACK
}
