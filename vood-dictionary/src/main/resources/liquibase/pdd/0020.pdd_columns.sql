create or replace view pdd_columns as
SELECT
    table_schema as schema_name,
    table_name,
    column_name,
    ordinal_position,
    column_default,
    is_nullable,
    data_type,
    character_maximum_length,
    numeric_precision,
    numeric_precision_radix,
    numeric_scale,
    datetime_precision,
    interval_type,
    interval_precision,
    is_self_referencing,
    is_identity,
    identity_generation,
    identity_start,
    identity_increment,
    identity_maximum,
    identity_minimum,
    identity_cycle,
    is_generated,
    generation_expression,
    d.description as column_comment
FROM information_schema.columns c
    join pg_class t on t.relname = c.table_name
    left join pg_catalog.pg_description d on d.objsubid = c.ordinal_position and d.objoid = t.oid
/
COMMENT ON VIEW pdd_columns IS 'Метаинформация колонок таблиц базы'
/
COMMENT ON COLUMN pdd_columns.schema_name IS 'Наименование схемы таблицы'
/
COMMENT ON COLUMN pdd_columns.table_name IS 'Имя таблицы'
/
COMMENT ON COLUMN pdd_columns.column_name IS 'Имя колонки'
/
COMMENT ON COLUMN pdd_columns.ordinal_position IS 'Позиция колонки в таблице'
/
COMMENT ON COLUMN pdd_columns.column_default IS 'Значение по умолчанию для колонки'
/
COMMENT ON COLUMN pdd_columns.is_nullable IS 'Указывает, может ли колонка содержать NULI, значения'
/
COMMENT ON COLUMN pdd_columns.data_type IS 'Тип данных колонки'
/
COMMENT ON COLUMN pdd_columns.character_maximum_length IS 'Максимальная длина для символьных типов данных'
/
COMMENT ON COLUMN pdd_columns.numeric_precision IS 'Точность для числовых типов данных'
/
COMMENT ON COLUMN pdd_columns.numeric_precision_radix IS 'Основание точности для числовых типов данных '
/
COMMENT ON COLUMN pdd_columns.numeric_scale IS 'Масштаб для числовых типов данных'
/
COMMENT ON COLUMN pdd_columns.datetime_precision IS 'Точность для типов данных даты и времени'
/
COMMENT ON COLUMN pdd_columns.interval_type IS 'Тип интервала'
/
COMMENT ON COLUMN pdd_columns.interval_precision IS 'Точность интервала'
/
COMMENT ON COLUMN pdd_columns.is_self_referencing IS 'Указывает, является ли колонка самоссылочной'
/
COMMENT ON COLUMN pdd_columns.is_identity IS 'Указывает, является ли колонка идентификационной'
/
COMMENT ON COLUMN pdd_columns.identity_generation IS 'Тип генерации идентификатора'
/
COMMENT ON COLUMN pdd_columns. identity_start IS 'Начальное значение идентификатора'
/
COMMENT ON COLUMN pdd_columns. identity_increment IS 'Инкремент значения идентификатора'
/
COMMENT ON COLUMN pdd_columns. identity_maximum IS 'Максимальное значение идентификатора'
/
COMMENT ON COLUMN pdd_columns. identity_minimum IS 'Минимальное значение идентификатора'
/
COMMENT ON COLUMN pdd_columns. identity_cycle IS 'Опция цикличности идентификатора'
/
COMMENT ON COLUMN pdd_columns. is_generated IS 'Указывает, является ли колонка сгенерированной'
/
COMMENT ON COLUMN pdd_columns. generation_expression IS 'Выражение, используемое для генерации значения колонки'
/
COMMENT ON COLUMN pdd_columns. column_comment IS 'Комментарий к колонке'
/

