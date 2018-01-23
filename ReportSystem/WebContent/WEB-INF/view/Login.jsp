<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<style>
.sample{
	width:400px;
    font-size:20px;
    font-weight:bold;
    text-decoration:none;
    display:block;
    text-align:center;
    padding:8px 0 10px;
    color:#fff;
    background-color:#ff8300;
    position: absolute;
    left: 34%; top: 40%;

}
.sample1{
	width:200px;
    font-size:15px;
    font-weight:bold;
    text-decoration:none;
    display:block;
    text-align:center;
    padding:1px 0 10px;
    color:#fff;
    background-color:#2E9AFE;
    position: absolute;
    left: 41%; top: 55%;
}
.sample2{
	width:200px;
    font-size:15px;
    font-weight:bold;
    text-decoration:none;
    display:block;
    text-align:center;
    padding:1px 0 10px;
    color:#fff;
    background-color:#2E9AFE;
    position: absolute;
    left: 41%; top: 65%;
}
.form-control1{
	position: absolute;
	left: 570px; top: 120px;
}
.form-control2{
	position: absolute;
	left: 570px; top: 190px;
}
.error{
	color: #F00;
	position: absolute;
	right: 300px; top: 100px;
}
</style>
<meta charset="utf-8">
<title>報告書検索システム</title>


</head>

<body>
<h1 align="center"><font size=7>就職活動報告書</font></h1>
<form name="form1" id="id_form1" action="./Login_Servlet" method="post">

	<%if("error".equals(request.getAttribute("error"))){ %>
	<h4 class="error" align-"center">学籍番号またはパスワードが違います。</h4>

	<%} %>
	<h2 align="center">
		<input  name="Id" id="id_textBox1" type="text" value="" class="form-control1" maxlength="7" placeholder="学籍番号入力(数字)" required autofocus pattern="^[0-9A-Za-z]+$"></h2>

	<h3><input  name="pass" type="password" id="inputEmail"value="" class="form-control2" maxlength="20" placeholder="パスワード入力(半角英数字)" required autofocus pattern="^[0-9A-Za-z]+$"></h3>

  <div id="output">
	<button type='submit'  class="sample" onclick="onButtonClick()" name="pagename" value="login">ログイン</button>
  </div>
</form>

<form action="./Login_Servlet" method="post">
    <button href="./Registration" class="sample1"name="pagename" value="number">学籍番号登録</button>
</form>
<!-- <form action="./Login_Servlet" method="post">
    <button href="#" class="sample2" name="pagename" value="teach">教員ID登録</button>
</form> -->
</body>
</html>