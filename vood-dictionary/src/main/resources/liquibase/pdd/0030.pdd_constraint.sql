create or replace view pdd_constraint as
SELECT
    tc.constraint_schema schema_name,
    tc.constraint_name,
    tc.table_name,
    tc.constraint_type,
    kcu.column_name,
    kcu.ordinal_position,
    ccu.table_schema parent_table_schema,
    ccu.table_name parent_table_name,
    ccu.column_name parent_column_name
FROM information_schema.table_constraints tc
         join information_schema.key_column_usage kcu on
    (tc.constraint_name, tc.table_schema, tc.table_name) = ((kcu.constraint_name, kcu.table_schema, kcu.table_name))
         join information_schema.constraint_column_usage ccu on
    (ccu.constraint_name, ccu.table_schema, ccu.table_name, ccu.column_name) = ((tc.constraint_name, tc.table_schema, tc.table_name, kcu.column_name))
/
COMMENT ON VIEW pdd_constraint IS 'Метаинформация колонок таблиц базы'
/
COMMENT ON COLUMN pdd_constraint.schema_name IS 'Наименование схемы констрейнта'
/
COMMENT ON COLUMN pdd_constraint.table_name IS 'Имя таблицы'
/
COMMENT ON COLUMN pdd_constraint.column_name IS 'Имя колонки'
/
COMMENT ON COLUMN pdd_constraint.ordinal_position IS 'Позиция колонки в таблице'
/
COMMENT ON COLUMN pdd_constraint.parent_table_schema IS 'Родитель. Наименование схемы таблицы'
/
COMMENT ON COLUMN pdd_constraint.parent_table_name IS 'Родитель. Имя таблицы'
/
COMMENT ON COLUMN pdd_constraint.parent_column_name IS 'Родитель. Имя колонки'
/
COMMENT ON COLUMN pdd_constraint.constraint_type IS 'Тип констрайнта'
/
COMMENT ON COLUMN pdd_constraint.constraint_name IS 'Имя констрайнта'
/

