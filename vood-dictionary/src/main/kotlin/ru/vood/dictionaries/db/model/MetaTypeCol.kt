package ru.vood.dictionaries.db.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "meta_type_col")
data class MetaTypeCol(
    @Id
    @Column(name = "id", nullable = false)
    val id: String,

    @Column(name = "description", nullable = false)
    val description: String,
)
