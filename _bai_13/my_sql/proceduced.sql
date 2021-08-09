use demo1;
-- Proceduced:
-- Hiển thị danh sách:
delimiter //
create procedure display_all_user()
begin
	select id, name, email, country from `users`;
end;
//

call display_all_user();
//


//
call display_all_user();
//
create procedure edit_user(edit_id int, new_name varchar(20), new_email varchar(50), new_country varchar(20))
begin
	update `users` set `name` = new_name, email = new_email, country =new_country where id = edit_id;
end;    
//

//
create procedure delete_user(delete_id int)
begin
	delete from `users`  where id = delete_id;
end;
//
