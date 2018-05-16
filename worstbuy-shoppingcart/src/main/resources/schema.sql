create table product
(
	id integer not null,
	name varchar(255) not null,
	maker varchar(255) not null,
	model varchar(255) not null,
	description varchar(255) not null,
	price integer not null,
	category_id integer not null
);


create table category
(
	id integer not null,
	name varchar(255) not null,
	description varchar(255) not null
);