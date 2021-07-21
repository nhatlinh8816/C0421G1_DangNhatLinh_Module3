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
kieuthue_name varchar(45) not null);
create table loai_dichvu(
loai_dichvu_id int primary key not null auto_increment,
loai_dichvu_name varchar(45) not null);
create table nhanvien(
nhanvien_id int primary key not null auto_increment,
nhanvien_name varchar(45) not null,
vitri_vitri_id int,
trinhdo_trinhdo_id int,
bophan_bophan_id int,
nhanvien_date_of_birth datetime,
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
khachhang_date_of_birth datetime,
khachhang_cmnd varchar(45),
khachhang_phone_number varchar(45),
khachhang_email varchar(45),
khachhang_address varchar(45),
foreign key (loaikhach_loaikhach_id) references loaikhach(loaikhach_id));
create table dichvu(
dichvu_id int primary key not null auto_increment,
dichvu_name varchar(45) not null,
dichvu_area int,
dichvu_floor int,
dichvu_number_person int,
dichvu_chiphithue int,
kieuthue_kieuthue_id int,
loai_dichvu_loai_dichvu_id int,
trangthai varchar(45),
foreign key (kieuthue_kieuthue_id) references kieuthue(kieuthue_id),
foreign key (loai_dichvu_loai_dichvu_id) references loai_dichvu(loai_dichvu_id));


