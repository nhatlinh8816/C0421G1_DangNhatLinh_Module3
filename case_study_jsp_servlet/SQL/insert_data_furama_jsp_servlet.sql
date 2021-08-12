use furama_resort_database;
insert into trinhdo
value(1,"Trung Cấp"),(2,"Cao đẳng"),(3,"Đại học"),(4,"Sau đại học");
insert into vitri (vitri_name)
value("Lễ tân"),("phục vụ"),("chuyên viên"),("giám sát"),("quản lý"),("giám đốc");
insert into loaikhach (loaikhach_name)
value("Diamond"),("Platinium"),("Gold"),("Silver"),("Member");
insert into bophan (bophan_name)
value("Sale – Marketing"),("Hành Chính"),("Phục vụ"),("Quản lý");
insert into kieuthue (kieuthue_name,kieuthue_gia)
value("Năm",120000000),("Tháng",10000000),("Ngày",300000),("Giờ",10000);
insert into loai_dichvu (loai_dichvu_name)
value("Villa"),("House"),("Room");
insert into nhanvien
value
(1,"Linh",3,3,3,"1994-2-13","001",1000000,"091","linh@gmail.com","Hải Châu"),
(2,"Quan",1,3,2,"1995-2-13","002",200000,"092","quan@gmail.com","Hải Châu"),
(3,"Bao",2,1,1,"1994-2-24","003",3000000,"093","bao@gmail.com","Đà Nẵng"),
(4,"Kiet",3,4,4,"1995-3-23","004",4000000,"094","binh@gmail.com","Huế"),
(5,"Nham Doanh Doanh",4,2,1,"2004-2-26","005",5000000,"095","doanh@gmail.com","Quảng Trị"),
(6,"Lam",3,4,1,"1996-2-23","006",6000000,"096","lam@gmail.com","Đà Nẵng"),
(7,"Tu",2,1,2,"1998-4-23","007",7000000,"097","minh@gmail.com","Quảng Trị"),
(8,"Ha",4,1,2,"1995-10-23","008",8000000,"098","ha@gmail.com","DakLak"),
(9,"Nhat",5,1,2,"2000-10-23","009",9000000,"099","nhat@gmail.com","Quảng Bình"),
(10,"Diep",6,3,2,"1990-10-12","010",10000000,"010","diep@gmail.com","Quảng Trị");
insert into khachhang
value
(1,1,"Tuan","1950-5-13","011","081","tuan@gmail.com","Quảng Ngãi"),
(2,1,"Nam","1980-6-13","012","082","nam@gmail.com","Quảng Ninh"),
(3,1,"Hai","2004-5-14","013","083","hai@gmail.com","Đà Nẵng"),
(4,2,"Son","1996-4-15","014","084","son@gmail.com","Quảng Trị"),
(5,5,"Ngoc","1999-10-15","015","085","ngoc@gmail.com","Vinh"),
(6,3,"Vy","1997-10-15","016","086","vy@gmail.com","Huế"),
(7,4,"Tuan","1970-5-13","017","087","tuandang@gmail.com","Hà Nội");
-- insert into dichvu
-- value 
-- -- (1,"villa1",400,3,8,10000000,1,1,"Đang sử dụng"),
-- -- (2,"house1",200,3,4,5000000,1,2,"Chưa sử dụng"),
-- -- (3,"room1",100,1,2,3000000,1,3,"Chưa sử dụng"),
-- -- (4,"villa2",400,3,8,9000000,2,1,"Chưa sử dụng"),
-- -- (5,"house2",200,3,4,4000000,2,2,"Chưa sử dụng"),
-- -- (6,"room2",100,1,2,2000000,2,3,"Đang sử dụng"),
-- -- (7,"villa3",400,3,8,8000000,3,1,"Chưa sử dụng"),
-- -- (8,"house3",200,3,4,3000000,3,2,"Chưa sử dụng"),
-- -- (9,"room3",100,1,2,1000000,3,3,"Đang sử dụng"),
-- -- (10,"villa4",400,3,8,10000000,4,1,"Chưa sử dụng"),
-- -- (11,"house4",200,3,4,2000000,4,2,"Chưa sử dụng"),
-- -- (12,"room4",100,1,2,500000,4,3,"Đang sử dụng");
-- insert into hopdong
-- value
-- (1,1,1,1,'2019-12-12','2019-12-20',1000000),
-- (2,2,1,2,'2019-12-12','2019-12-20',2000000),
-- (3,1,6,3,'2020-02-13','2020-02-22',2000000),
-- (4,2,2,4,'2018-02-13','2018-02-20',1000000),
-- (5,3,3,5,'2019-10-13','2019-10-20',1000000),
-- (6,1,5,12,'2015-12-12','2015-12-20',1000000),
-- (7,2,6,1,'2011-10-13','2011-010-17',1000000),
-- (8,6,4,10,'2019-10-13','2019-10-20',1000000),
-- (9,10,4,10,'2017-10-13','2017-10-20',1000000);
-- insert into dichvu_dikem
-- value
-- (1,"karaoke",1000000,"lần","Đang sử dụng"),
-- (2,"massage",900000,"lần","Chưa sử dụng"),
-- (3,"thức ăn",80000,"bữa","Đang sử dụng"),
-- (4,"nước uống",7000,"chai","Chưa sử dụng"),
-- (5,"xe di chuyển",110000,"chuyến","Đang sử dụng");
-- insert into hopdong_chitiet
-- value
-- (1,1,1,8),
-- (2,1,2,8),
-- (3,2,1,2),
-- (4,2,4,3),
-- (5,3,5,1),
-- (6,4,1,1),
-- (7,5,1,1),
-- (8,5,5,5),
-- (9,6,5,2),
-- (10,6,1,1),
-- (11,7,4,1),
-- (12,7,3,1),
-- (13,8,2,2),
-- (14,8,5,5),
-- (15,9,2,2);