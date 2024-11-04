create table dict_value
(
  dict_id varchar(256) not null,
  col_id varchar(256) not null,
  val_s varchar(512),
  val_n numeric,
  val_d timestamp,
  val_c text,
  constraint dict_value_pk primary key (dict_id, col_id),
  constraint dict_value_dict_fk foreign key (dict_id, col_id) references dict_column_meta(dict_id, id) on delete cascade
)
/
comment on table dict_value is 'Значенияя справочников.'
/
comment on column dict_value.dict_id is 'Идентификатор справочника.'
/
comment on column dict_value.col_id is 'Идентификатор колонки.'
/
comment on column dict_value.val_s is 'Значение строка.'
/
comment on column dict_value.val_n is 'Значение число.'
/
comment on column dict_value.val_d is 'Значение дата.'
/
comment on column dict_value.val_c is 'Значение большая строка.'
/