<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプルな自作PC見繕いサイト</title>
<link rel="stylesheet" href="ListSetResult.css">
</head>
<body>
<div>

<header>
<h1>シンプルな自作PC見繕いサイト</h1>
<h6>supported by Daigo Hashimoto</h6>
</header>

<h2>検索結果</h2>
<p>選択したモデル(${rankName})のおすすめパーツです！</p>


<table id = "table" border="1" cellpadding="5" cellspacing="0" >

 <tr bgcolor="#FF6633">
<td>カテゴリー</td>
<td>名称</td>
<td>消費電力</td>
<td>価格コムへのリンク</td>
</tr>

<c:forEach var="pc" items="${pcList}">

<tr bgcolor="#bdb76b">
<td>${pc.pcClass}</td><td>${pc.modelNo}</td><td>${pc.electric}</td><td><a href ="${pc.url}" target = "_blank"><center>このパーツの詳細はコチラ！</center></a></td>
</tr>

</c:forEach>
</table>

<br>そしてこの電力(${sum})に合う電源のおすすめ！！<br>
<div id="side"></div>

<table id = "elctable" border="1" cellpadding="5" cellspacing="0" >

 <tr bgcolor="#FF6633">
<td>名称</td>
<td>電源の容量</td>
<td>価格コムへのリンク</td>
</tr>
<c:forEach var="electric" items="${elcList}">

<tr bgcolor="#bdb76b">
<td>${electric.elcModelNo}</td><td>${electric.capacity}</td><td><a href ="${electric.url}" target = "_blank"><center>電源の詳細はコチラ！</center></a></td>
</tr>
</c:forEach>
</table>


<br><a href="http://localhost:8080/ZisakuPC/TopPageServlet">トップへ戻る</a>
</div>
</body>
</html>