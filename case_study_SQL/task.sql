use furama_resort_database;

-- Task 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.;
 select* from nhanvien where nhanvien_name regexp ('^[HTK]') and length(nhanvien_name)<=15;
 
 -- Task 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
 select* from khachhang where (timestampdiff(year,khachhang_date_of_birth,CURTIME()) between 18 and 50) 
 and khachhang_address in ('Đà Nẵng','Quảng Trị');
 
 -- Task 4:	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
 -- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
 -- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
 select khachhang.khachhang_id,khachhang.khachhang_name,count(hopdong.hopdong_id) as so_lan_thue
 from hopdong join khachhang on hopdong.khachhang_khachhang_id = khachhang.khachhang_id
 where khachhang.loaikhach_loaikhach_id in (1)
 group by hopdong.khachhang_khachhang_id
 order by so_lan_thue;
 
 -- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
 -- TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và 
 -- Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa 
 -- từng đặt phòng cũng phải hiển thị ra).
 
 -- Tạo bảng phụ đặt tên là temp
 create temporary table temp (select khachhang.khachhang_id as id ,khachhang.khachhang_name as `name` ,khachhang.loaikhach_loaikhach_id as hạng,
 hopdong.hopdong_id as maHD ,dichvu.dichvu_name as tenDV,hopdong.hopdong_start_date as ngayBĐ,hopdong.hopdong_end_date as ngayKT,
 (dichvu.dichvu_chiphithue) + sum(dichvu_dikem.dichvu_dikem_price*hopdong_chitiet.soluong) as Tong_tien
 from khachhang left join hopdong  on khachhang.khachhang_id = hopdong.khachhang_khachhang_id
 left join hopdong_chitiet on hopdong.hopdong_id = hopdong_chitiet.hopdong_hopdong_id
 left join dichvu_dikem on hopdong_chitiet.dichvu_dikem_dichvu_dikem_id =dichvu_dikem.dichvu_dikem_id
 left join dichvu on hopdong.dichvu_dichvu_id = dichvu.dichvu_id group by khachhang.khachhang_name ,hopdong.hopdong_id);

 -- group by bảng vừa tạo theo id
 select id,`name`,hạng,maHD,tenDV,ngayBĐ,ngayKT ,sum(Tong_tien) from temp group by `id`;
 
 -- Task 6: 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được 
 -- Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
 
 select dichvu_id, dichvu_name, dichvu_area,dichvu_chiphithue,loai_dichvu.loai_dichvu_name
 from dichvu left join hopdong on dichvu.dichvu_id = hopdong.dichvu_dichvu_id
 left join loai_dichvu on dichvu.dichvu_id = loai_dichvu.loai_dichvu_id
 where hopdong.hopdong_start_date <'2019-01-01' or hopdong.hopdong_start_date >='2019-04-01' or hopdong.hopdong_start_date is null ;
 
 -- Task 7 Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ 
 -- đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019
 
 select dichvu_id, dichvu_name, dichvu_area,dichvu.dichvu_number_person,dichvu_chiphithue,loai_dichvu.loai_dichvu_name
 from dichvu left join hopdong on dichvu.dichvu_id = hopdong.dichvu_dichvu_id
 left join loai_dichvu on dichvu.dichvu_id = loai_dichvu.loai_dichvu_id
 where year(hopdong.hopdong_start_date )=2018 and year(hopdong.hopdong_start_date )!=2019;
 
 -- Task 8 Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau (3 cách)
 -- C1
 select khachhang_name 
 from khachhang
 group by khachhang_name ;
 
 -- C2
 select distinct khachhang_name 
 from khachhang;
 

 -- Task 9:Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 
 -- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
 
 select month(hopdong_start_date) as tháng, count(hopdong_id) as so_khach_dat   
 from hopdong
 where year(hopdong_start_date) = 2019
 group by month(hopdong_start_date);
 
 -- Task 10:Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
 -- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, 
 -- SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet)
 
 select hopdong_id,hopdong_start_date,hopdong_end_date,tien_dat_coc,count(hopdong_chitiet.hopdong_chitiet_id) as so_lương_dichvu_dikem
 from hopdong join hopdong_chitiet on hopdong.hopdong_id = hopdong_chitiet.hopdong_hopdong_id
 group by  hopdong.hopdong_id;
 
 -- Task 11: Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
 -- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
 
 select dichvu_dikem_id,dichvu_dikem_name,khachhang_khachhang_id,khachhang_name,loaikhach_loaikhach_id
 from dichvu_dikem 
 join hopdong_chitiet on dichvu_dikem.dichvu_dikem_id = hopdong_chitiet.dichvu_dikem_dichvu_dikem_id
 join hopdong on hopdong_chitiet.hopdong_hopdong_id = hopdong.hopdong_id
 join khachhang on hopdong.khachhang_khachhang_id = khachhang.khachhang_id
 where(khachhang.loaikhach_loaikhach_id=1 and khachhang.khachhang_address in ("Vinh","Quảng Ngãi"));
 
 -- Task12: Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
 -- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 
 -- 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019 
 
 select hopdong.hopdong_id,nhanvien.nhanvien_name,khachhang.khachhang_name,khachhang.khachhang_phone_number,
 dichvu.dichvu_name,count(hopdong_chitiet.hopdong_chitiet_id) as SoLuongDichVuDikem, hopdong.tien_dat_coc
 from hopdong 
 join khachhang on hopdong.khachhang_khachhang_id = khachhang.khachhang_id
 join hopdong_chitiet on hopdong.hopdong_id = hopdong_chitiet.hopdong_hopdong_id
 join nhanvien on hopdong.nhanvien_nhanvien_id = nhanvien.nhanvien_id
 join dichvu on hopdong.dichvu_dichvu_id = dichvu.dichvu_id
 where year(hopdong.hopdong_start_date) = 2019 and month(hopdong.hopdong_start_date) in (10,11,12) 
 and month(hopdong.hopdong_start_date)  not in (1,2,3,4,5,6,7,8,9) 
 group by khachhang.khachhang_id ;
 
 -- Task 13: Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
 -- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
 
 select dichvu_dikem_id,dichvu_dikem_name,sum(hopdong_chitiet.soluong)
 from dichvu_dikem
 join hopdong_chitiet on dichvu_dikem.dichvu_dikem_id = hopdong_chitiet.dichvu_dikem_dichvu_dikem_id
 group by dichvu_dikem.dichvu_dikem_id
 having sum(hopdong_chitiet.soluong) >= all(select sum(hopdong_chitiet.soluong) from dichvu_dikem
 join hopdong_chitiet on dichvu_dikem.dichvu_dikem_id = hopdong_chitiet.dichvu_dikem_dichvu_dikem_id
 group by dichvu_dikem.dichvu_dikem_id );
 
 -- Task 14:Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
 -- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung
 
 select hopdong.hopdong_id,dichvu.dichvu_name,dichvu_dikem.dichvu_dikem_name,sum(hopdong_chitiet.soluong)
 from hopdong join dichvu on hopdong.dichvu_dichvu_id = dichvu.dichvu_id
 join hopdong_chitiet on hopdong.hopdong_id = hopdong_chitiet.hopdong_hopdong_id
 join dichvu_dikem on hopdong_chitiet.dichvu_dikem_dichvu_dikem_id = dichvu_dikem.dichvu_dikem_id
 group by dichvu_dikem.dichvu_dikem_id
 having sum(hopdong_chitiet.soluong) = 1;
 
 -- Task 15:Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
 -- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
 
 select nhanvien.nhanvien_id,nhanvien.nhanvien_name,trinhdo.trinhdo_name,nhanvien.nhanvien_phone_number,nhanvien.nhanvien_address,
 bophan.bophan_name
 from nhanvien join hopdong on nhanvien.nhanvien_id = hopdong.nhanvien_nhanvien_id
 join bophan on nhanvien.bophan_bophan_id = bophan.bophan_id
 join trinhdo on nhanvien.trinhdo_trinhdo_id = trinhdo.trinhdo_id
 where year(hopdong_start_date) in (2018,2019)
 group by hopdong.nhanvien_nhanvien_id
 having count(hopdong.hopdong_id) <= 3;
 

 
 -- Task 16: Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019
 delete from nhanvien
 where nhanvien.nhanvien_id not in (select hopdong.nhanvien_nhanvien_id from hopdong where year(hopdong_start_date) in (2017,2019));
 
 -- Tasck 17: Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
 -- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
 
 
 -- tạo một bảng tạm lưu dữ liệu khách hàng có tổng tiền trong năm 2019 > 10tr đặt tên là tongtien_2019_lon_hon_10tr 
 create temporary table tongtien_2019_lon_hon_10tr 
 (select id,`name`,hạng,maHD,tenDV,ngayBĐ,ngayKT ,sum(Tong_tien) from temp 
 where year(ngayBĐ) = 2019 
 group by maHD
 having sum(Tong_tien) >=10000000 );

