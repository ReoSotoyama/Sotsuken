<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
    <head>

		<div align="center">
        <meta http-equiv="content-type" content="text/html" charset="utf-8">
        <title>モリジョビ報告書検索</title>
        </div>
        <style>
 	       .pulldownset .vegetable{
			border-top:1px solid
			}
			.mainselect{
				background: #FFFFF1;
			  	width: 300px;
				padding: 10px;
				text-align: center;
				border: 1px solid #cccccc;
				margin: 30px auto;
			}
			.subbox{
  				background:#FFFFF1;
  				width: 300px;
  				padding: 10px;
  				text-align: center;
  				border: 1px solid #cccccc;
			}
			.year{
				background: #FFFFF1;
			  	width: 100px;
				padding: 10px;
				text-align: center;
				border: 1px solid #cccccc;
				margin: 30px auto;

			}
			.successorfailure{
				background: #FFFFF1;
			  	width: 100px;
				padding: 10px;
				text-align: center;
				border: 1px solid #cccccc;
				margin: 30px auto;
			}
		.search{
				background-color:#FF8300;
				width: 180px;
				height: 40px;
				cursor:pointer;
				color: #fff;
				font-size: 25px;
				font-weight:bold;
				text-align: center;
		}
		.form-control{
			text-align: center;
			background:#FFFFF1;
			width: 500px;
			height: 50px;
			font-size: 14px;
			color:#000000;
			margin: 0px 30px 0px 430px;
		}
		.back{
		background-color:#FF8300;
				width: 180px;
				height: 40px;
				cursor:pointer;
				color: #fff;
				font-size: 25;
				font-weight:bold;
				float: left;
				text-align: center;
		}
		.mainselect1{
				background: #FFFFF1;
			  	width: 300px;
				padding: 10px;
				text-align: center;
				border: 1px solid #cccccc;
				position: relative;
				top: 10px;
		}
		.label{
		font-size: 25;
		font-weight:bold;
		}
		.return{
		background-color:#FF8300;
   width: 180px;
   height: 40px;
   cursor:pointer;
   color: #fff;
   font-size: 25px;
   font-weight:bold;
   position: absolute;
    left: 3%; top: 90%"
		}
        </style>
    </head>
<body>
<h1 align="center">モリジョビ報告書検索</h1>

<form name="" id="id_form1" action="./Search_Servlet" method="post">

<input  name="name" type="text"  class="form-control" maxlength="30" placeholder="企業名入力" >
<div class="pulldownset vegetable"  align="center">
<br>

	<!-- 折り畳み展開ポインタ -->
<div onclick="obj=document.getElementById('open').style; obj.display=(obj.display=='none')?'block':'none';">
<a style="cursor:pointer;" align="left">▼ 詳細設定</a>
</div>
<!--// 折り畳み展開ポインタ -->

<!-- 折り畳まれ部分 -->


<!--ここの部分が折りたたまれる＆展開される部分になります。
自由に記述してください。-->
<div id="open" style="display:none;clear:both;">

<select name="department" class="mainselect">
  <option value="指定なし">学科を選択</option>
  <option value="指定なし">------指定しない----</option>
  <option value="情報システム科">情報システム科</option>
  <option value="ネットワークセキュリティ科">ネットワークセキュリティ科</option>
  <option value="総合システム工学科">総合システム工学科</option>
  <option value="高度情報工学科">高度情報工学科</option>
  <option value="情報ビジネス科">情報ビジネス科</option>
  <option value="会計ビジネス科">会計ビジネス科</option>
  <option value="デザイン科">デザイン科</option>
  <option value="総合デザイン科">総合デザイン科</option>
</select>
<table>
  			<select name="course1" id="情報システム科" class="subbox">
		 		<option value="指定なし">------指定しない----</option>
				<option value="システムエンジニアコース">システムエンジニアコース</option>
				<option value="スマートフォンアプリ開発コース">スマートフォンアプリ開発コース</option>
			</select>

			<select name="course2" id="ネットワークセキュリティ科" class="subbox">
				<option value="指定なし">------指定しない----</option>
				<option value="ネットワークエンジニアコース">ネットワークエンジニアコース</option>
				<option value="情報セキュリティコース">情報セキュリティコース</option>
			</select>

			<select name="course3" id="総合システム工学科" class="subbox">
				<option value="">------指定しない----</option>
				<option value="WEBプログラマーコース">WEBプログラマーコース</option>
				<option value="組込みシステムコース">組込みシステムコース</option>
				<option value="ゲームプログラマーコース">ゲームプログラマーコース</option>
			</select>
			<select name="course4" id="高度情報工学科" class="subbox">
				<option value="指定なし">------指定しない----</option>
				<option value="高度情報工学科">高度情報工学科</option>
			</select>
			<select name="course5" id="情報ビジネス科" class="subbox">
				<option value="指定なし">------指定しない----</option>
				<option value="情報ビジネスコース">情報ビジネスコース</option>
				<option value="公共ビジネスコース">公共ビジネスコース</option>
			</select>
			<select name="course6" id="会計ビジネス科" class="subbox">
				<option value="指定なし">------指定しない----</option>
				<option value="会計ビジネスコース">会計ビジネスコース</option>
				<option value="会計エキスパートコース">会計エキスパートコース</option>
			</select>
			<select name="course7" id="デザイン科" class="subbox">
				<option value="指定なし">------指定しない----</option>
				<option value="グラフィックデザインコース">グラフィックデザインコース</option>
				<option value="CGクリエイトコース">CGクリエイトコース</option>
				<option value="アニメ・マンガコース">アニメ・マンガコース</option>
				<option value="建築インテリアコース">建築インテリアコース</option>
			</select>
			<select name="course8" id="総合デザイン科" class="subbox">
				<option value="指定なし">------指定しない----</option>
				<option value="総合デザインコース">総合デザインコース</option>
			</select>

