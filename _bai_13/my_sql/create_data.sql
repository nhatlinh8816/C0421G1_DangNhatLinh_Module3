
create database demo1;
use demo1;
create table type_of_country(
id int not null auto_increment,
`name` varchar(50) not null,
primary key (id)
);
insert into type_of_country(`name`) values("Asia");
insert into type_of_country(`name`) values("Europe");
insert into type_of_country(`name`) values("Africa");
insert into type_of_country(`name`) values("America");

create table country(
id int not null,
`name` varchar(50) not null,
type_of_country_id int,
primary key (`name`),
foreign key(type_of_country_id) references type_of_country(id)
);

insert into country(id,`name`,type_of_country_id) values(1,"Vietnam",1);
insert into country(id,`name`,type_of_country_id) values(2,"Kenia",3);
insert into country(id,`name`,type_of_country_id) values(3,"England",2);
insert into country(id,`name`,type_of_country_id) values(4,"USA",4);



create table `users`(
id int not null auto_increment,
`name` varchar(50) not null,
email varchar(120) not null,
country varchar(120) not null,
primary key(id),
foreign key (country) references country(`name`)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','VietNam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
insert into users(name, email, country) values('Tom','tom@ca.uk','England');
insert into users(name, email, country) values('Joe','tom@ca.usa','USA');



