create database `QuanLyBanHang`;
use QuanLyBanHang;
create table Customer(
cID int not null auto_increment primary key,
cName varchar(30) not null,
cAge int not null );
create table `Order`(
oID int not null auto_increment primary key,
cID int not null,
oDate datetime not null,
oTotalPrice float,
foreign key (cID) references Customer(cID)
);
create table `Product`(
pID int not null auto_increment primary key,
pName varchar(30) not null,
pPrice float not null
);
create table OrderDetail(
oID int not null,
pID int not null,
odQTY int not null,
foreign key (oID) references `Order`(oID),
foreign key (pID) references `Product`(pID));
