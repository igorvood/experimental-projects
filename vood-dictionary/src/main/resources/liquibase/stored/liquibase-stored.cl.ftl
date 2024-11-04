<#import "/liquibase/changelog-common.ftl" as fmt/>
<@fmt.liquibase_header/>
    <@fmt.lqb_mgr_sql "0010.dict_meta.sql" />
    <@fmt.lqb_mgr_sql "0020.meta_type_col.sql" />
    <@fmt.lqb_mgr_sql "0030.dict_column_meta.sql" />

<@fmt.liquibase_tail/>