create table user_roles (
id serial primary key,
user_role varchar(30) 
);

insert into user_roles(user_role) values('manager');
insert into user_roles(user_role) values ('employee');
insert into user_roles(user_role) values ('placeholder');

drop table if exists users;
create table if not exists users(
id serial primary key,
username varchar(30) unique,
password varchar(30) not null,
first_name varchar(30),
last_name varchar(30),
email varchar(50),
role_id int references user_roles(id)
);

insert into users (username, password, first_name,last_name,email, role_id) values ('manager1', 'password', 'derek', 'dude','derek@derek.com', 1);
insert into users (username, password, first_name,last_name,email, role_id) values ('manager2', 'password', 'kevin', 'dude','kevin@kevin.com', 1);
insert into users (username, password, first_name,last_name,email, role_id) values ('employee1', 'password', 'chris', 'dude','chris@chris.com', 2);
insert into users (username, password, first_name,last_name,email, role_id) values ('carol', 'password', 'carol', 'dude','carol@carol.com', 2);
insert into users (username, password, first_name,last_name,email, role_id) values ('dave', 'password', 'dave', 'dude','dave@dave.com', 2);


create table reimbursement_status(
reimbursement_status_id serial primary key,
reim_status varchar(30) default 'pending'
);

insert into reimbursement_status (reim_status) values('accepted');
insert into reimbursement_status (reim_status) values('rejected');
insert into reimbursement_status (reim_status) values('pending');


create table reimbursement_type(
type_id serial primary key,
reimbursement_type varchar(30) default 'other'
);

insert into reimbursement_type (reimbursement_type) values('travel');
insert into reimbursement_type (reimbursement_type) values('lodging');
insert into reimbursement_type (reimbursement_type) values('food');
insert into reimbursement_type (reimbursement_type) values('other');


create table reimbursement(
id serial primary key,
amount int,
submitted timestamp NULL DEFAULT CURRENT_TIMESTAMP,
resolved timestamp NULL,
description text,
author_id int references users(id),
resolver_id int references users(id),
reimbursement_status_id int references reimbursement_status(reimbursement_status_id),
reimbursement_type_id int references reimbursement_type(type_id)
);

insert into reimbursement (amount, description,author_id ,resolver_id , reimbursement_status_id,reimbursement_type_id) values(450, 'flight to vegas branch', 2, 1, 3, 1);
insert into reimbursement (amount, description,author_id ,resolver_id , reimbursement_status_id,reimbursement_type_id) values(200, 'gas for commute to trade show', 3, 1, 1, 1);
insert into reimbursement(amount, description, author_id, resolver_id, reimbursement_status_id, reimbursement_type_id) values (240, 'hotel in vegas', 3, 1, 2, 2);