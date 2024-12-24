<%-- <%@page import="com.redis.constants.Constants"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
select{
	width: 150px;
	background: var(--textHighlightBg);
	border-radius: 5px;
    height: 29px;
}
table {
	  border: 1px solid black;
	  border-collapse: collapse;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
<% boolean b = false;
out.println("var b = " + b + ";");
%>
	function getAllKeys(){
		b = true;
	}
	<% System.out.println("ubdujbd"); %>
	$(document).ready(function(){
	$("#allKeys").on('click', async function (){
		var url = "RedisProject";
		event.preventDefault();
		try {
			$.ajax({
				type : "GET",
				url : "/"+url+"/RedisDetailsPage",
				processData : false,
				contentType: "json",
				success : function(res) {
					$("#allKeys")
					updateFestivalsTable(res.data);
				},
				error : function(xhr, status, error) {
					var errorMessage = xhr.responseText;
					toastr.error(errorMessage, "Error");
					console.log(errorMessage);
				}
			});
		} catch (e) {
			console.log(e, "catch");
		}
	});
	$("#PerticualerKeys").on('click', async function (){
		var url = "RedisProject";
		event.preventDefault();
		console.log("jdnjd");
		try {
			$.ajax({
				type : "GET",
				url : "/"+url+"/RedisDetailsPageForParticularKey",
				data : {
					"key" : $("#input").val()
				},
				processData : true,
				contentType: "json",
				success : function(res) {
					$("#allKeys")
					updateFestivalsTable(res.data);
				},
				error : function(xhr, status, error) {
					var errorMessage = xhr.responseText;
					toastr.error(errorMessage, "Error");
					console.log(errorMessage);
				}
			});
		} catch (e) {
			console.log(e, "catch");
		}
	});
	});
	
	function updateFestivalsTable(allFestivals) {
	    var tableBody = $('#listData');
	    tableBody.empty();
		if(allFestivals==null || allFestivals.length < 1){
			return;
		}
		else if(allFestivals.length == 1 || allFestivals instanceof Array == false){
			var row = '<tr>' +
	            '<td>' + allFestivals + '</td>' +
	        '</tr>';
	        tableBody.append(row);
	        return;
		}
	    allFestivals.forEach(function(festival) {
	        var row = '<tr>' +
	            '<td>' + festival + '</td>' +
	        '</tr>';
	        tableBody.append(row);
	    });
	}
</script>
</head>
<body>
	<button id="allKeys">Get all keys</button>
	<input value="input" id="input" type="text" />
	<button id="PerticualerKeys">Get key data</button>
	<div id="listData" style="display='flex'"></div>
</body>
</html>