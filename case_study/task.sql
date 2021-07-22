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
 -- group by bảng vừa tạo theo name
 select id,`name`,hạng,maHD,tenDV,ngayBĐ,ngayKT ,sum(Tong_tien) from temp group by `name`;
 
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
 
 -- Task 13: 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
 -- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
 
 select dichvu_dikem_id,dichvu_dikem_name,count(hopdong_chitiet.soluong)
 from dichvu_dikem
 join hopdong_chitiet on dichvu_dikem.dichvu_dikem_id = hopdong_chitiet.dichvu_dikem_dichvu_dikem_id
 group by dichvu_dikem.dichvu_dikem_id
 having count(hopdong_chitiet.soluong) >= all(select count(hopdong_chitiet.soluong) from dichvu_dikem
 join hopdong_chitiet on dichvu_dikem.dichvu_dikem_id = hopdong_chitiet.dichvu_dikem_dichvu_dikem_id
 group by dichvu_dikem.dichvu_dikem_id )
 

 
 
 
 
 
 
 
 
 
 
 

 
 
 
 

 
 
 
 
 