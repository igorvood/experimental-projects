package ru.vood.dictionaries.db.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "dict_value")
data class DictValue(
    @Id
    @Column(name = "id", nullable = false)
    val id: String,

    @Column(name = "dict_id", nullable = false)
    val dictId: String,

    @Column(name = "col_id", nullable = false)
    val typeColId: String,

    )
