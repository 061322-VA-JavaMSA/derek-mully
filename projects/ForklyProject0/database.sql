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