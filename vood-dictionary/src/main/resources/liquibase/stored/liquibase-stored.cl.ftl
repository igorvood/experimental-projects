<#import "/liquibase/changelog-common.ftl" as fmt/>
<@fmt.liquibase_header/>
    <@fmt.lqb_mgr_sql "0010.dict_meta.sql" />
<@fmt.liquibase_tail/>