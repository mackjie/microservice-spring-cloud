-- 创建数据库

DROP DATABASE IF exists springcloud;

CREATE DATABASE springcloud DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use springcloud;
DROP TABLE IF exists TM_USER;
-- 创建表
CREATE TABLE TM_USER (
 USER_ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 USER_NAME VARCHAR(20),
 NAME VARCHAR(50),
 AGE INT(3),
 BALANCE DECIMAL(10,2)
);