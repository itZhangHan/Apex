<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript"
	src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js">
	wx.checkJsApi({
		jsApiList : [ 'chooseImage' ], // 需要检测的JS接口列表，所有JS接口列表见附录2,
		success : function(res) {
			// 以键值对的形式返回，可用的api值true，不可用为false
			// 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
		}
	});

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
</script>
</html>