drop table if exists users cascade;

create table if not exists customer(
	user_id serial primary key,
	first_name varchar(30),
	last_name varchar(30),
	user_name varchar(30) unique not null check(length(user_name) > 2),
	pass_word varchar(30) not null
);

drop table if exists items cascade;

create table if not exists items(
	item_id serial primary key
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
	pending_payment integer references customers(customer_id)
);

drop table if exists employees cascade;

create table if not exists employees(
	employee_id serial primary key
);

drop table if exists offers cascade;

create table if not exists offers(
	offer_id serial primary key
);