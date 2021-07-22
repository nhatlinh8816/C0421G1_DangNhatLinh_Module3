use furama_resort_database;
insert into trinhdo
value(1,"Trung Cấp"),(2,"Cao đẳng"),(3,"Đại học"),(4,"Sau đại học");
insert into vitri (vitri_name)
value("Lễ tân"),("phục vụ"),("chuyên viên"),("giám sát"),("quản lý"),("giám đốc");
insert into loaikhach (loaikhach_name)
value("Diamond"),("Platinium"),("Gold"),("Silver"),("Member");
insert into bophan (bophan_name)
value("Sale – Marketing"),("Hành Chính"),("Phục vụ"),("Quản lý");
insert into kieuthue (kieuthue_name)
value("Năm"),("Tháng"),("Ngày"),("Giờ");
insert into loai_dichvu (loai_dichvu_name)
value("Villa"),("House"),("Room");
insert into nhanvien
value(1,"Linh",3,3,3,"1994-2-13","001",1000000,"091","linh@gmail.com","Hà Nội"),
(2,"Quân",1,3,2,"1995-2-13","002",200000,"092","quan@gmail.com","Đà Nẵng"),
(3,"Bảo",2,1,1,"1994-2-24","003",3000000,"093","bao@gmail.com","Đà Nẵng"),
(4,"Bình",3,4,4,"1995-3-23","004",4000000,"094","binh@gmail.com","Huế"),
(5,"Doanh",4,2,1,"2004-2-26","005",5000000,"095","doanh@gmail.com","Quảng Trị"),
(6,"Lâm",3,4,1,"1996-2-23","006",6000000,"096","lam@gmail.com","Đà Nẵng"),
(7,"Minh",2,1,2,"1998-4-23","007",7000000,"097","minh@gmail.com","Quảng Trị"),
(8,"Hà",4,1,2,"1995-10-23","008",8000000,"098","ha@gmail.com","DakLak"),
(9,"Nhật",5,1,2,"2000-10-23","009",9000000,"099","nhat@gmail.com","Quảng Bình"),
(10,"Diệp",6,3,2,"1990-10-12","010",10000000,"010","diep@gmail.com","Quảng Trị");
insert into khachhang
value
(1,1,"Tuấn","1990-5-13","011","081","tuan@gmail.com","Hà Nội"),
(2,2,"Nam","1980-6-13","012","082","nam@gmail.com","Quảng Ninh"),
(3,3,"Hải","2004-5-14","013","083","hai@gmail.com","Đà Nẵng"),
(4,4,"Sơn","1996-4-15","014","084","son@gmail.com","Quảng Trị"),
(5,5,"Ngọc","1999-10-15","015","085","ngoc@gmail.com","Đồng Nai");
