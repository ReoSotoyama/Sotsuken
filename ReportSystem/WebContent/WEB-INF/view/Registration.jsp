<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
<head>
<meta charset="utf-8">
<title>学籍番号登録</title>
</head>
<body>

<form action="./Registration_Servlet" method="post" name="form1" >
	<div align="center"><h1>学籍番号登録</h1>
		<div class="pulldownset vegetable">
			<select name="department" class="mainselect" required>
				<option value="">学科を選択</option>
				<option value="情報システム科">情報システム科</option>

				<option value="ネットワークセキュリティ科">ネットワークセキュリティ科</option>
				<option value="総合システム工学科">総合システム工学科</option>
				<option value="高度情報工学科">高度情報工学科</option>
				<option value="情報ビジネス科">情報ビジネス科</option>
				<option value="会計ビジネス科">会計ビジネス科</option>
				<option value="デザイン科">デザイン科</option>
				<option value="総合デザイン科">総合デザイン科</option>
			</select>

			<select name="course1" id="情報システム科" class="subbox">
				<option value="システムエンジニアコース">システムエンジニアコース</option>
				<option value="スマートフォンアプリ開発コース">スマートフォンアプリ開発コース</option>
			</select>

			<select name="course2" id="ネットワークセキュリティ科" class="subbox">
				<option value="ネットワークエンジニアコース">ネットワークエンジニアコース</option>
				<option value="情報セキュリティコース">情報セキュリティコース</option>
			</select>

			<select name="course3" id="総合システム工学科" class="subbox">
				<option value="WEBプログラマーコース">WEBプログラマーコース</option>
				<option value="組込みシステムコース">組込みシステムコース</option>
				<option value="ゲームプログラマコース">ゲームプログラマコース</option>
			</select>

			<select name="course4" id="高度情報工学科" class="subbox">
				<option value="高度情報工学科">高度情報工学科</option>
			</select>

			<select name="course5" id="情報ビジネス科" class="subbox">
				<option value="情報ビジネスコース">情報ビジネスコース</option>
				<option value="公共ビジネスコース">公共ビジネスコース</option>
			</select>

			<select name="course6" id="会計ビジネス科" class="subbox">
				<option value="会計ビジネスコース">会計ビジネスコース</option>
				<option value="会計エキスパートコース">会計エキスパートコース</option>
			</select>

			<select name="course7" id="デザイン科" class="subbox">
				<option value="グラフィックデザインコース">グラフィックデザインコース</option>
				<option value="CGクリエイトコース">CGクリエイトコース</option>
				<option value="アニメ・マンガコース">アニメ・マンガコース</option>
				<option value="建築インテリアコース">建築インテリアコース</option>
			</select>

			<select name="course8" id="総合デザイン科" class="subbox">
				<option value="総合デザインコース">総合デザインコース</option>
			</select>
  		</div>



		<script type="text/javascript">

		// HTMLの読み込み直後に実行：
		document.addEventListener('DOMContentLoaded', function() {

			// ▼とりあえずサブBOXを全て非表示にする（CSSで書けば早いが）
			var allSubBoxes = document.getElementsByClassName("subbox");
			for( var i=0 ; i<allSubBoxes.length ; i++) {
				allSubBoxes[i].style.display = 'none';
			}

			// ▼全てのプルダウンボックスごとに処理
			var mainBoxes = document.getElementsByClassName('pulldownset');
			for( var i=0 ; i<mainBoxes.length ; i++) {

				var mainSelect = mainBoxes[i].getElementsByClassName("mainselect");	// メインのプルダウンメニュー（※後でvalue属性値を参照するので、select要素である必要があります。）
				mainSelect[0].onchange = function () {
					// 同じ親要素に含まれている全サブBOXを消す
					var subBox = this.parentNode.getElementsByClassName("subbox");	// 同じ親要素に含まれる.subbox（※select要素に限らず、どんな要素でも構いません。）
					for( var j=0 ; j<subBox.length ; j++) {
						subBox[j].style.display = 'none';
					}

					// 指定されたサブBOXを表示する
					if( this.value ) {
						var targetSub = document.getElementById( this.value );	// 「メインのプルダウンメニューで選択されている項目のvalue属性値」と同じ文字列をid属性値に持つ要素を得る
						targetSub.style.display = 'inline';
					}
				}

			}

		});
		</script>
	</div>



	<div align="center">
		<input name="gakunen" type="radio" class="gakunen" value="1年" required>1年
		<input name="gakunen" type="radio" class="gakunen" value="2年" >2年
		<input name="gakunen" type="radio" class="gakunen" value="3年" >3年
		<input name="gakunen" type="radio" class="gakunen" value="4年" >4年

		<p>
		<b class="user">ユーザー名：
		<input type="text" name="user" size="20" maxlength="20" value="" required></b>
		</p>


		<p>
		<b class="gakuseki">学籍番号：
		<input class="number" type="text" name="number" size="20" maxlength="7" value="" required pattern="(0|[1-9][0-9]*)">※数字</b>
		</p>


		<p>
		<b>メールアドレス：</b>
		<input class="mail" type="text" name="mail" size="20" maxlength="30"value="">
		</p>

		<p>
		<b class="pass1">パスワード：
		<input type="password"  name="pass" size="20" maxlength="20"value="" required pattern="^[0-9A-Za-z]+$">※20文字以内,半角英数</b>
		</p>

		<p>
		<b class="pass2">パスワード確認入力：
		<input type="password" name="repass" size="20" maxlength="20"value="" required></b>
		</p>


<p><button type="submit" class="btn1" name="pagename" value="registration" >登録</button></p>

</div>

</form>
<form action="./Registration_Servlet" method="post">

		<p><button type="submit" class="btn2" name="pagename" value="back">戻る</button></p>
</form>





	<style>
		.user{
			margin-right: 17px;
		}
		.gakuseki{
			margin-left: 48px;
		}
		.pass1{
			margin-left: 150px;
		}
		.pass2{
			margin-right: 83px;
		}
		.mail{
			margin-right: 50px;
		}
		.btn1{
			background-color:#FF8300;
			width: 180px;
			height: 40px;
			cursor:pointer;
			color: #fff;
			font-size: 25px;
			font-weight:bold;


		}
		.btn2{
			background-color:#FF8300;
			width: 130px;
			height: 40px;
			cursor:pointer;
			color: #fff;
			font-size: 25px;
			font-weight:bold;
			float: left;

		}
		.gakunen{
			width: 20px;
			height:14px;
		}
	</style>

</body>
</html>
