create or replace view pdd_constraint as
SELECT
    tc.constraint_schema schema_name,
    tc.constraint_name,
    tc.table_name,
    tc.constraint_type,
    kcu.column_name,
    kcu.ordinal_position,
    rc.unique_constraint_schema,
    rc.unique_constraint_name
FROM information_schema.table_constraints tc
         left join information_schema.key_column_usage kcu on
    (tc.constraint_name, tc.table_schema, tc.table_name) = ((kcu.constraint_name, kcu.table_schema, kcu.table_name))
         left join information_schema.referential_constraints rc on
    (rc.constraint_name, rc.constraint_schema) = ((tc.constraint_name, tc.constraint_schema))
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
COMMENT ON COLUMN pdd_constraint.unique_constraint_schema IS 'Схема UK куда ссылается форен'
/
COMMENT ON COLUMN pdd_constraint.unique_constraint_name IS 'наименование UK куда ссылается форен'
/
COMMENT ON COLUMN pdd_constraint.constraint_type IS 'Тип констрайнта'
/
COMMENT ON COLUMN pdd_constraint.constraint_name IS 'Имя констрайнта'
/

