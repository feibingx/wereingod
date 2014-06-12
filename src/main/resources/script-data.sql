delete from roleaction;

insert into roleaction(gstatus, rolename, pstatus, command, beanid, feedback) values( 'NULL', '未分配', '空闲','openroom', 'GameOpen', '开房成功，输入人数获取房间号码'); 
insert into roleaction(gstatus, rolename, pstatus, command, beanid, feedback) values( 'NULL', '未分配', '房主', 'number', 'GameCounting', '开房成功，房间人数为##人，房间号码为##，请小伙伴们输入房间号码加入房间');
insert into roleaction(gstatus, rolename, pstatus, command, beanid, feedback) values( 'NULL', '未分配', '空闲', 'number', 'GameJoin', '加入房间成功');
