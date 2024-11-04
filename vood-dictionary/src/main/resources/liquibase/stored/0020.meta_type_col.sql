create table meta_type_col
(
  id varchar(256) not null,
  description varchar(512) not null,
  constraint meta_type_col_pk primary key (id)
)
/
comment on table meta_type_col is 'Типы колонок.'
/
comment on column meta_type_col.id is 'Идентификатор типа.'
/
comment on column meta_type_col.description is 'Описание.'
/