select * from tongtien_2019_lon_hon_10tr; 
-- update dựa theo id_loai khach = 2 và có id trong bảng tongtien_2019_lon_hon_10tr vừa tạo;
 update khachhang
 set loaikhach_loaikhach_id = 1
 where loaikhach_loaikhach_id = 2 and khachhang_id in (select id from tongtien_2019_lon_hon_10tr );
 
  -- Task 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
   -- Xóa khóa ngoại cũ
alter table hopdong
DROP CONSTRAINT hopdong_ibfk_2;

  -- Bổ sung khóa ngoại mới thêm on delete cascade
alter table hopdong
add constraint hopdong_ibfk_2 foreign key (khachhang_khachhang_id) references khachhang(khachhang_id) on delete cascade;
 
  -- Xóa khóa ngoại cũ
 alter table hopdong_chitiet
DROP CONSTRAINT hopdong_chitiet_ibfk_1;

-- Bổ sung khóa ngoại mới thêm on delete cascade
alter table hopdong_chitiet
add constraint hopdong_chitiet_ibfk_1 foreign key (hopdong_hopdong_id) references hopdong(hopdong_id) on delete cascade;
  
create temporary table khachhang_hd_truoc2016
(select khachhang_id 
from khachhang 
join hopdong on khachhang.khachhang_id = hopdong.khachhang_khachhang_id
where year(hopdong.hopdong_start_date) < 2016);

