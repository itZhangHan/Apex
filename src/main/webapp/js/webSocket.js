/**
 * Created by dell on 2017/10/24.
 */

var websocket = new WebSocket("ws://thdd.apexgame.cn/tetris/websocket1");
websocket.onOpen = function() {

}

websocket.onClose = function() {

}

this.websocket = websocket;
function userMessage() {

	var userMessage = {};
	userMessage.type = "usmesage"
	userMessage.roomId = roomId;
	userMessage.toUserName = "";
	userMessage.fromUserName = "";
	userMessage.msgStr = "";
	userMessage.userStatus = userStatus;
	userMessage.roomState = roomState;
	userMessage.position = "1";
	userMessage.headimgurl = img;
	userMessage.nicakname = nicakname;
	userMessage.sex = sex;
	userMessage.city = city;
	userMessage.userId = userId;
	alert(city);
	websocket.send(JSON.stringify(userMessage));
}
