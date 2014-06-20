<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh">

<%@ include file="header.jsp" %>
<body>

	<div data-role="page">
		<div data-role="header" data-position="fixed">
			<h1>狼人的上帝</h1>
		</div>
		<!-- /header -->
		
		<div style="margin:0 auto;"><img src="assets/img/th.jpg"></div>
		<div data-role="content">
			<ul data-role="listview" data-dividertheme="d" style="margin-top: 0;"> 
				<li><a href="#nav2">游戏规则</a></li> 
				<li><a href="#nav2">游戏帮助</a></li>
			</ul>
		</div>
		<!-- /content -->
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a href="#nav1">加入房间</a></li>
					<li><a data-ajax="false" href="${pageContext.request.contextPath}/openroom">新建游戏</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
		<!-- /footer -->
	</div>
	<!-- /page -->


	<div data-role="page" id="nav1" data-position="fixed">

		<div data-role="header">
			<h1>加入游戏</h1>
		</div>
		<!-- /header -->

		
		<div data-role="content">
			<form action="#">
			<label
			 class="select ui-select">	输入房间号码加入房间</label>
				<input type="text" name="roomnumber" id="roomnumber" /> <input
					type="submit" value="确定" />
			</form>
		</div>
		<!-- /content -->
  <div data-role="footer" data-position="fixed">
			&nbsp;
		</div>
	</div>
	<!-- /page -->

	<div data-role="page" id="nav2" data-position="fixed">

		<div data-role="header">
			<h1>游戏规则</h1>
		</div>
		<!-- /header -->
		<div data-role="content">${pageContext.request.contextPath}/</div>
		<!-- /content -->
		<div data-role="footer" data-position="fixed">
			<h4> </h4>
		</div>
		<!-- /header -->
	</div>
	<!-- /page -->
</body>
</html>