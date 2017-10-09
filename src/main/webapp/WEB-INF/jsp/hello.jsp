<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>websocket client</title>
</head>
<script type="text/javascript">
	var ws;
	function hello() {
		ws = new WebSocket("ws://localhost:8080/elsfk/hello");

		ws.onopen = function(evn) {
			console.log(evn);
		};
		ws.onmessage = function(evn) {
			console.log(evn.data);
			var dv = document.getElementById("dv");
			dv.innerHTML += evn.data;
		};
		ws.onclose = function() {
			console.log("关闭");
		};

	};
	function subsend() {
		var msg = document.getElementById("msg").value;
		ws.send(msg);
		document.getElementById("msg").value = "";
	}
	function share() {

	}
</script>
<body>
	<!--MOB SHARE END-->
	<div class="-mob-share-ui-bg"></div>
	<script type="-mob-share"
		src="http://f1.webshare.mob.com/code/mob-share.js?appkey=你的appkey"></script>
	<!--MOB SHARE BEGIN-->
	<div class="-mob-share-ui-button -mob-share-open">分享</div>
	<div class="-mob-share-ui" style="display: none">
		<ul class="-mob-share-list">
			<li class="-mob-share-weibo"><p>新浪微博</p></li>
			<li class="-mob-share-qzone"><p>QQ空间</p></li>
			<li class="-mob-share-qq"><p>QQ好友</p></li>
			<li class="-mob-share-douban"><p>豆瓣</p></li>
			<li class="-mob-share-facebook"><p>Facebook</p></li>
			<li class="-mob-share-twitter"><p>Twitter</p></li>
			<li class="-mob-share-weixin"><p>微信</p></li>
		</ul>
		<div class="-mob-share-close">取消</div>
	</div>

	<h2>Hello World!</h2>
	<div id="dv">
		<input type="button" value="连接" onclick="hello()" /> <input
			type="text" id="msg" /> <input type="button" onclick="subsend()"
			value="发送" />
	</div>

</body>

</html>