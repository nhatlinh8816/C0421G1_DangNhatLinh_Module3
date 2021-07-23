create database demo;
use demo;
create table products (
id int primary key not null auto_increment,
product_code varchar(10),
product_name varchar(25),
product_price int,
product_amount int,
product_description varchar(25),
product_status varchar(25));
insert into products (product_code,product_name,product_price,product_amount,product_description,product_status)
value
('TV','Ti vi',10000000,2,'Hàng nhập khẩu','Kho 1'),
('TL','Tủ lạnh',5000000,5,'Hàng nội địa','Kho 2'),
('ĐH','Điều hòa',7000000,3,'Hàng trưng bày','cửa hàng'),
('MT','Máy tính',4000000,5,'Hàng nội địa','Kho 2');

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục);
create unique index index_product_code on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice);
create unique index index_product_name_and_price on products(product_name,product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào;
explain
select * 
from products
where product_name in ('Ti vi');

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.

create view code_name_price_status as select product_code,product_name,product_price,product_status
from products;

select* from code_name_price_status;
 
-- Tiến hành sửa đổi view;
update code_name_price_status
set product_status = 'cửa hàng'
where product_name = 'Máy tính';
select* from code_name_price_status;

-- Tiến hành xoá view;

drop view code_name_price_status;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product;
delimiter //
create procedure displayy_all_product()
begin
	select*
	from products;
end;
//

call demo.displayy_all_product();
//
insert into products (product_code,product_name,product_price,product_amount,product_description,product_status)
value
('ĐT','Điện thoại',3000000,2,'Hàng nhập khẩu','Kho 3');
//
call demo.displayy_all_product();
-- Tạo store procedure thêm một sản phẩm mới;
delimiter //
create procedure insert_product(`code` varchar(20),`name` varchar(20),price int,amount int, `description` varchar(20), `status` varchar(20) )
begin
	insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
    value(`code` ,`name` ,price ,amount, `description`, `status`);
end;
//

call insert_product('XM','Xe Máy',4000000,2,'Hàng nhập khẩu','Kho 5');
//
call demo.displayy_all_product();

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_product(id_edit int,`code` varchar(20),`name` varchar(20),price int,amount int, `description` varchar(20), `status` varchar(20) )
begin
	update products
    set product_code = `code`,product_name = `name`,product_price = price,product_amount=amount,
    product_description = `description`,product_status = `status`
    where id = id_edit;
end;
//

call demo.edit_product(1,'MLN','Máy lọc nước',200000,5,'Hàng nhập khẩu','Kho 3');
//
call demo.displayy_all_product()
//
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product(id_delete int)
begin
	delete from products
    where id = id_delete;
end;
//
call demo.delete_product(7);
//
call demo.displayy_all_product();
//
call demo.delete_product(5);
//
call demo.displayy_all_product();