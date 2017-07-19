--Tạo 1 Store Procedure để lấy toàn bộ danh sách CD/DVD
--từ khóa go để ngăn cách các lệnh để làm lệnh mới
create proc LayToanBoCDVaDVD
as
select * from CDDVDCollection

go

exec LayToanBoCDVaDVD

go
--Tạo 1 Store Procudure lấy danh sách CD/DVD có năm xuất bản bất kỳ
 create proc LayDanhSachCDVaDVDTheoNamXuatBan
 @namxb int
 as
 select * from CDDVDCollection where NamXuatBan=@namxb

 go
 exec LayDanhSachCDVaDVDTheoNamXuatBan @namxb=2016
 go
 exec LayDanhSachCDVaDVDTheoNamXuatBan @namxb=2015

 --Tạo 1 Store Procedure lấy danh sách theo loại đĩa và có năm xuất bản bất kỳ
 go
 create proc LayDanhSachDiaTheoLoaiVaNamXuatBanBatKy
 @loaidia nvarchar(50),
 @namxb int
 as
 select * from CDDVDCollection where LoaiDia=@loaidia and NamXuatBan=@namxb

 go
 exec LayDanhSachDiaTheoLoaiVaNamXuatBanBatKy @loaidia='DVD',@namxb=2016