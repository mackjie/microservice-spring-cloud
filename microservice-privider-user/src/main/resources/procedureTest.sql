
CREATE TABLE TS_ROLE(
ROLE_ID NUMBER,
ROLE_NAME VARCHAR2(30),
ROLE_DESC VARCHAR2(100),
CREATE_TIME TIMESTAMP,
UPDATE_TIME TIMESTAMP
);

CREATE TABLE TS_RESOURCE(
ID NUMBER,
URL VARCHAR2(100),
RESDESC VARCHAR2(100),
CREATE_USER NUMBER,
CREATE_TIME DATE,
UPDATE_TIME DATE

);
drop table TM_USER;
create table TM_USER(
 USER_ID NUMBER,
 USER_NAME VARCHAR2(20),
 PASSWORD VARCHAR2(16),
 DEPT_NO NUMBER,
 AGE NUMBER,
 ADDRESS VARCHAR2(100),
 SALARY NUMBER
);
INSERT INTO TM_USER VALUES(1,'张三','132',1,22,'移通网络有限公司',13200);
INSERT INTO TM_USER VALUES(2,'李四','13222',1,23,'移通网络有限公司',13300);
INSERT INTO TM_USER VALUES(3,'王五','13233',1,24,'移通网络有限公司',13400);
INSERT INTO TM_USER VALUES(4,'赵六','132444',1,25,'移通网络有限公司',13500);

-- 编写存储过程
-- 1、根据用户姓名查询该用户的薪水
CREATE OR REPLACE PROCEDURE procedureTest(uName in VARCHAR2,uSalary out NUMBER)
AS
-- 声明临时变量
	-- uSalary TM_USER.SALARY%TYPE
BEGIN
	--SQL
	SELECT SALARY INTO uSalary FROM TM_USER WHERE USER_NAME = uName;
END procedureTest;
/
/** 调用存储过程方式,执行不能含有输出的存储方式 两种：
 1、exec procedureTest()
 2、直接调用
 begin
	procedureTest();
 end;
 /
*/

ALTER TABLE TM_USER ADD (BONUS NUMBER(20) DEFAULT(6000));

SELECT * FROM TM_USER;
-- 2、编写存储函数  根据用户名查询该用户的年薪
CREATE OR REPLACE FUNCTION procedureTest02(uName in VARCHAR2)
	return NUMBER
as
	tSalary TM_USER.SALARY%TYPE;
	tBonus TM_USER.BONUS%TYPE;
BEGIN
	SELECT SALARY,BONUS INTO tSalary,tBonus FROM TM_USER WHERE USER_NAME = uName;
	return NVL(tSalary*12, 0)+NVL(tBonus, 0);
END procedureTest02;
/

-- 3、编写存储过程或函数查询集合，薪水大于 1000的用户所有信息
-- 使用光标的方式进行获取数据
-- 创建包头---包名packageTest
create or replace package packageTest
as
--引用设置自定义变量
type uUserList is ref cursor; --类型为光标类型
--引用存储过程
procedure userListTest(uSalary in NUMBER,userList out uUserList);
end packageTest;

-- 创建包体
create or replace package body packageTest
as
	procedure userListTest(uSalary in NUMBER,userList out uUserList)
	as
	begin
		--执行SQL之前需要先打开光标
		open userList for select * from TM_USER WHERE SALARY > 1000;
	end userListTest;
end packageTest;
/


-- 查询数据库版本
select * from v$instance;