create or replace view pdd_all_objects as
select nsp.nspname as schema_name,
       case pc.relkind
           when 'r' then 'table'
           when 'v' then 'view'
           when 'c' then 'type'
           when 'i' then 'index'
           else 'unsupported'
           end as object_type,
       pc.relname as object_name,
       obj_description(pc.oid) as comment
from pg_catalog.pg_class pc
  JOIN pg_catalog.pg_namespace nsp ON nsp.oid = pc.relnamespace
where nspname='db_configuration_manager'
--   and pc.relkind in ('r', 'v')
/
comment on view  pdd_all_objects is 'Мета информация об объектах в базе'
/
comment on column pdd_all_objects.schema_name is 'Наименование схемы'
/
comment on column pdd_all_objects.object_type is 'Тип объекта'
/
comment on column pdd_all_objects.comment is 'коментарий'
/
comment on column pdd_all_objects.object_name is 'Наименование Объекта'
/
