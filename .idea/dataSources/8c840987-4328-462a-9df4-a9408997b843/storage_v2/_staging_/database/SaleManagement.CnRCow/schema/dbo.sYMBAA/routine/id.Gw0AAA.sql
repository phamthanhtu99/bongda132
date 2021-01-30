create procedure id(@table varchar(50), @id varchar(5) output) as
            begin
                declare @checkdata int
                declare @nametable  varchar(2)
                exec dbo.checkdata @table, @checkdata output
                exec  dbo.CompactID @table,@nametable output
                if @checkdata = 0
                    set @id = '0'
                else
                    exec dbo.MaxID @table, @id output
                     select @id = case
                                 when @id >= 0 and @ID < 9 then @nametable + '00' + CONVERT(char, CONVERT(int, @id) + 1)
                                 when @id >= 9 then  @nametable + '0' + CONVERT(char, CONVERT(int, @id) + 1)
                    end
            end
go

