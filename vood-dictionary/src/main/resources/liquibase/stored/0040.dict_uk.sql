create table dict_uk
(
    id varchar(256) not null,
    dict_id varchar(256) not null,
    col_id varchar(256) not null,
    constraint dict_uk_pk primary key (id, dict_id, col_id),
    constraint dict_uk_col_fk foreign key (dict_id, col_id) references dict_column_meta(dict_id, id) on delete cascade
)
/
comment on table dict_uk is 'Мета информация уникальным ключам справочника.'
/
comment on column dict_uk.id is 'Идентификатор UK.'
/
comment on column dict_uk.col_id is 'Идентификатор колонки.'
/
comment on column dict_uk.dict_id is 'Идентификатор справочника.'
/