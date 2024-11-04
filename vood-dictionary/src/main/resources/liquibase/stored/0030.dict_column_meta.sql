create table dict_column_meta
(
  id varchar(256) not null,
  dict_id varchar(256) not null,
  type_col_id varchar(256) not null,
  is_deleted  boolean not null,
  description varchar(512) not null,
  constraint dict_column_meta_pk primary key (dict_id, id),
  constraint dict_column_meta_dict_fk foreign key (dict_id) references dict_meta(id) on delete cascade,
  constraint dict_column_meta_type_fk foreign key (type_col_id) references meta_type_col(id) on delete cascade
)
/
comment on table dict_column_meta is 'Мета информация по колонкам справочника.'
/
comment on column dict_column_meta.id is 'Идентификатор.'
/
comment on column dict_column_meta.is_deleted is 'Признак удаленной колонки.'
/
comment on column dict_column_meta.description is 'Описание.'
/
comment on column dict_column_meta.dict_id is 'Идентификатор справочника.'
/
comment on column dict_column_meta.type_col_id is 'Идентификатор типа колонки.'
/