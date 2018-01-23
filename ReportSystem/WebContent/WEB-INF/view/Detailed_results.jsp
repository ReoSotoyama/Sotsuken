<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>就職試験結果報告書</title>
</head>

<body>

<h1 align="center">就職試験結果報告書</h1>
		<label class="label">ヘッダー番号：<input readonly="readonly" type="text" name="number"></label>

	<table class="type02" align="center">
			<tr>
				<th scope="row">合否</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">会社名</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">電話</th>
				<td>	<label>-</label>	<label>-</label>			</td>
			</tr>
			<tr>
				<th scope="row">所在地</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">学籍番号</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">氏名</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">学科・コース</th>
				<td>	<label>科</label><br>
						<label>コース</label>
				</td>
			</tr>
			<tr>
				<th scope="row">業種</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">職種</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">１次試験報告</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">２次試験報告</th>
				<td></td>
			</tr>
			<tr>
				<th scope="row">３次試験報告</th>
				<td></td>
			</tr>
	</table>


    <div class="noprint">
		<p><input class="btn1" type="submit" name="submit" value="戻る"></p>
    	<input class="btn2" type="button" value="印刷する" onclick="window.print();" />
	</div>



	<style>
	table.type02 {
			border-collapse: separate;
			border-spacing: 0;
			text-align: left;
			line-height: 1.5;
			border-top: 1px solid #ccc;
			border-left: 1px solid #ccc;
	}
	table.type02 th {
			width: 150px;
			padding: 10px;
			font-weight: bold;
			vertical-align: top;
			border-right: 1px solid #ccc;
			border-bottom: 1px solid #ccc;
			border-top: 1px solid #fff;
			border-left: 1px solid #fff;
			background: #eee;
	}
	table.type02 td {
			width: 350px;
			padding: 10px;
			vertical-align: top;
			border-right: 1px solid #ccc;
			border-bottom: 1px solid #ccc;
	}
	.btn1{
		background-color:#FF8300;
		width: 150px;
		height: 40px;
		cursor:pointer;
		color: #fff;
		font-size: 25px;
		font-weight:bold;
		float: left;
		position: fixed;
		left: 15px;
		bottom: 10px;
	}
	.btn2{
		background-color:#FF8300;
		width: 150px;
		height: 40px;
		cursor:pointer;
		color: #fff;
		font-size: 25px;
		font-weight:bold;
		float:right;
		position: fixed;
    	right: 15px;
    	bottom: 10px;
	}
		.label{
			margin-left: 400px;
		}
	@media print {
		.noprint {
			display: none;
		}


	}


	</style>
</body>
</html>
