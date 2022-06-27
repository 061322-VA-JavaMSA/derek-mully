drop table if exists users cascade;

create table if not exists users(
	user_id serial primary key,
	firstname varchar(30),
	lastname varchar(30),
	username varchar(30) unique not null check(length(username) > 2),
	password varchar(30) not null
);

drop table if exists items cascade;

create table if not exists items(
	item_id serial primary key,
	item varchar(30)
);

drop table if exists customers cascade;

create table if not exists customers(
	customer_id serial primary key,
	bid_made integer,
	owned_item serial references items(item_id)
);

drop table if exists payments cascade;

create table if not exists payments(
	payment_id serial primary key,
	pending_payment integer references users(user_id)
);

drop table if exists employees cascade;

create table if not exists employees(
	employee_id serial primary key
);

drop table if exists offers cascade;

create table if not exists offers(
	offer_id serial primary key
);

insert into items(item)
values ('BigFork')
;

insert into items(item)
values ('RegularFork')
;

insert into items(item)
values ('LittleFork')
;

alter table offers
	add price integer
;

drop table if exists employee cascade;

create table if not exists employee(
	user_id serial primary key,
	firstname varchar(30),
	lastname varchar(30),
	username varchar(30) unique not null check(length(username) > 2),
	password varchar(30) not null
);	

alter table items
rename column item to itemName;

alter table items
	add price integer
;

alter table users
	drop column firstname
;

alter table users
	drop column lastname
;

alter table users 
	add isAdmin varchar(10)
;

insert into users(isAdmin)
values ('isAdmin')
;

alter table users
rename column isAdmin to admin;

alter table users
rename column Admin to isAdmin;

UPDATE public.users
SET username='derek', "password"='derek', isadmin='1'
WHERE user_id=5;

UPDATE public.items
SET itemname='BigFork', price='20'
WHERE item_id=1;

UPDATE public.items
SET itemname='RegularFork', price='15'
WHERE item_id=2;

UPDATE public.items
SET itemname='LittleFork', price='10'
WHERE item_id=3;

drop table if exists users cascade;

create table if not exists payment(
);

DROP TABLE IF EXISTS payments

alter table offers
	add user_id integer
;

insert into offers(user_id) select user_id from users;

alter table offers
	add item_id integer
;

insert into offers(item_id) select item_id from items;

alter table offers
	add offer integer
;

alter table offers
	add status varchar(20)
;

alter table payment
	add user_id integer
;

insert into payment(user_id) select user_id from users;

alter table payment
	add item_id integer
;

insert into payment(item_id) select item_id from items;

alter table payment
	add status varchar(20)
;

insert into payment(status) select status from offers;

alter table payment
	rename to payments;
	
alter table payments
	add offer integer
;

insert into payments(offer) select offer from offers;

alter table payments 
	add payment_id serial primary key
;
