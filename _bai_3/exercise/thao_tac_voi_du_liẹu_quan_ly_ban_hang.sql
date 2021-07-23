use quan_ly_ban_hang;
insert into customer 
value (1,'Minh Quan', 10),(2,'Ngoc Oanh', 20),(3,'Hong Ha', 50);
insert into `Order` (order_id,customer_customer_id,order_date)
value (1,1,'2006-03-21'),(2,2,'2006-03-23'),(3,1,'2006-03-16');
insert into product 
value (1,'May Giat',3),(2,'Tu Lanh',5),(3,'Dieu Hoa',7),(4,'Quat',1),(5,'Bep Dien',2);
insert into order_detail 
value (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);
select order_id,customer_customer_id,order_date 
from `order`;
select customer.customer_id,customer.customer_name,product.product_id,product.product_name
from customer join `order` on customer.customer_id = `order`.customer_customer_id 
join order_detail on  `order`.order_id = orderdetail.order_order_id
join product on order_detail.product_product_id = product.product_id;
select * 
from customer 
where customer_id not in (select customer_customer_id from `order`);
select order_detail.order_order_id,`order`.order_date,sum(order_detail_qty*product.product_price) as order_total_price  
from `order` 
join order_detail  on `order`.order_id = order_detail.order_order_id
join product on order_detail.product_product_id = product.product_id
group by order_detail.order_order_id;