<script type="text/javascript">
// ▼HTMLの読み込み直後に実行：
document.addEventListener('DOMContentLoaded', function() {

   // ▼サブBOXを全て非表示にする
   var allSubBoxes = document.getElementsByClassName("subbox");
   for( var i=0 ; i<allSubBoxes.length ; i++) {
      allSubBoxes[i].style.display = 'none';
   }

   // ▼全てのプルダウンボックスごとに処理
   var mainBoxes = document.getElementsByClassName('pulldownset');
   for( var i=0 ; i<mainBoxes.length ; i++) {

      var mainSelect = mainBoxes[i].getElementsByClassName("mainselect");   // メインのプルダウンメニュー（※後でvalue属性値を参照するので、select要素である必要があります。）
      mainSelect[0].onchange = function () {
         // ▼同じ親要素に含まれている全サブBOXを消す
         var subBox = this.parentNode.getElementsByClassName("subbox");   // 同じ親要素に含まれる.subbox（※select要素に限らず、どんな要素でも構いません。）
         for( var j=0 ; j<subBox.length ; j++) {
            subBox[j].style.display = 'none';
         }

         // ▼指定されたサブBOXだけを表示する
         if( this.value ) {
            var targetSub = document.getElementById( this.value );   // 「メインのプルダウンメニューで選択されている項目のvalue属性値」と同じ文字列をid属性値に持つ要素を得る
            targetSub.style.display = 'inline';
         }
      }

   }
});
</script>



	</table>

<select name="industry" class="mainselect">
<option value="指定なし">業種</option>
<option value="指定なし">---指定しない---</option>
<option value="メーカー">メーカー</option>
<option value="商社">商社</option>
<option value="流通・小売">流通・小売</option>
<option value="金融">金融</option>
<option value="サービス・インフラ">サービス・インフラ</option>
<option value="ソフトウェア・通信">ソフトウェア・通信</option>
<option value="広告・出版・マスコミ">広告・出版・マスコミ</option>
<option value="官公庁・公社・団体">官公庁・公社・団体</option>
</select>

<select name="occupation" class="mainselect">
<option value="指定なし">職種</option>
<option value="指定なし">---指定しない---</option>
<option value="営業・事務・企画系">営業・事務・企画系</option>
<option value="サービス・販売系">サービス・販売系</option>
<option value="コンサルタント・金融・不動産">専門職系(コンサルタント・金融・不動産)</option>
<option value="ソフトウェア・ネットワーク">技術系(ソフトウェア・ネットワーク)</option>
<option value="電気・電子・機械">技術系(電気・電子・機械)</option>
<option value="素材・食品・メディカル">技術系(素材・食品・メディカル)</option>
<option value="建築・土木">技術系(建築・土木)</option>
<option value="クリエイティブ系">クリエイティブ系</option>
<option value="その他">その他(教師・公務員など)</option>
</select>

<select name="area" class="mainselect">
<option value="指定なし">エリア</option>
<option value="指定なし">---指定しない---</option>
<option value="北海道地方">北海道地方</option>
<option value="東北地方">東北地方</option>
<option value="関東地方">関東地方</option>
<option value="中部地方">中部地方</option>
<option value="近畿地方">近畿地方</option>
<option value="中国地方">中国地方</option>
<option value="四国地方">四国地方</option>
<option value="九州地方">九州地方</option>
</select>


<p>
<select name="year" class="mainselect1">
<option value="指定なし">年度</option>
<option value="指定なし">---指定しない---</option>
<option value="29">H29</option>
<option value="30">H30</option>
</select>

<select name="acceptance" class="mainselect1">
<option value="指定なし">合否</option>
<option value="指定なし">---指定しない---</option>
<option value="合格">合格</option>
<option value="不合格">不合格</option>
</select>
</p>
<!--  <p><label class="label">ヘッダー番号検索　<input type="search" name="search" size="25" maxlength="8"></label></p>-->
</div>







<!--// 折り畳まれ部分 -->

<form  action="./Search_Servlet" method="post">
	<p>
		<button type="submit"  class="search" value="search" name="pagename">検索</button>
	</p>

		<div>
			<button class="return" type="submit"  value="return" name="pagename">戻る</button>
		</div>
</form>



</body>
</html>