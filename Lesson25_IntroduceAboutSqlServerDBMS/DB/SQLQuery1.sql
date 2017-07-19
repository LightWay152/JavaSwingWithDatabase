--Lấy danh sách khách hàng
select * from Customer
--Lấy danh sách nhóm khách hàng
select * from CustomerGroup
--Thêm nhóm mới vào bảng CustomerGroup
insert into CustomerGroup values('cusGroup1','VIP Customer')
insert into CustomerGroup values('cusGroup2', N'Việt Nam Customer')
insert into CustomerGroup values('cusGroup3','Prissy Customer')
--Xóa nhóm có mã nhóm là cusGroup2
delete from CustomerGroup where GroupId='cusGroup2'
--Cập nhật khách hàng Tây Độc có mã nhóm thành cusGroup3
update Customer set GroupID='cusGroup3' where CustomerID='cus1'
update Customer set GroupID='cusGroup1' where CustomerID='cus2'
update Customer set GroupID='cusGroup3' where CustomerID='cus3'
--Hãy lọc tất cả khách hàng thuộc nhóm khó tính
select * from Customer where GroupID='cusGroup3'

go
--Để tạo store procedure (viết hàm sử dụng)
--Ví dụ: tạo store procedure trả về toàn bộ danh sách khách hàng
create proc GetAllCustomer
as
select * from Customer
exec GetAllCustomer
--Ghi chú: muốn sửa proc thì thay create thành alter 
--(nhớ phải chạy create trước mới chạy đc alter)
--và phải dùng go đầu mỗi proc để ngăn cách các hàm

go
--Tạo store lấy khách hàng thuộc nhóm bất kỳ
create proc GetCustomerByGroup
@GroupId nvarchar(50)
as
select * from Customer where GroupId=@GroupId
go
exec GetCustomerByGroup @GroupId='cusGroup3'