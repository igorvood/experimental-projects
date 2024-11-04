create table dict_meta
(
  id varchar(256) not null,
  description varchar(512),
  constraint dict_meta_pkk primary key (id)
)
/
comment on table dict_meta is 'Мета информация по справочникам.'
/
comment on column dict_meta.id is 'Идентификатор справочника.'
/
comment on column dict_meta.description is 'Описание.'
/