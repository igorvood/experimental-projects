package ru.vood.dictionaries.db.model

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "dict_column_meta")
open class DictColumnMeta {
    @EmbeddedId
    open var id: DictColumnMetaId? = null

    @MapsId("dictId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "dict_id", nullable = false)
    open var dict: ru.vood.dictionaries.db.model.DictMeta? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "type_col_id", nullable = false)
    open var typeCol: ru.vood.dictionaries.db.model.MetaTypeCol? = null

    @Column(name = "is_deleted", nullable = false)
    open var isDeleted: Boolean? = false

    @Column(name = "description", nullable = false, length = 512)
    open var description: String? = null
}