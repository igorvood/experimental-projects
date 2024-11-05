package ru.vood.dictionaries.db.repo;

import org.springframework.data.jpa.repository.JpaRepository
import ru.vood.dictionaries.db.model.DictUk
import ru.vood.dictionaries.db.model.DictUkId

interface DictUkRepository : JpaRepository<DictUk, DictUkId> {
}