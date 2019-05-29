create table owner (
	owner_name varchar(100) not null
);
create table pet (
	pet_id int not null,
	pet_name varchar(100),
	owner_name varchar(100),
	price int,
	birth_date date
);