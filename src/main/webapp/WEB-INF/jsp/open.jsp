<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh">
<head>
<meta charset="utf-8">
<title>狼人的上帝</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.0a3/jquery.mobile-1.0a3.min.css" />
<script src="http://code.jquery.com/jquery-1.5.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.0a3/jquery.mobile-1.0a3.min.js"></script>

<!-- Author: William Wang -->
<!--  www.zhiweiwang.com  -->

<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<style type="text/css">
</style>
</head>
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
					<li><a href="openroom">新建游戏</a></li>
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
		<div data-role="content">.</div>
		<!-- /content -->
		<div data-role="footer" data-position="fixed">
			<h4> </h4>
		</div>
		<!-- /header -->
	</div>
	<!-- /page -->
</body>
</html>