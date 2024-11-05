package ru.vood.dictionaries.db.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "dict_meta")
open class DictMeta {
    @Id
    @Column(name = "id", nullable = false, length = 256)
    open var id: String? = null

    @Column(name = "is_deleted", nullable = false)
    open var isDeleted: Boolean? = false

    @Column(name = "description", nullable = false, length = 512)
    open var description: String? = null
}