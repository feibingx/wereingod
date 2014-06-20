<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh">
<%@ include file="header.jsp"%>
<body>
	<div data-role="page" id="home" data-url="home" tabindex="0" class="ui-page ui-body-a ui-page-active"
		style="min-height: 909px;">
		<div data-role="header" class="ui-header ui-bar-a" role="banner">
			<span><a href="open" style="float: left;"> back</a></span>
			<h1 class="ui-title" tabindex="0" role="heading" aria-level="1">进入游戏</h1>
		</div>
		<form action="/godinwere/card" method="POST" data-ajax="false">
			<div data-role="content" class="ui-content" role="main">
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">你的房间号码是 ${gameid}。请伙伴们输入该号码进入房间游戏。</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<label class="select ui-select ">为自己选择一个游戏号码</label>
					<div class="ui-select">
						<select name="cardnumber" id="cardnumber"> 
							<c:forEach begin="1" end="${number}" step="1" var="i">
								<option value="${i}" />${i}</option>
							</c:forEach>
						</select>
					</div> 
					<input id="btnGo" type="button" value="确定开始" />
				</div>
				<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
					<input id="btnChoose" type="button" value="随机分配一个游戏号码" />
				</div>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {

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

				$("#villagenumber").html(village + "人");
				$("#village").val(village);
			}
		});
	</script>
</body>
</html>