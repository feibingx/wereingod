<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh">
<%@ include file="header.jsp" %>
<body>
	
	<form class="ui-body ui-body-a ui-corner-all" method="post" action="game">
		<fieldset>
			<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
				<label class="select ui-select" for="shipping">Shipping method:</label>
				<div class="ui-select">
					<div data-corners="true" data-shadow="true" data-wrapperels="span"   data-theme="a" class="ui-btn ui-shadow ui-btn-corner-all  ui-btn-up-a">
						<span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text"><span>Standard: 7 day</span></span>
 						</span> <select id="shipping" name="shipping">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
				</div>
			</div>
			<div data-role="fieldcontain" class="ui-field-contain ui-body ui-br">
				<label class="select ui-select" for="shipping">Shipping method:</label>
				<div class="ui-select">
					<div data-corners="true" data-shadow="true"   data-wrapperels="span"   data-theme="a" class="ui-btn ui-shadow ui-btn-corner-all ui-btn-up-a">
						<span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text"><span>xxxxx</span></span></span> <input type="text" />
					</div>
				</div>
			</div>
			<div data-corners="true" data-shadow="true"  data-wrapperels="span" 
				  data-theme="b" class="ui-btn ui-shadow ui-btn-corner-all ui-submit ui-btn-up-b" aria-disabled="false">
				<span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Submit</span></span>
				<button   name="btnsubmit" id="btnsubmit" data-theme="b" type="button" >Submit</button>
			</div>
			<div id="resultLog"></div>
		</fieldset>
	</form>
	<script> 
	$(document).ready(function() {
			$("#btnsubmit").click(function() {

				$.ajax({
					type : "POST",
					url : "game",
					data : ({
						name : $.trim($("#shipping").val())
					}), 
					dataType : "text",
					success : function(json) {
						$("#resultLog").html("Result:" +json);
					}
				});
				 
			});
		});
	</script>
</body>
</html>