<#macro lqb_mgr l_file_type l_file_name l_run_always>
    <changeSet id="${l_file_name}" author="nobody" runAlways="${l_run_always?c}">
        <${l_file_type} path="${l_file_name}" endDelimiter=${"\"$"+ "{sqlBatchDelimiter}\""} relativeToChangelogFile="true" />
    </changeSet>
</#macro>

<#macro lqb_mgr_sql l_file_name>
    <@lqb_mgr "sqlFile" l_file_name true/>
</#macro>

<#macro lqb_mgr_ftl l_file_name>
    <@lqb_mgr "ftlFile" l_file_name true/>
</#macro>

<#macro lqb_mgr_lob l_file_name>
    <@lqb_mgr "lobSqlFile" l_file_name true/>
</#macro>

<#macro mgr_sql l_file_name>
    <@lqb_mgr "sqlFile" l_file_name false/>
</#macro>

<#macro liquibase_header>
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd">

    <property name="sqlBatchDelimiter" value="\n/"/>
</#macro>

<#macro liquibase_tail>
</databaseChangeLog>
</#macro>

<#macro include l_file_name>
    <include file="${l_file_name}" relativeToChangelogFile="true"/>
</#macro>

<#macro include_all l_file_name>
    <includeAll file="${l_file_name}" relativeToChangelogFile="true"/>
</#macro>

<#macro mgr_sql_cd in_dir in_mdir in_files>
    <#list in_files as f>
        <@mgr_sql "${in_dir}/${in_mdir}/${f}"/>
    </#list>
</#macro>

<#macro mgr_sql_cd_f in_files>
    <#list in_files as f>
        <@mgr_sql "${f}"/>
    </#list>
</#macro>