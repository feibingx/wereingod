delete from roleaction;

insert into roleaction(gstatus, rolename, command, beanid, feedback) values( 'NULL', '未分配', 'openroom', 'GameOpen', '开房成功，输入人数获取房间号码'); 
insert into roleaction(gstatus, rolename, command, beanid, feedback) values( 'NULL', '房主', 'number', 'GameCounting', '开房成功，房间人数为##人，房间号码为##，请小伙伴们输入房间号码加入房间');
insert into roleaction(gstatus, rolename, command, beanid, feedback) values( 'NULL', '未分配', 'number', 'GameJoin', '加入房间成功');


delete from gametemplate;

insert into gametemplate(totalplayer,rolename,rolenumber) values(8,'狼人',2);
insert into gametemplate(totalplayer,rolename,rolenumber) values(8,'先知',1);
insert into gametemplate(totalplayer,rolename,rolenumber) values(8,'女巫',1);
insert into gametemplate(totalplayer,rolename,rolenumber) values(8,'猎人',1);
insert into gametemplate(totalplayer,rolename,rolenumber) values(8,'普通村民',3);
