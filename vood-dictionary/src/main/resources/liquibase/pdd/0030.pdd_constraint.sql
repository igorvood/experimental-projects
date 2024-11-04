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
        (tc.constraint_name, tc.table_schema) = ((kcu.constraint_name, kcu.table_schema))
    join information_schema.constraint_column_usage ccu on
        (ccu.constraint_name, ccu.table_schema) = ((tc.constraint_name, tc.table_schema))
--     left join pg_catalog.pg_description d on d.objsubid = c.ordinal_position and d.objoid = t.oid
/
COMMENT ON VIEW pdd_constraint IS 'Метаинформация колонок таблиц базы'
/
COMMENT ON COLUMN pdd_constraint.schema_name IS 'Наименование схемы таблицы'
/
COMMENT ON COLUMN pdd_constraint.table_name IS 'Имя таблицы'
/
COMMENT ON COLUMN pdd_constraint.column_name IS 'Имя колонки'
/
COMMENT ON COLUMN pdd_constraint.ordinal_position IS 'Позиция колонки в таблице'
/
COMMENT ON COLUMN pdd_constraint.column_default IS 'Значение по умолчанию для колонки'
/
COMMENT ON COLUMN pdd_constraint.is_nullable IS 'Указывает, может ли колонка содержать NULI, значения'
/
COMMENT ON COLUMN pdd_constraint.data_type IS 'Тип данных колонки'
/
COMMENT ON COLUMN pdd_constraint.character_maximum_length IS 'Максимальная длина для символьных типов данных'
/
COMMENT ON COLUMN pdd_constraint.numeric_precision IS 'Точность для числовых типов данных'
/
COMMENT ON COLUMN pdd_constraint.numeric_precision_radix IS 'Основание точности для числовых типов данных '
/
COMMENT ON COLUMN pdd_constraint.numeric_scale IS 'Масштаб для числовых типов данных'
/
COMMENT ON COLUMN pdd_constraint.datetime_precision IS 'Точность для типов данных даты и времени'
/
COMMENT ON COLUMN pdd_constraint.interval_type IS 'Тип интервала'
/
COMMENT ON COLUMN pdd_constraint.interval_precision IS 'Точность интервала'
/
COMMENT ON COLUMN pdd_constraint.is_self_referencing IS 'Указывает, является ли колонка самоссылочной'
/
COMMENT ON COLUMN pdd_constraint.is_identity IS 'Указывает, является ли колонка идентификационной'
/
COMMENT ON COLUMN pdd_constraint.identity_generation IS 'Тип генерации идентификатора'
/
COMMENT ON COLUMN pdd_constraint. identity_start IS 'Начальное значение идентификатора'
/
COMMENT ON COLUMN pdd_constraint. identity_increment IS 'Инкремент значения идентификатора'
/
COMMENT ON COLUMN pdd_constraint. identity_maximum IS 'Максимальное значение идентификатора'
/
COMMENT ON COLUMN pdd_constraint. identity_minimum IS 'Минимальное значение идентификатора'
/
COMMENT ON COLUMN pdd_constraint. identity_cycle IS 'Опция цикличности идентификатора'
/
COMMENT ON COLUMN pdd_constraint. is_generated IS 'Указывает, является ли колонка сгенерированной'
/
COMMENT ON COLUMN pdd_constraint. generation_expression IS 'Выражение, используемое для генерации значения колонки'
/
COMMENT ON COLUMN pdd_constraint. column_comment IS 'Комментарий к колонке'
/

