<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh">
<head>
<meta charset="utf-8">
<title>狼人的上帝</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!--<base href="http://kayosite.com/demo/jQuery-Mobile-HTML5/Note-3/index.html">-->
<base href="." />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css" />
<script src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script src="http://code.jquery.com/jquery-1.5.min.js"></script>

</head>
<body class="ui-mobile-viewport">
	<div data-role="page" id="home" data-url="home" tabindex="0" class="ui-page ui-body-c ui-page-active"
		style="min-height: 909px;">
		<div data-role="header" class="ui-header ui-bar-a" role="banner">
			<h1 class="ui-title" tabindex="0" role="heading" aria-level="1">新建游戏</h1>
		</div>
		<form action="openroom" method="POST" data-ajax="false">
			<div data-role="content" class="ui-content" role="main">
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label for="select-choice-1" class="select ui-select">总人数</label> <span class="ui-select"> <input type="range"
						name="totalnumber" id="totalnumber" value="8" min="6" max="16" />
					</span>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select"><img src="assets/img/wolf.png" width="31px" />狼人数</label> <span class="ui-select">
						<input type="range" name="wolves" id="wolves" value="3" min="2" max="6" />
					</span>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select"><img src="assets/img/seer.png" width="31px" />先知</label>
					<div class="ui-select">
						<select name="seer" id="seer" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select"><img src="assets/img/witch.png" width="31px" />女巫</label>
					<div class="ui-select">
						<select name="witch" id="witch" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select"><img src="assets/img/thief.png" width="31px" />盗贼</label>
					<div class="ui-select">
						<select name="thief" id="thief" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select"><img src="assets/img/hunter.png" width="31px" />猎人</label>
					<div class="ui-select">
						<select name="hunter" id="hunter" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select"><img src="assets/img/cupid.png" width="31px" />丘比特</label>
					<div class="ui-select">
						<select name="cupid" id="cupid" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select"><img src="assets/img/villager.png" width="31px" />普通村民</label>
					<div class="ui-select" id="villiager"></div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<input id="btnGo" type="submit" value="确定开始" />
				</div>
			</div>
		</form>
	</div>
	</body>
</html>