package ru.vood.dictionaries.db.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vood.dictionaries.db.model.DictMeta

interface DictMetaRepository: JpaRepository<DictMeta, String> {
    @Modifying(flushAutomatically = true)
    @Transactional(propagation = Propagation.MANDATORY)
    override fun <S : DictMeta> save(entity: S): S

    @Modifying(flushAutomatically = true)
    @Transactional(propagation = Propagation.MANDATORY)
    override fun <S : DictMeta> saveAll(entities: Iterable<S>): List<S>

    @Modifying(flushAutomatically = true)
    @Transactional(propagation = Propagation.MANDATORY)
    override fun deleteById(pk: String)

    @Modifying(flushAutomatically = true)
    @Transactional(propagation = Propagation.MANDATORY)
    override fun deleteAllByIdInBatch(pkS: Iterable<String>)
}