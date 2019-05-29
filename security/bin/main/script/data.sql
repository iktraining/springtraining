insert into t_user values(1, 'user', 'userpassword', '一般太郎', '開発部');
insert into t_user values(2, 'admin', 'adminpassword', '管理者次郎', '管理部');
insert into t_role VALUES (1, 'role_user', '一般ロール');
insert into t_role VALUES (2, 'role_admin', '管理ロール');
insert into t_user_role VALUES (1,1);
insert into t_user_role VALUES (2,2);