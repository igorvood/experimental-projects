package ru.vood.dictionaries.db.abstraction

import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionTemplate

fun PlatformTransactionManager.withPropagation(propagation: Int): TransactionTemplate = kotlin.run {
    val tt = TransactionTemplate(this)
    tt.propagationBehavior = propagation
    tt
}