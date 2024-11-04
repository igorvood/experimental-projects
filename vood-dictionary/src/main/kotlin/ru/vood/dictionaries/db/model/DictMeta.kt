package ru.vood.dictionaries.db.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "dict_meta")
data class DictMeta(
    @Id
    @Column(name = "id", nullable = false)
    val id: String,

    @Column(name = "is_deleted", nullable = false)
    val isDeleted: Boolean,

    @Column(name = "description", nullable = false)
    val description: Boolean,
)
