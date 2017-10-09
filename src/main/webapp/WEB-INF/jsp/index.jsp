<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="jquery.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSocket</title>
</head>
<body>
	<h1>test</h1>
	<input id="sendTxt" type="text">
	<button id="sentBtn">发送</button>
	<div id="recv"></div>

	<a href="http://localhost:8080/elsfk/show?uid=1">分享</a>
	
</body>
<script type="text/javascript">

	var websocket = new WebSocket("ws://localhost:8081/login");
	websocket.onopen = function() {
		console.log('websocket open');
		document.getElementById("recv").innerHtml = "Connected";
	}
	websocket.onclose = function() {
		console.log('websocket close');
	}
	websocket.onmessage = function(e) {
		console.log(e.data);
		document.getElementById("recv").innerHtml = e.data;
	}
	document.getElementById("sendBtn").onclick = function() {
		var txt = document.getElementById("sendTxt").value;
		websocket.send(txt);
	};
</script>




<script type="text/javascript">
	$.ajax({
		
	});
	
	function share() {
		var wx;
		//分享朋友圈
		wx.onMenuShareTimeline({
			title : '', // 分享标题
			link : '', // 分享链接
			imgUrl : '', // 分享图标
			success : function() {
				// 用户确认分享后执行的回调函数
			},
			cancel : function() {
				// 用户取消分享后执行的回调函数
			}
		});

		//分享朋友
		wx.onMenuShareAppMessage({
			title : '', // 分享标题
			desc : '', // 分享描述
			link : '', // 分享链接
			imgUrl : '', // 分享图标
			type : '', // 分享类型,music、video或link，不填默认为link
			dataUrl : '', // 如果type是music或video，则要提供数据链接，默认为空
			success : function() {
				// 用户确认分享后执行的回调函数
			},
			cancel : function() {
				// 用户取消分享后执行的回调函数
			}
		});
	}
</script>
</html>