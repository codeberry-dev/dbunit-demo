create table customer
(
    id int auto_increment,
    name varchar(100) not null,
    age int default 10 not null,
    address varchar(200) null,
    constraint customer_pk primary key (id)
);

