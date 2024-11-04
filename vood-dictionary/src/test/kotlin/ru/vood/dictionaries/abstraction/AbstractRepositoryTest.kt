package ru.vood.dictionaries.abstraction

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.IllegalTransactionStateException
import org.springframework.transaction.TransactionDefinition
import ru.vood.dictionaries.db.abstraction.withPropagation

abstract class AbstractRepositoryTest<T, ID>(
    val initData: T
) : AbstractJunit5DatasourceTest() {
    protected final inline fun saveInTransactionHelper(repository: JpaRepository<T, ID>) {
        inNewTransaction{
            val save = repository.save(initData)
            save shouldBe initData
        }
    }

    protected final  fun saveWithoutTransactionHelper(repository: JpaRepository<T, ID>) {
        println(1)
        val assertThrows =
            Assertions.assertThrows(IllegalTransactionStateException::class.java) { repository.save(initData) }

        val shouldThrow = shouldThrow<IllegalTransactionStateException> {
            repository.save(initData)
        }

        assertThrows.message shouldBe "No existing transaction found for transaction marked with propagation 'mandatory'"
    }


    final inline fun inNewTransaction(crossinline action: ()-> T){
        transactionManager.withPropagation(TransactionDefinition.PROPAGATION_REQUIRES_NEW).let {
            it.execute {
                action()
            }
        }

    }



}