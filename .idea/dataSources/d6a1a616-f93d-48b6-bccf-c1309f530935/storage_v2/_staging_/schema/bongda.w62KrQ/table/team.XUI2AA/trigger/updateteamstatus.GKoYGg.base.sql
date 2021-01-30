create definer = root@localhost trigger updateteamstatus
    after update
    on team
    for each row
begin
    declare max int;
    declare min int;
    select membermin into min from  team where id=OLD.id;
    if(min = (select membermax from team where  id=OLD.id)) THen
        /*  update team set status = 2 where id= OLD.id;*/
        set max = min;
    end if;
end;

