package ru.vood.dictionaries.db.repo;

import org.springframework.data.jpa.repository.JpaRepository
import ru.vood.dictionaries.db.model.MetaTypeCol

interface MetaTypeColRepository : JpaRepository<MetaTypeCol, String> {
}