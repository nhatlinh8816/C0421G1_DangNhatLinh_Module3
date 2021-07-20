use quanlybanhang;
insert into customer 
value (1,'Minh Quan', 10),(2,'Ngoc Oanh', 20),(3,'Hong Ha', 50);
insert into `Order` (oID,cID,oDate)
value (1,1,'2006-03-21'),(2,2,'2006-03-23'),(3,1,'2006-03-16');
insert into product 
value (1,'May Giat',3),(2,'Tu Lanh',5),(3,'Dieu Hoa',7),(4,'Quat',1),(5,'Bep Dien',2);
insert into orderdetail 
value (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);
select oID,cID,oDate from `order`;
select customer.cID,customer.cName,product.pID,product.pName
from customer join `order` on customer.cID = `order`.cID join orderdetail on  `order`.oID = orderdetail.oID 
join product on orderdetail.pID = product.pID;
select * from customer where cID not in (select cID from `order`);
select orderdetail.oID,`order`.oDate,sum(odQTY*product.pPrice) as oTotalPrice  
from `order` join orderdetail  on `order`.oID = orderdetail.oID
join product on orderdetail.pID = product.pID
group by orderdetail.oID;




