create database cashbook;
use cashbook;
create table users (
    `username` CHAR(20) not null,
    `password` CHAR(16) not null,
    `mobileNumber` CHAR(11) not null,
    primary key (`username`)
);

insert into users(`username`,`password`,`mobileNumber`) values('lulu','lu123456','12345678910');
select * from `users`;
