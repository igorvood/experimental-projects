package ru.vood.dictionaries.db.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "meta_type_col")
open class MetaTypeCol {
    @Id
    @Column(name = "id", nullable = false, length = 256)
    open var id: String? = null

    @Column(name = "description", nullable = false, length = 512)
    open var description: String? = null
}