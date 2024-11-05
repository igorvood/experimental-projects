create or replace view pdd_indexs as
select tc.schemaname schema_name,
       tc.tablename table_name,
       tc.indexname index_name,
       tc.indexdef index_defenition
FROM pg_indexes tc
/
COMMENT ON VIEW pdd_indexs IS 'Метаинформация по индексам'
/
COMMENT ON COLUMN pdd_indexs.schema_name IS 'Наименование схемы'
/
COMMENT ON COLUMN pdd_indexs.table_name IS 'Имя таблицы'
/
COMMENT ON COLUMN pdd_indexs.index_name IS 'Имя индекса'
/
COMMENT ON COLUMN pdd_indexs.index_defenition IS 'команда по созданию индекса'
/
