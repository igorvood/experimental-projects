package ru.vood.dictionaries.abstraction

import org.springframework.jdbc.core.JdbcTemplate
import kotlin.test.assertEquals

fun JdbcTemplate.compareTables(tableName1: String, tableName2: String): MutableList<MutableMap<String, Any>> {
    val queryForList = queryForList(
        """with t1 as (SELECT  * FROM $tableName1 EXCEPT SELECT* FROM $tableName2),
                    t2 as (SELECT * FROM $tableName2 EXCEPT SELECT* FROM $tableName1)
                select '$tableName1' exists_in,* from t1
                union all
                select '$tableName2',* from t2"""
    )
    return queryForList
}

fun JdbcTemplate.compareTablesWithAsserts(tableName1: String, tableName2: String) {
    val compareTables = this.compareTables(tableName1, tableName2)
    assert(compareTables.isEmpty()) { "Tables $tableName1 and $tableName2 not equals. There diff:\n$compareTables" }
//    SELECT  count(1) FROM dict_place_holder
    val tableName1Cnt = this.queryForObject("SELECT   count(1) FROM $tableName1", Int::class.java)
    val tableName2Cnt = this.queryForObject("SELECT   count(1) FROM $tableName2", Int::class.java)

    assertEquals(
        tableName1Cnt,
        tableName2Cnt,
        "Tables $tableName1 and $tableName2 not equals. There diff count records $tableName1 count $tableName1Cnt, $tableName2 count $tableName1Cnt"
    )

}