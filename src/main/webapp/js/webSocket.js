/**
 * Created by dell on 2017/10/24.
 */



var Socket = function (socketio) {
    var websocket= new WebSocket(socketio);
    websocket.onOpen = function () {
        console.log("websocket open")

    }

    websocket.onClose = function () {
        console.log("websocket close")
    }
    websocket.onmessage = function (e) {
        var jsonObj=eval ("(" + e.data + ")");
        console.log(jsonObj)
        var b =JSON.parse(jsonObj);
        console.log(jsonObj)

    }

    this.websocket = websocket;

}