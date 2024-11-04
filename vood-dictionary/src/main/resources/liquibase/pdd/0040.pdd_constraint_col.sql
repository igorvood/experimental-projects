create or replace view pdd_constraint_col as
select tc.schema_name,
       tc.constraint_name,
       tc.table_name,
       tc.constraint_type,
       kcu.column_name fk_column_name,
       kcu.ordinal_position fk_ordinal_position,
       kcu2.column_name uk_column_name,
       kcu2.ordinal_position uk_ordinal_position,
       tc.unique_constraint_schema,
       tc.unique_constraint_name
FROM pdd_constraint tc
    join information_schema.key_column_usage kcu on
        (tc.constraint_name, tc.schema_name, tc.table_name) = ((kcu.constraint_name, kcu.table_schema, kcu.table_name))
    left join information_schema.key_column_usage kcu2 on
        (tc.unique_constraint_schema, tc.unique_constraint_name) = ((kcu2.constraint_schema, kcu2.constraint_name))
/
COMMENT ON VIEW pdd_constraint_col IS 'Метаинформация колонок таблиц базы'
/
COMMENT ON COLUMN pdd_constraint_col.schema_name IS 'Наименование схемы констрейнта'
/
COMMENT ON COLUMN pdd_constraint_col.table_name IS 'Имя таблицы'
/
COMMENT ON COLUMN pdd_constraint_col.fk_column_name IS 'Имя колонки в fk'
/
COMMENT ON COLUMN pdd_constraint_col.fk_ordinal_position IS 'Позиция колонки в fk'
/
COMMENT ON COLUMN pdd_constraint_col.uk_column_name IS 'Имя колонки в uk'
/
COMMENT ON COLUMN pdd_constraint_col.uk_ordinal_position IS 'Позиция колонки в uk'
/
COMMENT ON COLUMN pdd_constraint_col.unique_constraint_schema IS 'Схема UK куда ссылается форен'
/
COMMENT ON COLUMN pdd_constraint_col.unique_constraint_name IS 'наименование UK куда ссылается форен'
/
COMMENT ON COLUMN pdd_constraint_col.constraint_type IS 'Тип констрайнта'
/
COMMENT ON COLUMN pdd_constraint_col.constraint_name IS 'Имя констрайнта'
/

