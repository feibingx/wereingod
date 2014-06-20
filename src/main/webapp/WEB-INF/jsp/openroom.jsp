<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh">
<%@ include file="header.jsp" %>
<body>
	<div data-role="page" id="home" data-url="home" tabindex="0"
		class="ui-page ui-body-a ui-page-active" style="min-height: 909px;">
		<div data-role="header" class="ui-header ui-bar-a" role="banner">
		<span><a href="open" style="float: left;"> back</a></span>
			<h1 class="ui-title" tabindex="0" role="heading" aria-level="1">新建游戏</h1>
		</div>
		<form action="/godinwere/openroom" method="POST" data-ajax="false">
			<div data-role="content" class="ui-content" role="main">
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label for="select-choice-1" class="select ui-select">总人数</label> <span
						class="ui-select"> <input type="range" name="totalnumber"
						id="totalnumber" value="8" min="6" max="16" />
					</span>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select"><img
						src="/godinwere/assets/img/wolf.png" width="31px" />狼人数</label> <span
						class="ui-select"> <input type="range" name="wolves"
						id="wolves" value="3" min="2" max="6" />
					</span>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select pull-left"><img
						src="/godinwere/assets/img/seer.png" width="31px" />先知</label>
					<div class="ui-select">
						<select name="seer" id="seer" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select pull-left"><img
						src="/godinwere/assets/img/witch.png" width="31px" />女巫</label>
					<div class="ui-select">
						<select name="witch" id="witch" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select pull-left"><img
						src="/godinwere/assets/img/thief.png" width="31px" />盗贼</label>
					<div class="ui-select">
						<select name="thief" id="thief" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select pull-left"><img
						src="/godinwere/assets/img/hunter.png" width="31px" />猎人</label>
					<div class="ui-select">
						<select name="hunter" id="hunter" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select pull-left"><img
						src="/godinwere/assets/img/gardian.png" width="31px" />守卫</label>
					<div class="ui-select">
						<select name="gardian" id="gardian" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select pull-left"><img
						src="/godinwere/assets/img/cupid.png" width="31px" />丘比特</label>
					<div class="ui-select">
						<select name="cupid" id="cupid" data-role="slider">
							<option value="off">关闭</option>
							<option value="on" selected>开启</option>
						</select>
					</div>
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select pull-left"><img
						src="/godinwere/assets/img/villager.png" width="31px" />普通村民</label>
						<div id="villagenumber" class="ui-select">123</div>
					<input type="hidden" id="village" name="village" /> 
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<input id="btnGo" type="submit" value="确定开始" />
				</div>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$("#totalnumber").change(calTotalNumber);
			$("#wolves").change(calTotalNumber);
			$("#thief").change(calTotalNumber);
			$("#cupid").change(calTotalNumber);
			$("#seer").change(calTotalNumber);
			$("#witch").change(calTotalNumber);
			$("#hunter").change(calTotalNumber); 
			$("#gardian").change(calTotalNumber); 

			function calTotalNumber() {
				var total = $("#totalnumber").val();
				var wolves = $("#wolves").val();
				var village = total - wolves;

				if ($("#witch").val() == "on")
					village--;
				if ($("#cupid").val() == "on")
					village--;
				if ($("#seer").val() == "on")
					village--;
				if ($("#hunter").val() == "on")
					village--;
				if ($("#gardian").val() == "on")
					village--;
				if ($("#thief").val() == "on")
					village++;
				
				
				$("#villagenumber").html(village+"人");
				$("#village").val(village);
			}
		});
	</script>
</body>
</html>