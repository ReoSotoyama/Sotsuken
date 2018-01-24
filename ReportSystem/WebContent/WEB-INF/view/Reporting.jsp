<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.EmployeeBean"%>
<% EmployeeBean sb = (EmployeeBean)request.getAttribute("section");%>
<html>
<head>
<meta charset="utf-8">
<title>報告書作成</title>
</head>

<body>
<form action="./Report_Servlet" method="post">
<h1><font size="64">報告書作成</font></h1>
   <div class="day"><p>提出日<br>平成<input type="text" name="year"maxlength="2" class="textfield_3" value=""  required/>年
   <input type="text" name="mouth" class="textfield_3" maxlength="2"value="" required />月
   <input type="text" name="day" class="textfield_3" maxlength="2" value=""  required/>日</p></div>　
   <style>
	   .day{
		   position : absolute ;

		   top  : 45px ;
		   left :750px ;
		   font-size : 20px ;

	   }
	   .textfield_3{
		   width : 50px ;
	   }
	</style>
   <div class="daimei"><h2>就職試験結果報告書</h2></div>
   <style>
	   .daimei{
		   position : absolute ;
		   top : 100px ;
		   left :350px ;
		   font-size: 20px ;

	   }
   </style>

   <div class="table_1"><table>


   	<tr>

		<td>合否</td>

   		<td>
  <select name="sof" class="hantei validate" required>
  <option value="">選択</option>
  <option value="合">合</option>
  <option value="不">否</option>
  </select>
  <style>
	  .hantei{
		  width : 600px ;

	  }
  </style>
        </td>


	</tr>
    <tr>
       <td>会社名</td>
       <td><input type="text" name="company" class="textfield validate"  value=""   maxlength="30" required/></td>
       <style>

		   input.textfield{
		   	width : 400px ;
		   }

       </style>
    </tr>

    <tr>
       <td>電話</td>
       <td><input type="text" name="phone" class="textfield_1 validate" value="" maxlength="3" required pattern="^[0-9]*"/>
       &nbsp;&nbsp;-<input type="text" name="phone1" class="textfield_1 validate"value=""  maxlength="4" required pattern="^[0-9]*"/>
       &nbsp;&nbsp;-<input type="text" name="phone2" class="textfield_1 validate" value=""  maxlength="4" required pattern="^[0-9]*"/>
       </td>

    </tr><style>
		   .textfield_1 {
			   width : 50px ;
		   }
		</style>
    <tr>
    <td>所在地</td>
    <td><textarea name = "location"  class = "textarea_1 validate" placeholder="ここに入力して下さい" value="" maxlength="50"></textarea></td>
    <style>
		.textarea_1{
			width : 320px ;
			height : 50px ;
			resize: none;
		}
		</style>
    </tr>


    <tr>
    <td>エリア</td>
    <td><div class="pulldownset vegetable">
             <select name="paper" class="mainselect">
                 <option value="">エリア</option>
                 <option value="北海道地方">北海道地方</option>
                 <option value="東北地方">東北地方</option>
                 <option value="関東地方">関東地方</option>
                 <option value="中部地方">中部地方</option>
                 <option value="近畿地方">近畿地方</option>
                 <option value="中国地方">中国地方</option>
                 <option value="四国地方">四国地方</option>
                 <option value="九州地方">九州地方</option>
</select>
    </td>
    </tr>

    <tr>
    <td> 学籍番号</td>
    <td><label><%=sb.getId()%></label></td>
    </tr>

    <tr>
    <td>氏名</td>
    <td><label><input type = "text" name="name" class="textfield validate" value="<%=sb.getName()%>"readonly="readonly" /></label></td>
    </tr>
    <tr>
    <td>学科・コース</td>
    <td><div class="pulldownset vegetable">
			<select name="department"class="mainselect vegetable"  required>
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

			<select id="情報システム科" class="subbox vegetable" name="course">
				<option value="システムエンジニアコース">システムエンジニアコース</option>
				<option value="スマートフォンアプリ開発コース">スマートフォンアプリ開発コース</option>
			</select>

			<select id="ネットワークセキュリティ科" class="subbox vegetable" name="course">
				<option value="ネットワークエンジニアコース">ネットワークエンジニアコース</option>
				<option value="情報セキュリティコース">情報セキュリティコース</option>
			</select>

			<select id="総合システム工学科" class="subbox vegetable" name="course">
				<option value="WEBプログラマーコース">WEBプログラマーコース</option>
				<option value="組込みシステムコース">組込みシステムコース</option>
				<option value="ゲームプログラマコース">ゲームプログラマコース</option>
			</select>
			<select id="高度情報工学科" class="subbox vegetable" name="course">
				<option value="高度情報工学科">高度情報工学科</option>
			</select>
			<select id="情報ビジネス科" class="subbox vegetable" name="course">
				<option value="情報ビジネスコース">情報ビジネスコース</option>
				<option value="公共ビジネスコース">公共ビジネスコース</option>
			</select>
			<select id="会計ビジネス科" class="subbox vegetable" name="course">
				<option value="会計ビジネスコース">会計ビジネスコース</option>
				<option value="会計エキスパートコース">会計エキスパートコース</option>
			</select>
			<select id="デザイン科" class="subbox vegetable" name="course">
				<option value="グラフィックデザインコース">グラフィックデザインコース</option>
				<option value="CGクリエイトコース">CGクリエイトコース</option>
				<option value="アニメ・マンガコース">アニメ・マンガコース</option>
				<option value="建築インテリアコース">建築インテリアコース</option>
			</select>
			<select id="総合デザイン科" class="subbox vegetable" name="course">
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

   <style>
		.text {
			width : 250px ;
		}
		</style>
		</td>
    </tr>
	<td>業種</td>
    <td><select name="industry" class="mainselect2 vegetable" required>
