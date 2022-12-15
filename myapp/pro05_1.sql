use shop;

create table test(id varchar(20), pw varchar(20));

insert into test values ('admin', '1234');
insert into test values ('kkt', '4444');

commit;

show databases;

show tables;

desc test;

select * from test;

drop table member;
create table member(
id varchar(20) primary key,
pw varchar(300) not null, 
email varchar(100) not null);

alter table member add createdDate datetime default now();
alter table member add modifiedDate datetime default now();

select * from member;

create table member(id varchar(20) primary key,
pw varchar(300) not null,
name varchar(50),
email varchar(100) not null,
tel varchar(20) not null,
addr1 varchar(200),
addr2 varchar(100),
postcode varchar(10),
regdate datetime default now()
);

commit;

select * from board;

