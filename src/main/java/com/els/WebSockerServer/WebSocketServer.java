package com.els.WebSockerServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.els.common.SocketUsers;
import com.els.socket.GameMessage;
import com.els.socket.MessageDecoder;
import com.els.socket.MessageEncoder;
import com.els.socket.SocketManger;
import com.els.socket.SocketMessage;

@SuppressWarnings("all")
// 该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
@ServerEndpoint(value = "/websocket1", encoders = { MessageEncoder.class }, decoders = { MessageDecoder.class })
public class WebSocketServer {

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	private String roomId;

	private SocketUsers socketUser;
	
	private PositionMessage positionMessage;
	
	private GameMessage gameMessage;

	/**
	 * 连接建立成功调用的方法
	 * 
	 * @param session
	 *            可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(EndpointConfig config, Session session) {		this.session = session;
		addOnlineCount(); // 在线数加1
		
		System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());

	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		SocketManger.delSession(roomId, this);
		subOnlineCount(); // 在线数减1
		System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**x`
	 * 收到客户端消息后调用的方法
	 * 
	 * @param message
	 *            客户端发送过来的消息
	 * @param session
	 *            可选的参数
	 */
	@OnMessage
	public void onMessage(SocketMessage message, Session session) {
		// 用户进来就有的数据
		this.socketUser = message.getSocketUser();
		this.positionMessage = message.getPositionMessage();
		this.gameMessage = message.getGameMessage();
		this.roomId = message.getRoomId();
		SocketManger.addRoom(roomId, this);
		if (message != null) {
			if (MessageManger.getType(message.getType()) != null) {
				MessageManger.getType(message.getType()).onMessage(message);
			}
		}
	}

	public GameMessage getGameMessage() {
		return gameMessage;
	}

	public void setGameMessage(GameMessage gameMessage) {
		this.gameMessage = gameMessage;
	}

	/**
	 * 发生错误时调用
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}

	/**
	 * 
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(SocketMessage message) throws IOException {
		// this.session.getBasicRemote().sendText(message);
		try {
			System.out.println("进入sendMessage方法");

			this.session.getBasicRemote().sendObject(message);
			System.out.println("发送成功");

		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static synchronized int getOnlineCount() {
		return SocketManger.getOnlineCount();
	}

	public static synchronized void addOnlineCount() {
		SocketManger.addOnlineCount();
	}

	public static synchronized void subOnlineCount() {
		SocketManger.subOnlineCount();
	}

	public Session getSession() {
		return session;
	}

	public SocketUsers getSocketUser() {
		return socketUser;
	}

	public void setSocketUser(SocketUsers socketUser) {
		this.socketUser = socketUser;
	}

	public PositionMessage getPositionMessage() {
		return positionMessage;
	}

	public void setPositionMessage(PositionMessage positionMessage) {
		this.positionMessage = positionMessage;
	}

}