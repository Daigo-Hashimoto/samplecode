<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプルな自作PC見繕いサイト</title>
<link rel="stylesheet" href="ListSetResult.css">
</head>

<body>
<div>
<form action="/ZisakuPC/PcSelectServlet" method = "post">


<header>
<h1>シンプルな自作PC見繕いサイト</h1>
<h6>supported by Daigo Hashimoto</h6>
</header>

目的のパソコンを選んでください。<br><br>



<input type = "radio" name = "rank" value = "LOW" checked>ローエンド(価格が安く、エクセルやワードなどが使える程のスペックが必要な方に)<br>
<input type = "radio" name = "rank" value = "MID" >ミドルレンジ(軽量なゲームや、動画、映画鑑賞などをストレスなくしたい方に)<br>
<input type = "radio" name = "rank" value = "HIGH"  >ハイエンド(高負荷な３Dゲームや本格的なイラスト、動画などのソフトを使う方に）<br><br>
<input type = "submit" value = "OK" >

</form>

</div>
</body>

</html>