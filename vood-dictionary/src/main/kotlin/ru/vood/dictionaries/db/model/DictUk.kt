package ru.vood.dictionaries.db.model

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "dict_uk")
open class DictUk {
    @EmbeddedId
    open var id: DictUkId? = null

    //TODO [Amplicode] generate columns from DB
}