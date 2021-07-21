
create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table Customer(
customer_id int not null auto_increment primary key,
customer_name varchar(30) not null,
customer_age int not null );
create table `Order`(
order_id int not null auto_increment primary key,
customer_customer_id int not null,
order_date datetime not null,
order_total_price float,
foreign key (customer_customer_id) references Customer(customer_id)
);
create table `Product`(
product_id int not null auto_increment primary key,
product_name varchar(30) not null,
product_price float not null
);
create table order_detail(
order_order_id int not null ,
product_product_id int not null ,
CONSTRAINT orderDetail_pk PRIMARY KEY (order_order_id, product_product_id),
order_detail_qty int not null,
foreign key (order_order_id) references `Order`(order_id),
foreign key (product_product_id) references `Product`(product_id));
