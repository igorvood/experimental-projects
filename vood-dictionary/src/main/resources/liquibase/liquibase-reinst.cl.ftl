<#import "/liquibase/changelog-common.ftl" as fmt/>
<@fmt.liquibase_header/>
<@fmt.include "drop_all_obj/liquibase-drop.xml"/>
<@fmt.include "stored/liquibase-stored.xml"/>
<@fmt.include "tests/for_tests.xml"/>
<@fmt.liquibase_tail/>