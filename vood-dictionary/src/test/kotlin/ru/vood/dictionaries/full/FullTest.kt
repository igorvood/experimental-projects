package ru.vood.dictionaries.full

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vood.dictionaries.abstraction.AbstractJunit5DatasourceTest
import ru.vood.dictionaries.db.model.DictColumnMeta
import ru.vood.dictionaries.db.model.DictColumnMetaId
import ru.vood.dictionaries.db.model.DictMeta
import ru.vood.dictionaries.db.model.MetaTypeCol
import ru.vood.dictionaries.db.repo.DictColumnMetaRepository
import ru.vood.dictionaries.db.repo.DictMetaRepository
import ru.vood.dictionaries.db.repo.MetaTypeColRepository

class FullTest : AbstractJunit5DatasourceTest(true) {

    @Autowired
    lateinit var metaTypeColRepository: MetaTypeColRepository

    @Autowired
    lateinit var dictMetaRepository: DictMetaRepository

    @Autowired
    lateinit var dictColumnMetaRepository: DictColumnMetaRepository

    @Test
    fun asdD() {

//        val save = metaTypeColRepository.saveAllAndFlush(metaTypeCols)
//        dictMetaRepository.saveAllAndFlush(dictMetas)
//        dictColumnMetaRepository.saveAllAndFlush(dictColumnMetas)
        println(1)
    }

    companion object {

        val metaTypeCols = listOf("String", "Int", "Date", "Bool", "Obj")
            .map { t ->
                MetaTypeCol().apply {
                    id = t
                    description = t
                }
            }

        val dictMetas = listOf("currency", "type_acc", "percent", "department")
            .map { t ->
                DictMeta().apply {
                    id = t
                    isDeleted = false
                    description = t
                }
            }


        val dictColumnMetaIds = listOf(
            "currency" to "ISO",
            "currency" to "name",

            "type_acc" to "code",
            "type_acc" to "name",

            "percent" to "currency",
            "percent" to "type_acc",
            "percent" to "value",

            "department" to "id",
            "department" to "parent_id",
            "department" to "name",
        )
            .map { p ->
                DictColumnMetaId().apply {
                    id = p.second
                    dictId = p.first
                }
            }


        val dictColumnMetas = dictColumnMetaIds
            .map { t ->
                val first = dictMetas.firstOrNull { it.id == t.dictId }?: error("not found dict ${t.dictId}")
                DictColumnMeta().apply {
                    id = t
                    dict = first
                    typeCol = MetaTypeCol().apply { id = "String" }
                    isDeleted = false
                    description = t.dictId+"_"+t.id
                }
            }


    }

}