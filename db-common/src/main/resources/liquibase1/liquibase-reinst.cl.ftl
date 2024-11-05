<#import "/liquibase1/changelog-common.ftl" as fmt/>
<@fmt.liquibase_header/>
<@fmt.include "drop_all_obj/liquibase-drop.xml"/>
<@fmt.include "tests/for_tests.xml"/>
<@fmt.include "checks/checks.xml"/>
<@fmt.liquibase_tail/>