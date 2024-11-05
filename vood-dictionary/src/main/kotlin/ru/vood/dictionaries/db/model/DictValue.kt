package ru.vood.dictionaries.db.model

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "dict_value")
open class DictValue {
    @EmbeddedId
    open var id: DictValueId? = null

    @Column(name = "val_s", length = 512)
    open var valS: String? = null

    @Column(name = "val_n")
    open var valN: BigDecimal? = null

    @Column(name = "val_d")
    open var valD: Instant? = null

    @Column(name = "val_c", length = Integer.MAX_VALUE)
    open var valC: String? = null
}