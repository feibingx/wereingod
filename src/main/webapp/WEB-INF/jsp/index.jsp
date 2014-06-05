<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh">
<head>
<meta charset="utf-8">
<title>测试</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Author: William Wang -->
<!--  www.zhiweiwang.com  -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

<style type="text/css">
</style>
</head>
<body>

	<div></div>
	<div >

		<table id="tblTestingdata" width="100%">
			<tr>
				<td style="text-align: center;" colspan="5"><a
					class="btn pull-right" onclick="addhonor()">点此添加</a></td>
			</tr>
			<tr>
				<td width="75px;">userid</td>
				<td width="75px;">userrole</td>
				<td width="75px;">Command</td>
				<td width="75px;">button</td>
				<td>feedback</td>
			</tr>
			<tr>
				<td><input id="userid0" name="userid0" value="userid0" type="text" class="input" /></td>
				<td>
					<select class="role">
						
					</select>
				</td>
				<td><input id="command0" name="command0" type="text"
					class="input"></td>
				<td><input id="btn0" name="btn0" type="button" class="button" value="go"></td>
				<td><div id="feedback0"></div></td>
			</tr>
		</table>
	</div>

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery.validate.js"></script>
	<script src="assets/js/bootstrap-transition.js"></script>
	<script src="assets/js/bootstrap-alert.js"></script>
	<script src="assets/js/bootstrap-modal.js"></script>
	<script src="assets/js/bootstrap-dropdown.js"></script>
	<script src="assets/js/bootstrap-scrollspy.js"></script>
	<script src="assets/js/bootstrap-tab.js"></script>
	<script src="assets/js/bootstrap-tooltip.js"></script>
	<script src="assets/js/bootstrap-popover.js"></script>
	<script src="assets/js/bootstrap-button.js"></script>
	<script src="assets/js/bootstrap-collapse.js"></script>
	<script src="assets/js/bootstrap-carousel.js"></script>
	<script src="assets/js/bootstrap-typeahead.js"></script>
	<script src="assets/js/application.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

		});
		var ccnt=1;
		function addhonor(){}
		function addhonorxx() {
			$("#tblTestingdata")
					.append(
							"");
			ccnt++;
		}
	</script>
</body>
</html>