drop database furama_resort_database;
create database furama_resort_database;
use furama_resort_database;
create table vitri(
vitri_id int primary key not null auto_increment,
vitri_name varchar(45) not null);
create table trinhdo(
trinhdo_id int primary key not null auto_increment,
trinhdo_name varchar(45) not null);
create table bophan(
bophan_id int primary key not null auto_increment,
bophan_name varchar(45) not null);
create table dichvu_dikem(
dichvu_dikem_id int primary key not null auto_increment,
dichvu_dikem_name varchar(45) not null,
dichvu_dikem_price varchar(45) not null,
dichvu_dikem_donvi varchar(45) not null,
dichvu_dikem_trangthaikhadung varchar(45));
create table loaikhach(
loaikhach_id int primary key not null auto_increment,
loaikhach_name varchar(45) not null);
create table kieuthue(
kieuthue_id int primary key not null auto_increment,
kieuthue_name varchar(45) not null,
kieuthue_gia double);
create table loai_dichvu(
loai_dichvu_id int primary key not null auto_increment,
loai_dichvu_name varchar(45) not null);
create table nhanvien(
nhanvien_id int primary key not null auto_increment,
nhanvien_name varchar(45) not null,
vitri_vitri_id int,
trinhdo_trinhdo_id int,
bophan_bophan_id int,
nhanvien_date_of_birth date,
nhanvien_cmnd varchar(45),
nhanvien_salary int,
nhanvien_phone_number varchar(45),
nhanvien_email varchar(45),
nhanvien_address varchar(45),
foreign key (vitri_vitri_id) references vitri(vitri_id),
foreign key (trinhdo_trinhdo_id) references trinhdo(trinhdo_id),
foreign key (bophan_bophan_id) references bophan(bophan_id));
create table khachhang(
khachhang_id int primary key not null auto_increment,
loaikhach_loaikhach_id int,
khachhang_name varchar(45) not null,
khachhang_date_of_birth date,
khachhang_cmnd varchar(45),
khachhang_phone_number varchar(45),
khachhang_email varchar(45),
khachhang_address varchar(45),
foreign key (loaikhach_loaikhach_id) references loaikhach(loaikhach_id));
create table dichvu(
dichvu_id int primary key not null auto_increment,
dichvu_name varchar(45) not null,
dichvu_area int,
dichvu_chiphithue double,
dichvu_number_person int,
kieuthue_kieuthue_id int,
loai_dichvu_loai_dichvu_id int,
dichvu_tieuchuan varchar(45),
trangthai varchar(45),
dichvu_pool_area double,
dichvu_floor int,
foreign key (kieuthue_kieuthue_id) references kieuthue(kieuthue_id),
foreign key (loai_dichvu_loai_dichvu_id) references loai_dichvu(loai_dichvu_id));
create table hopdong(
hopdong_id int primary key not null auto_increment,
nhanvien_nhanvien_id int,
khachhang_khachhang_id int,
dichvu_dichvu_id int,
hopdong_start_date datetime,
hopdong_end_date datetime,
tien_dat_coc int,
foreign key (nhanvien_nhanvien_id) references nhanvien(nhanvien_id),
foreign key (khachhang_khachhang_id) references khachhang(khachhang_id) ,
foreign key (dichvu_dichvu_id) references dichvu(dichvu_id));
create table hopdong_chitiet(
hopdong_chitiet_id int primary key not null auto_increment,
hopdong_hopdong_id int,
dichvu_dikem_dichvu_dikem_id int,
soluong int,
foreign key (hopdong_hopdong_id) references hopdong(hopdong_id) ,
foreign key (dichvu_dikem_dichvu_dikem_id) references dichvu_dikem(dichvu_dikem_id));




