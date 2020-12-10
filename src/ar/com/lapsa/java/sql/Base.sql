CREATE USER 'root'@'%' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
drop database if exists Bares;
create database Bares;
use Bares;

drop table if exists Bar;
create table Bar(
    id int AUTO_INCREMENT NOT NULL primary key,
    bar varchar(30) not null    
);
