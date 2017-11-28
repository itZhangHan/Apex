
// 微信信息的以及调用的配置
wx.config({
    debug: false, 
    appId: '${appId}', //你的APPID
    timestamp: '${timestamp}', //上一步生成的时间戳
    nonceStr: '${nonceStr}', //上一步的字符串
    signature: '${signature}',//上一步生成的签名
    jsApiList: ['onMenuShareTimeline', 'onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','onMenuShareQZone'] 
});//功能列表，我们要使用JS-SDK的什么功能
wx.ready(function(){
    // 获取“分享到朋友圈”按钮点击状态及自定义分享内容接口
    wx.onMenuShareTimeline({
        title: '俄罗斯play', // 分享标题
        link:"http://thdd.apexgame.cn/tetris/skip/first.html",
        imgUrl: "http://thdd.apexgame.cn/tetris/src/main/webapp/img/icon4.png" // 分享图标
    });
    // 获取“分享给朋友”按钮点击状态及自定义分享内容接口
    wx.onMenuShareAppMessage({
        title: '俄罗斯play', // 分享标题
        desc: "欢乐大家族go", // 分享描述
        link:"http://thdd.apexgame.cn/tetris/skip/first.html",
        imgUrl: "http://thdd.apexgame.cn/tetris/src/main/webapp/img/icon4.png", // 分享图标
        type: 'link', // 分享类型,music、video或link，不填默认为link
    });
    
    //获取“分享到QQ”按钮点击状态及自定义分享内容接口
    wx.onMenuShareQQ({
        title: '俄罗斯play', // 分享标题
        desc: '欢乐大家族go', // 分享描述
        link: 'http://thdd.apexgame.cn/tetris/skip/first.html', // 分享链接
        imgUrl: "http://thdd.apexgame.cn/tetris/src/main/webapp/img/icon4.png", // 分享图标
        success: function () { 
           // 用户确认分享后执行的回调函数
        },
        cancel: function () { 
           // 用户取消分享后执行的回调函数
        }
    });
    
    //获取“分享到腾讯微博”按钮点击状态及自定义分享内容接口
    wx.onMenuShareWeibo({
        title: '俄罗斯play', // 分享标题
        desc: '欢乐大家族go', // 分享描述
        link: 'http://thdd.apexgame.cn/tetris/skip/first.html', // 分享链接
        imgUrl: "http://thdd.apexgame.cn/tetris/src/main/webapp/img/icon4.png", // 分享图标
        success: function () { 
           // 用户确认分享后执行的回调函数
        },
        cancel: function () { 
            // 用户取消分享后执行的回调函数
        }
    });
    
    //获取“分享到QQ空间”按钮点击状态及自定义分享内容接口
    wx.onMenuShareQZone({
        title: '俄罗斯play', // 分享标题
        desc: '欢乐大家族go', // 分享描述
        link: 'http://thdd.apexgame.cn/tetris/skip/first.html', // 分享链接
        imgUrl: "http://thdd.apexgame.cn/tetris/src/main/webapp/img/icon4.png", // 分享图标
        success: function () { 
           // 用户确认分享后执行的回调函数
        },
        cancel: function () { 
            // 用户取消分享后执行的回调函数
        }
    });
    
});