select* from khachhang_hd_truoc2016;
delete from khachhang
where khachhang.khachhang_id in (select khachhang_id 
from khachhang_hd_truoc2016);
  
 -- Task 19: Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi
 
 create temporary table dichvu_dikem_2019
(select dichvu_dikem_id,dichvu_dikem_name,soluong,hopdong_start_date,hopdong.hopdong_id
from hopdong_chitiet
join dichvu_dikem on hopdong_chitiet.dichvu_dikem_dichvu_dikem_id = dichvu_dikem.dichvu_dikem_id
join hopdong on  hopdong_chitiet.hopdong_hopdong_id =hopdong.hopdong_id
where year(hopdong_start_date) = 2019
group by hopdong_chitiet_id);

 create temporary table dichvu_dikem_2019_so_luong_lon_hon10
(select*,sum(soluong) from dichvu_dikem_2019
group by dichvu_dikem_id
having sum(soluong)>=10);

select* from dichvu_dikem_2019_so_luong_lon_hon10;

update dichvu_dikem
set dichvu_dikem_price = dichvu_dikem_price*2
where dichvu_dikem_id 
in 
(select dichvu_dikem_id from dichvu_dikem_2019_so_luong_lon_hon10);

-- Task 20: 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi

 select nhanvien_id as id,nhanvien_name as name,nhanvien_email as email 
 ,nhanvien_phone_number as phone ,nhanvien_date_of_birth as dOb,nhanvien_address as address
 from nhanvien
 union all
 select khachhang_id,khachhang_name,khachhang_email,khachhang_phone_number,khachhang_date_of_birth,khachhang_address
 from khachhang;
 
 -- Task 21:Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
 -- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
 
 create view V_NHANVIEN
 as 
 select*
 from nhanvien 
 join hopdong on nhanvien.nhanvien_id = hopdong.nhanvien_nhanvien_id
 where nhanvien_address = "Hải Châu" and hopdong_start_date = "2019-12-12";
 
 select*
 from V_NHANVIEN;
 
 -- Task 22.Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
 -- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
 
 update V_NHANVIEN
 set nhanvien_address = "Liên Chiểu";
 
 -- Task 23.Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó 
 -- với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
 
 delimiter //
 create procedure delete_khachhang(delete_id int)
 begin
	delete from	khachhang
    where khachhang_id = delete_id;
 end; 
 //
 

//
call delete_khachhang(6);
 //
 -- Task 24: Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 
 -- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính 
 -- và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan
 
  delimiter //
 create procedure Sp_2 (new_nhanvien_id int, new_khachhang_id int, new_dichvu_id int, 
						new_hopdong_start_date date, new_hopdong_end_date date, new_tiendatcoc int)
begin
	
    if new_nhanvien_id  in (select nhanvien_id from nhanvien) 
		and new_khachhang_id  in (select khachhang_id from khachhang)
        and new_dichvu_id in (select dichvu_id from dichvu)
    then 
    insert into hopdong (nhanvien_nhanvien_id, khachhang_khachhang_id , dichvu_dichvu_id, hopdong_start_date, hopdong_end_date,tien_dat_coc)
    value (new_nhanvien_id , new_khachhang_id, new_dichvu_id, new_hopdong_start_date, new_hopdong_end_date, new_tiendatcoc);
	else 
		SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = "Vui lòng nhập lại";
end if;
end;
//
drop procedure Sp_2;
//
call Sp_2 (15,1,1,'2019-12-12','2019-12-20',1000000);
call Sp_2 (1,1,20,'2019-12-12','2019-12-20',1000000);
call Sp_2 (1,1,1,'2019-12-12','2019-12-20',1000000);
call Sp_2 (15,1,1,'2019-12-12','2019-12-20',1000000);
//
call Sp_2 (1,1,1,'2019-12-12','2019-12-20',1000000);

//
-- Task 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 
-- để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan 
-- (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác



 
 
 
 

 
 
 
 

 
 
 
 
 