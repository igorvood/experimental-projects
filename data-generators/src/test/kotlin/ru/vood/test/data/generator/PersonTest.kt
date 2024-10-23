package ru.vood.test.data.generator

import io.kotest.core.spec.style.FunSpec
import org.genthz.ObjectFactory
import org.genthz.dasha.DashaObjectFactory


class PersonTest : FunSpec() {
    init {


        test("asdasd") {
            val objectFactory: ObjectFactory = DashaObjectFactory()
            val person = objectFactory.get(Person::class.java)

            println(person)

            val personData = objectFactory.get(PersonData::class.java)
            println(personData)

            val personDataNotNull = objectFactory.get(PersonDataNotNull::class.java)
            println(personDataNotNull)


        }
    }
}
