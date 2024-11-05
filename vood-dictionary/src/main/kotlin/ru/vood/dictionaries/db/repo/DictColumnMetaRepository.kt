package ru.vood.dictionaries.db.repo;

import org.springframework.data.jpa.repository.JpaRepository
import ru.vood.dictionaries.db.model.DictColumnMeta
import ru.vood.dictionaries.db.model.DictColumnMetaId

interface DictColumnMetaRepository : JpaRepository<DictColumnMeta, DictColumnMetaId> {
}