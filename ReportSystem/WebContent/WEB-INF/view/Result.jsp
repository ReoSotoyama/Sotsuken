<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="bean.SectionBean"%>
<%  List<SectionBean>SBList=(List<SectionBean>)request.getAttribute("list"); %>

<html>
<link href="検索結果.css" rel="stylesheet" type="text/css">
<head>
<title>検索結果</title>
</head>

<body>

<div align="center"><h1>検索結果</h1></div>
<h2 style ="position: absolute; left:80px; top:80px">入力内容</h2>

<div class="box2" align="center">
	<a>検索企業名：<%= request.getAttribute("companyname") %></a>
	<p><a>業種：</a>
	<input readonly type="text" name="textbox" size="15" value="<%= request.getAttribute("industry") %>">
	<a>職種：</a>
	<input readonly type="text" name="name" size="32" value="<%= request.getAttribute("occupation") %>">
	<a>エリア：</a>
	<input readonly type="text" name="name" size="6" value="<%= request.getAttribute("area") %>">
	<a>年度：</a>
	<input readonly type="text" name="name" size="5" value="<%= request.getAttribute("year") %>">
	<a>合否：</a>
	<input readonly type="text" name="name" size="5" value="<%= request.getAttribute("acceptance") %>">
	<br><br></p>
	<p><a>学科：</a>
	<input readonly type="text" name="name" size="21" value="<%= request.getAttribute("Department") %>">
	<a>コース：</a>
	<input readonly type="text" name="name" size="25" value="<%= request.getAttribute("course") %>"></p>
</div>




<table id="sample" align="center">
      <thead>
        <tr>
          <th class="thc1">ヘッダー番号</th>
		  <th class="thc2" colspan="2">氏名</th>
          <th class="thc2" colspan="2">年月日</th>
          <th class="thc3" colspan="2">会社名</th>
        </tr>
      </thead>
      <tbody>
<% for (SectionBean member: SBList) {%>

        <tr>
			<form name="form1" method="post" action="Result_Servlet" value = <%=member.getHeader()%>>
          		<td  class="tdc1" align="center" ><a href="Result_Servlet?header=<%=member.getHeader()%>" target="_blank" rel="nofollow" value = ><%=member.getHeader()%></a></td>
			    <td class="tdc2" align="center"><%=member.getName()%></td>
          		<td class="tdc2" align="center"> <%=member.getYear()%></td>
          		<td class="tdc3" align="center"><%=member.getCompany()%> </td>
			</form>
        </tr>
<%} %>

      </tbody>
    </table>


<style>
.box2 {
    padding: 0.5em 1em;
    margin: 2em;
    font-weight: bold;
    color: #6091d3;/*文字色*/
    background: #FFF;
    border: solid 3px #6091d3;/*線*/
    border-radius: 10px;/*角の丸み*/
}
.box2 p {
    margin: 0;
    padding: 0;
}


table{
  border-collapse: collapse;
  border-spacing: 0;
}
thead{
  width: 100%;
  display: block;
}
tbody{
  width: 100%;
  height: 20em;
  display: block;
  overflow-y: scroll;
}
th{
  background-color: #ccc;
}
th, td {
  height: 1em;
  padding: 2px;
  border: 1px solid #666;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.thc1, .tdc1 {
  min-width: 9em;
  max-width: 9em;
}
.thc2 {
  min-width: calc(11em + 0px);
  max-width: calc(11em + 0px);
}
.thc3 {
  min-width: calc(20em + 17px);
  max-width: calc(20em + 17px);
}
.tdc2 {
  min-width: 11em;
  max-width: 11em;
}
.tdc3 {
  min-width: 20em;
  max-width: 20em;
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
    left: 3%; top: 90%
}
</style>




    <form  action="./Result_Servlet" method="post">
		<div>
			<button class="return" type="submit"  value="return" name="pagename">戻る</button>
		</div>
	</form>
</body>

</html>
