create table dict_meta
(
  id varchar(256) not null,
  is_deleted  boolean not null,
  description varchar(512) not null,
--   deleted_id varchar(256) generated always as (
--     case when is_deleted = true then id end
--   ),
  constraint dict_meta_pk primary key (id)
--   constraint dict_meta_uk unique (deleted_id)
)
/
comment on table dict_meta is 'Мета информация по справочникам.'
/
comment on column dict_meta.id is 'Идентификатор справочника.'
/
comment on column dict_meta.is_deleted is 'Признак удаленного справочника.'
/
comment on column dict_meta.description is 'Описание.'
/