package ru.vood.dictionaries.db.repo;

import org.springframework.data.jpa.repository.JpaRepository
import ru.vood.dictionaries.db.model.DictMeta

interface DictMetaRepository : JpaRepository<DictMeta, String> {
}