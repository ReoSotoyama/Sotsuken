<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせフォーム</title>
</head>
<body>
<form action="./Completion_Servlet" method="post">
	<div class="box11">
    <p>
<div>
        <div>
        <h1>ユーザー登録完了</h1>
        <p>
        ユーザー登録完了しました。<br>
        トップページからログインしてください。
        </p>

            <button href="#" class="sample1"name="pagename" value="login">トップページに戻る</button>

    </div>
</div>
</p>
</div>
<style>
	.box11{
    	padding: 0.5em 1em;
    	margin: 2em 0;
    	color: #5d627b;
    	background: white;
    	border-left:  solid 5px #5d627b;
    	box-shadow: 0 3px 5px rgba(0, 0, 0, 0.22);
	}
	.box11 p {
    	margin: 0;
    	padding: 0;
	}
	.btn1{
			background-color:#FF8300;
			width: 150px;
			height: 30px;
			cursor:pointer;
			color: #fff;
			font-size: 13px;
			font-weight:bold;
		}
</style>
</form>
</body>
</html>