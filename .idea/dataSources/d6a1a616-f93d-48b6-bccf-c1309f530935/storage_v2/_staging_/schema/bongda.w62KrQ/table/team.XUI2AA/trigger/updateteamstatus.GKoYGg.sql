create definer = root@localhost trigger updateteamstatus
    after update
    on team
    for each row
begin
    if(select * from team WHERE membermax= NEW.membermin)>1 then
        update  team set status =2 WHERE  id =NEW.id;

    end if;



end;