<option value="">業種</option>
<option value="メーカー">メーカー</option>
<option value="商社">商社</option>
<option value="流通・小売">流通・小売</option>
<option value="金融">金融</option>
<option value="サービス・インフラ">サービス・インフラ</option>
<option value="ソフトウェア・通信">ソフトウェア・通信</option>
<option value="広告・出版・マスコミ">広告・出版・マスコミ</option>
<option value="官公庁・公社・団体">官公庁・公社・団体</option>
</select></td>
		<style>
			.mainselect2{
				width: 245px;
			}
		</style>


    <tr>
    <td>職種</td>
    <td><select name="occupations" class="mainselect1 vegetable" required>
<option value="">職種</option>
<option value="営業・事務・企画系">営業・事務・企画系</option>
<option value="サービス・販売系">サービス・販売系</option>
<option value="コンサルタント・金融・不動産">専門職系(コンサルタント・金融・不動産)</option>
<option value="ソフトウェア・ネットワーク">技術系(ソフトウェア・ネットワーク)</option>
<option value="電気・電子・機械">技術系(電気・電子・機械)</option>
<option value="素材・食品・メディカル">技術系(素材・食品・メディカル)</option>
<option value="建築・土木">技術系(建築・土木)</option>
<option value="クリエイティブ系">クリエイティブ系</option>
<option value="その他">その他(教師・公務員など)</option>
</select></td>
    </tr>
    <tr>

  	</tr>
  	<tr>
  	<td>1次<br>試験<br>報告</td>

   	<td><textarea name = "coment1"  class = "textarea_2 validate" placeholder="ここに入力して下さい" size=200 style="font-size:24px;" required maxlength="500"></textarea></td>
   	</tr>
   	 <style>
		.textarea_2{
			width : 700px ;
			height : 790px ;
			resize: none;
		}
		</style>
  	<tr>
  	<td>2次<br>試験<br>報告</td>

   	<td><textarea name = "coment2"  class = "textarea_2 validate" placeholder="ここに入力して下さい" value="" size=200 maxlength="500" style="font-size:24px;"></textarea></td>
   	</tr>
  	<tr>
  	<td><div class="textfield_3">3次<br>試験<br>報告</div></td>

   	<td><textarea name = "coment3"  class = "textarea_2 validate" placeholder="ここに入力して下さい" value="" size=200 maxlength="500" style="font-size:24px;"></textarea></td>
     </tr>
	   </table></div>
	   <style>
		   .table_1{
			   position : absolute ;
			   top : 170px;
			   left : 110px ;
			   border-collapse: collapse;
			   width : 500px ;
		   }
		   table td {
			width:500px;

			border: 1px solid black;
			text-align: center;

			   background-color:white;

			}
	</style>


	<p><button class="button1"  type="submit" value="registration" name="pagename">登録</button>
    <style>
		button.button1{
    background-color:#FF8300 ;
    float: right;
	width: 180;
	height: 40;
    cursor:pointer;
	color:#fff;
	font-size: 23px;
	font-weight:bold;
	padding:10px 50px;
    position: absolute;
	top: 3000px;
	left: 400px;
	}


    </style>
	</p>
</form>

<form action="./Report_Servlet" method="post">
    <p><button class="button2" type="submit" value="back" name="pagename">戻る</button></p>
    <style>
	button.button2{
	background-color:#FF8300;
	width: 150px;
	height: 50px;
	cursor:pointer;
	color:#fff;
	font-size: 23px;
	font-weight: bold;
	padding: 0px 50px;
	position: absolute;
	top:3000px;
	left:10px;
   }
   </style>
</form>



</body>
</html>
