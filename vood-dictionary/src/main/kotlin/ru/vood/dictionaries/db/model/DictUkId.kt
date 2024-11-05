package ru.vood.dictionaries.db.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class DictUkId : Serializable {
    @Column(name = "id", nullable = false, length = 256)
    open var id: String? = null

    @Column(name = "dict_id", nullable = false, length = 256)
    open var dictId: String? = null

    @Column(name = "col_id", nullable = false, length = 256)
    open var colId: String? = null
    override fun hashCode(): Int = Objects.hash(id, dictId, colId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as DictUkId

        return id == other.id &&
                dictId == other.dictId &&
                colId == other.colId
    }

    companion object {
        private const val serialVersionUID = 3711525170547688014L
    }
}