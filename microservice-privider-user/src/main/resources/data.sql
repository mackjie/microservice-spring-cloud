
-- 用户数据
INSERT INTO TM_USER (USER_NAME,NAME,AGE,BALANCE) VALUES('mackjie','吴豪磊',22,7500.00);
INSERT INTO TM_USER (USER_NAME,NAME,AGE,BALANCE) VALUES('zhangsan','张三',23,7500.00);
INSERT INTO TM_USER (USER_NAME,NAME,AGE,BALANCE) VALUES('lisi','李四',23,7700.00);
INSERT INTO TM_USER (USER_NAME,NAME,AGE,BALANCE) VALUES('wangwu','王五',24,8500.00);
INSERT INTO TM_USER (USER_NAME,NAME,AGE,BALANCE) VALUES('zhaoliu','赵六',25,9500.00);

-- 角色数据

INSERT INTO TM_ROLE(ROLE_NAME,DESC) VALUES ('系统管理员','系统管理员所有权限');
INSERT INTO TM_ROLE(ROLE_NAME,DESC) VALUES ('普通用户','系统管理员所有权限');
INSERT INTO TM_ROLE(ROLE_NAME,DESC) VALUES ('运维','系统管理员所有权限');
INSERT INTO TM_ROLE(ROLE_NAME,DESC) VALUES ('用户管理员','系统管理员所有权限');