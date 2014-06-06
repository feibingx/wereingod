drop table if exists gametemplate;
drop table if exists gamereal;
drop table if exists player;
drop table if exists roleaction;
drop table if exists vote;
drop table if exists werewalfkill;
drop table if exists constants;
drop table if exists journal;

create table gametemplate(
ID int not null auto_increment primary key,
totalplayer int not null,
rolename varchar(12),
rolenumber int
);

create table gamereal(
id varchar(20) not null primary key,
totalplayer int not null,
rolename varchar(12),
rolecount int,
rolecountreal int,
status varchar(20),
daycount int
);

create table player(
userid varchar(32) not null primary key,
gameid varchar(20) not null,
rolename varchar(12),
cardnumber int,
isAlive varchar(12),
acted varchar(12),
lover int
);

create table roleaction(
id int not null auto_increment primary key,
gstatus varchar(20),
rolename varchar(12),
commandtext varchar(60),
activation varchar(40),
nextcommand varchar(60),
feedback text
);

create table vote(
ID int not null auto_increment primary key,
userid varchar(32) not null,
gameid varchar(20),
daycount int,
votenumber int
);

create table werewalfkill(
ID int not null auto_increment primary key,
userid varchar(32) not null,
gameid varchar(20),
daycount int,
votenumber int
);

create table constant(
cname varchar(32) not null primary key,
cvalue varchar(120)
);

create table journal(
id int not null auto_increment primary key,
jdatetime datetime,
content text
);

