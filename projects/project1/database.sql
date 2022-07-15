create type ticket_type as enum ('LODGING', 'TRAVEL', 'FOOD', 'OTHER');
create type user_type as enum ('EMPLOYEE', 'MANAGER');
create type ticket_status as enum ('APPROVED', 'PENDING', 'DENIED');


drop table if exists users;
create table if not exists users(
user_id serial primary key,
user_name varchar(30),
username varchar(30) unique not null,
user_pass varchar(30) not null,
user_role user_type
);



--populate users table
insert into users(user_name,username,user_pass,user_role) values ('Chris','Chris','password','EMPLOYEE');
insert into users(user_name,username,user_pass,user_role) values ('Carol','Carol','password','EMPLOYEE');
insert into users(user_name,username,user_pass,user_role) values ('Derek','Derek','password','MANAGER');
insert into users(user_name,username,user_pass,user_role) values ('Nestor','Nestor','password','MANAGER');



drop table if exists tickets;
create table if not exists tickets(
ticket_id serial primary key,
ticket_ty varchar(30),
ticket_desc varchar(150),
ticket_amount float,
employee_id integer references users(user_id),
manager_id integer,
ticket_stat varchar(30)
);


--populate tickets table
insert into tickets(ticket_ty,ticket_desc,ticket_amount,employee_id, manager_id, ticket_stat) values ('FOOD','Applebees Work Meeting', '35', '1', '3', 'APPROVED');
insert into tickets(ticket_ty,ticket_desc,ticket_amount,employee_id, ticket_stat) values ('TRAVEL','Flying for Vegas Conference', '240', '1','PENDING');
update tickets set manager_id = 1 where ticket_id = 1;
insert into tickets(ticket_ty,ticket_desc,ticket_amount,employee_id, manager_id, ticket_stat) values ('OTHER','Vegas Casino Bill', '940', '2', '4', 'DENIED');