create table users
(
	userid int primary key auto_increment,
    firstname varchar(20),
    lastname varchar(20)
);

create table address
(
	addressid int primary key auto_increment,
    area varchar(20),
    userid int,
    constraint fk_1_address foreign key (userid) references users(userid)
);