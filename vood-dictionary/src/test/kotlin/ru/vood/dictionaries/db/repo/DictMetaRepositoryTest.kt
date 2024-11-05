package ru.vood.dictionaries.db.repo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.IllegalTransactionStateException
import ru.vood.dictionaries.abstraction.AbstractRepositoryTest
import ru.vood.dictionaries.db.model.DictMeta

val sdfd = DictMetaRepository::class.java

//class DictMetaRepositoryTest : AbstractRepositoryTest<DictMeta, String>(
//    initData = DictMeta(
//        id = "id",
//        isDeleted = false,
//        description = "description"
//    )
//) {
//
//    @org.junit.jupiter.api.AfterEach
//    fun afterEachC() {
//        repository.deleteAll()
//    }
//
//    @Autowired
//    private lateinit var repository: DictMetaRepository
//
//    @Test
//    @DisplayName("успех вставки в транзакции")
//    fun saveInTransaction() {
//        saveInTransactionHelper(repository)
//    }
//
//    @Test
//    @DisplayName("ошибка вставки без транзакции")
//    fun saveWithoutTransaction() {
//
//        val shouldThrow = shouldThrow<IllegalTransactionStateException> {
//            repository.save(initData)
//        }
//        shouldThrow.message shouldBe "No existing transaction found for transaction marked with propagation 'mandatory'"
//
////        saveWithoutTransactionHelper(repository)
//    }
//
//
//}