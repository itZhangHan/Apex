<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信分享</title>
</head>
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
<input type="button" id="share" onclick="share()" value="分享链接" />
</body>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js">
$("#share").ready(function () {
    //通过ajax，在页面加载的时候获取微信分享接口signature，nonceStr，timestamp 和appId
    $.ajax({
        type: "post",
        url: "/weixin/share",
        dataType: "json",
        data:"url="+window.location.href,
        success: function (data) {
            wx.config({
                debug: false,
                appId: data.appId,
                timestamp: data.timestamp,
                nonceStr: data.nonceStr,
                signature: data.signature,
                jsApiList: ['onMenuShareAppMessage', 'onMenuShareTimeline', 'hideAllNonBaseMenuItem', 'showMenuItems']
                // 功能列表，我们要使用JS-SDK的什么功能
            });
            wx.ready(function () {
                // 获取“分享给朋友”按钮点击状态及自定义分享内容接口
                wx.onMenuShareAppMessage({
                    title: "俄罗斯方块", // 分享标题
                    desc: "块邀请你的小伙伴一起来玩吧！", // 分享描述
                    link: "http://localhost/weixin/share?openId=1",//分享点击之后的链接
                    imgUrl:'/images/photo/1.jpg', // 分享图标
                    type: 'link', // 分享类型,music、video或link，不填默认为link
                    success: function () {
                        //成功之后的回调
                        alert("分享成功");
                    }
                });
                wx.hideAllNonBaseMenuItem();
                wx.showMenuItems({
                    menuList: ['menuItem:share:appMessage', 'menuItem:share:timeline'] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
                });
                wx.onMenuShareTimeline({
                    title: "分享自定义标题", // 分享标题
                    desc: "分享自定义描述", // 分享描述
                    link: "http://localhost/weixin/share?openId=1",//分享点击之后的链接
                    imgUrl:'/images/photo/1.jpg', // 分享图标
                    type: 'link', // 分享类型,music、video或link，不填默认为link
                    success: function () {
                        //成功之后的回调
                    }
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });
            });
            wx.error(function (res) {
                //打印错误消息。及把 debug:false,设置为debug:ture就可以直接在网页上看到弹出的错误提示
            });
        }
    })
});
</script>

</html>