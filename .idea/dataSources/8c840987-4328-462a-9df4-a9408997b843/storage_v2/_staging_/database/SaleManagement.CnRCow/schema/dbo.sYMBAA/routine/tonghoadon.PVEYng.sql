
create function tonghoadon(@dongia int , @soluong int)
returns MONEY
begin
    declare  @tongtien money
    SELECT @tongtien = @dongia* @soluong
    return @tongtien
end
go

