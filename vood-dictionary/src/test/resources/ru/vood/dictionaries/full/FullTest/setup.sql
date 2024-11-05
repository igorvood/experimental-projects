INSERT INTO meta_type_col (id, description) VALUES ('String', 'String');
INSERT INTO meta_type_col (id, description) VALUES ('Int', 'Int');
INSERT INTO meta_type_col (id, description) VALUES ('Date', 'Date');
INSERT INTO meta_type_col (id, description) VALUES ('Bool', 'Bool');
INSERT INTO meta_type_col (id, description) VALUES ('Obj', 'Obj');
INSERT INTO dict_meta (id, is_deleted, description) VALUES ('currency', false, 'currency');
INSERT INTO dict_meta (id, is_deleted, description) VALUES ('type_acc', false, 'type_acc');
INSERT INTO dict_meta (id, is_deleted, description) VALUES ('percent', false, 'percent');
INSERT INTO dict_meta (id, is_deleted, description) VALUES ('department', false, 'department');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('ISO', 'currency', 'String', null, false, 'currency_ISO');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('name', 'currency', 'String', null, false, 'currency_name');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('code', 'type_acc', 'String', null, false, 'type_acc_code');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('name', 'type_acc', 'String', null, false, 'type_acc_name');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('currency', 'percent', 'Obj', 'currency', false, 'percent_currency');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('type_acc', 'percent', 'Obj', 'type_acc', false, 'percent_type_acc');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('value', 'percent', 'String', null, false, 'percent_value');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('id', 'department', 'String', null, false, 'department_id');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('parent_id', 'department', 'Obj', 'department', false, 'department_parent_id');
INSERT INTO dict_column_meta (id, dict_id, type_col_id, ref_dict_id, is_deleted, description) VALUES ('name', 'department', 'String', null, false, 'department_name');
