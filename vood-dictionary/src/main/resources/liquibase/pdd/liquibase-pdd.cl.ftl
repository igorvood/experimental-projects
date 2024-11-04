<#import "/liquibase/changelog-common.ftl" as fmt/>
<@fmt.liquibase_header/>
<@fmt.lqb_mgr_sql "0010.pdd_all_objects.sql" />
<@fmt.lqb_mgr_sql "0020.pdd_columns.sql" />
<@fmt.lqb_mgr_sql "0030.pdd_constraint.sql" />
<@fmt.lqb_mgr_sql "0040.pdd_constraint_col.sql" />
<@fmt.liquibase_tail/>
