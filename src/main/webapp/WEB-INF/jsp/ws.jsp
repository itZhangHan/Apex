<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
</head>

<body>
	<script type="text/javascript">
		 
		$("#findId").ready(function() {
			$.ajax({
				type : "get",
				async : false,
				url : "http://192.168.128.1:8080/elsfk/index/getTransfer",
				dataType : "jsonp",
				jsonp: "callback",
				success : function(data) {
					alert("uid:" + data.uid + "hid:" + data.hid);
				}

			});
		});
	var uid = ${param.uid}; console.log(uid); var socket; if
	(!window.WebSocket) { window.WebSocket = window.MozWebSocket; } if
	(window.WebSocket) { socket = new WebSocket("ws://localhost:8081/ws");
	socket.onmessage = function(event) { var ta =
	document.getElementById('responseText'); ta.value = ta.value + '\n' +
	event.data }; socket.onopen = function(event) { var ta =
	document.getElementById('responseText'); ta.value = "连接开启!"; };
	socket.onclose = function(event) { var ta =
	document.getElementById('responseText'); ta.value = ta.value + "连接被关闭";
	}; } else { alert("你的浏览器不支持 WebSocket！"); } function send(message) { if
	(!window.WebSocket) { return; } if (socket.readyState ==
	WebSocket.OPEN) { socket.send(message); } else { alert("连接没有开启."); } }
	</script>



	<form onsubmit="return false;">
		<h3>WebSocket 聊天室：</h3>
		<textarea id="responseText" style="width: 500px; height: 300px;"></textarea>

		<input type="text" name="message" style="width: 300px"
			value="Welcome to www.waylau.com"> <input type="button"
			value="发送消息" onclick="send(this.form.message.value)"> <input
			type="button"
			onclick="javascript:document.getElementById('responseText').value=''"
			value="清空聊天记录">
	</form>


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
</body>

</html>