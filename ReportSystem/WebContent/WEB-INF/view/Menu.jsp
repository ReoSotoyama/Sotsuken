<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
<head>
<meta charset="utf-8">
<title>syukatsu2</title>
<script type="text/javascript" language="javascript">
        function onButtonClick() {
          target = document.getElementById("output");
          target.innerText = document.forms.id_form1.id_textBox1.value;
          //target.innerText = document.id_form1.id_textBox1.value;//これでもOK
        }
  </script>
</head>
<style>
	.h1{
		position: absolute;
  		left:590px;top:80px;
  		-moz-user-select: none;
  		-webkit-user-select: none;
  		-ms-user-select: none;
	}
	.sample1{
		width:200px;
    	font-size:18px;
    	font-weight:bold;
    	text-decoration:none;
    	display:block;
    	text-align:center;
    	padding:0px 0 10px;
    	color:#fff;
    	background-color:#2E9AFE;
    	position: absolute;
    	left: 1%; top: 2%
	}
	.sample2{
		width:500px;
    	font-size:23px;
    	font-weight:bold;
    	text-decoration:none;
    	display:block;
    	text-align:center;
   		padding:8px 0 30px;
    	color:#fff;
    	background-color:#2E9AFE;
    	position: absolute;
    	left: 31%; top: 35%
	}
	.sample3{
		width:500px;
    	font-size:23px;
    	font-weight:bold;
    	text-decoration:none;
    	display:block;
    	text-align:center;
    	padding:8px 0 30px;
    	color:#fff;
    	background-color:#2E9AFE;
    	position: absolute;
    	left: 31%; top: 55%;
	}
	.sample4{
		width:500px;
    	font-size:23px;
    	font-weight:bold;
    	text-decoration:none;
    	display:block;
    	text-align:center;
    	padding:8px 0 30px;
    	color:#fff;
    	background-color:#2E9AFE;
    	position: absolute;
    	left: 31%; top: 75%;
	}
	.return{
		background-color:#FF8300;
   		width: 130px;
   		height: 40px;
   		cursor:pointer;
   		color: #fff;
   		font-size: 25px;
   		font-weight:bold;
   		position: absolute;
    	left: 3%; top: 90%;
	}
</style>

<body>
<form name="2" action="./Menu_Servlet" method="post">
	<h1 class="h1"><font size="7">メニュー</font></h1>

	<div class="sample1"name ="user" value=<%= request.getAttribute("userNumber")%>>
		<%= request.getAttribute("userNumber") %>
	</div>



		<div>
			<button type="submit"  class="sample2" name="pagename" value="search">モリジョビの就職活動報告書検索</button>
		</div>





		<div>
			<button type="submit" class="sample3" name="pagename" value="report">報告書作成</button>
		</div>


		<div>
			<button type="submit" class="return" name="pagename" value="return">戻る</button>
		</div>
	</form>

</body>
</html>
