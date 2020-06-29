create database bank;
use bank;

create table customer(
	cust_id int(10) primary key auto_increment,
	first_name varchar(20) not null;
	last_name varchar(20) not null;
	email varchar(20),
	address varchar(100) not null
);

create table account(
	acc_id int(10) primary key auto_increment),
	acc_no int(10),
	balance int,
	cust_id int(10),
	constraint fw_key foreign key(acc_id) references customer(cust_id)
);

insert into customer values(101,"Ankit","Agrawal", "ankit.agrawal@gmail.com","katraj,pune");
insert into customer values(102, "Rahul", "Agrawal", "rahul.agrawal@gmail.com","deccan,pune");
insert into customer values(103,"kanishk","Agrawal", "kanishk.agrawal@gmail.com","Swargate,pune");

insert into account values(201,901,50000,101);
insert into account values(202,902,60000,101);
insert into account values(203,903,70000,102);
""