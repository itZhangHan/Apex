/**
 * Created by dell on 2017/10/24.
 */

var websocket = new WebSocket("ws://thdd.apexgame.cn/tetris/websocket1");
websocket.onOpen = function() {
	alert("打开连接");
	socketStatus = true;
	clearInterval(t1);// 去掉定时器
	t2 = setInterval(tanchuang, 3000);
}

websocket.onClose = function() {
	socketStatus=false;
}

this.websocket = websocket;
