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

<style id="clearly_highlighting_css" type="text/css">/* selection */
html.clearly_highlighting_enabled ::-moz-selection {
	background: rgba(246, 238, 150, 0.99);
}

html.clearly_highlighting_enabled ::selection {
	background: rgba(246, 238, 150, 0.99);
} /* cursor */
html.clearly_highlighting_enabled {
	/* cursor and hot-spot position -- requires a default cursor, after the URL one */
	cursor:
		url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--cursor.png")
		14 16, text;
} /* highlight tag */
em.clearly_highlight_element {
	font-style: inherit !important;
	font-weight: inherit !important;
	background-image:
		url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--yellow.png");
	background-repeat: repeat-x;
	background-position: top left;
	background-size: 100% 100%;
} /* the delete-buttons are positioned relative to this */
em.clearly_highlight_element.clearly_highlight_first {
	position: relative;
} /* delete buttons */
em.clearly_highlight_element a.clearly_highlight_delete_element {
	display: none;
	cursor: pointer;
	padding: 0;
	margin: 0;
	line-height: 0;
	position: absolute;
	width: 34px;
	height: 34px;
	left: -17px;
	top: -17px;
	background-image:
		url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--delete-sprite.png");
	background-repeat: no-repeat;
	background-position: 0px 0px;
}

em.clearly_highlight_element a.clearly_highlight_delete_element:hover {
	background-position: -34px 0px;
} /* retina */
@media ( min--moz-device-pixel-ratio : 2) , ( -webkit-min-device-pixel-ratio : 2)
		, ( min-device-pixel-ratio : 2) {
	em.clearly_highlight_element {
		background-image:
			url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--yellow@2x.png");
	}
	em.clearly_highlight_element a.clearly_highlight_delete_element {
		background-image:
			url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--delete-sprite@2x.png");
		background-size: 68px 34px;
	}
} 
[touch-action="none"] {
	-ms-touch-action: none;
	touch-action: none;
}

[touch-action="pan-x"] {
	-ms-touch-action: pan-x;
	touch-action: pan-x;
}

[touch-action="pan-y"] {
	-ms-touch-action: pan-y;
	touch-action: pan-y;
}

[touch-action="scroll"],[touch-action="pan-x pan-y"],[touch-action="pan-y pan-x"]
	{
	-ms-touch-action: pan-x pan-y;
	touch-action: pan-x pan-y;
}
</style>
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