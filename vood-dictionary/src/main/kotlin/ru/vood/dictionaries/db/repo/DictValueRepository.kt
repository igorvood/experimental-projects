package ru.vood.dictionaries.db.repo;

import org.springframework.data.jpa.repository.JpaRepository
import ru.vood.dictionaries.db.model.DictValue
import ru.vood.dictionaries.db.model.DictValueId

interface DictValueRepository : JpaRepository<DictValue, DictValueId> {
}