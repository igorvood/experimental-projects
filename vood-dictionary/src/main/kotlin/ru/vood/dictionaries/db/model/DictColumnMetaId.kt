package ru.vood.dictionaries.db.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class DictColumnMetaId : Serializable {
    @Column(name = "dict_id", nullable = false, length = 256)
    open var dictId: String? = null

    @Column(name = "id", nullable = false, length = 256)
    open var id: String? = null
    override fun hashCode(): Int = Objects.hash(dictId, id)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as DictColumnMetaId

        return dictId == other.dictId &&
                id == other.id
    }

    companion object {
        private const val serialVersionUID = 4521987099760951389L
    }
}