create table t_role (id bigint primary key, role_name varchar(100), description varchar(100));
create table t_user (id bigint primary key, login_id varchar(20), password varchar(200), full_name varchar(100), dept_name varchar(200));
create table t_user_role(role_id bigint references t_role(id), user_id bigint references t_user(id));