
create database `student-management`;
create table `student-management`.`student`(
`id` INT NOT null,
`name`varchar(45)null,
`age` varchar(45)null,
`country` varchar(45)null,
primary key(`id`));
create table `student-management`.`class`(
`id` INT NOT null,
`name`varchar(45)null,
primary key(`id`));
create table `student-management`.`teacher`(
`id` INT NOT null,
`name`varchar(45)null,
`age` varchar(45)null,
`country` varchar(45)null,
primary key(`id`));