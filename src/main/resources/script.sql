drop table if exists gametemplate;
drop table if exists gamereal;
drop table if exists gamerole;
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
id int not null auto_increment not null primary key,
gameid varchar(20) not null,
totalplayer int not null,
gstatus varchar(20),
daycount int,
lastchanged timestamp
);

create table gamerole(
id int not null auto_increment not null primary key,
gameid varchar(20) not null,
rolename varchar(12),
rolecount int,
rolecountreal int,
rstatus varchar(20),
lastchanged timestamp
);

create table player(
userid varchar(32) not null primary key,
gameid varchar(20),
rolename varchar(12),
cardnumber varchar(2),
isAlive varchar(12),
pstatus varchar(12),
acted varchar(12),
lover varchar(2)
);

create table roleaction(
id int not null auto_increment primary key,
gstatus varchar(20),
rolename varchar(12),
command varchar(60),
beanid varchar(60),
activation varchar(40),
nextcommand varchar(60),
feedback text
);

insert into roleaction(gstatus, rolename, command, beanid, feedback) values( 'NULL', '未分配', 'openroom', 'GameOpen', '开房成功，输入人数获取房间号码'); 
insert into roleaction(gstatus, rolename, command, beanid, feedback) values( 'NULL', '未分配', 'number', 'GameCounting', '开房成功，房间人数为##人，房间号码为##，请小伙伴们输入房间号码加入房间');

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

create table constants(
cname varchar(32) not null primary key,
cvalue varchar(120)
);

create table journal(
id int not null auto_increment primary key,
jdatetime datetime,
content text
);


