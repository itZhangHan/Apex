package com.els.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.els.bean.JhddUsers;
import com.els.bean.RoomInfo;

import net.sf.json.JSONObject;;

public class AuthUtil {

	public static final String APPID = "wx90b984cfe6134b69";
	public static final String APPSECRET = "e5b80c04a9d82905091235ad1e3928b1";
	public static final Map<String, String> topName = new HashMap();

	static {
		topName.put("first", "firstsend");
		topName.put("index0", "index0send");
		topName.put("index", "indexsend");
		topName.put("over", "oversend");
		topName.put("joinRoom", "joinRoomSend");

	}

	/**
	 * send http request and convert resposne into json object
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static JSONObject doGetJson(String url) throws IOException {
		System.out.println("1");
		JSONObject jsonObject = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			System.out.println("2");
			String result = EntityUtils.toString(entity, "UTF-8");
			System.out.println(result);
			jsonObject = JSONObject.fromObject(result);
			System.out.println("3");
		}
		System.out.println("4");
		return jsonObject;
	}

	// 获取token
	public static JSONObject getAccess_token() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + AuthUtil.APPID
				+ "&secret=" + AuthUtil.APPSECRET;
		JSONObject jsonObject = null;
		try {
			jsonObject = AuthUtil.doGetJson(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String access_token = jsonObject.getString("access_token");
		jsonObject = JSONObject.fromObject(access_token);
		return jsonObject;
	}

	// 获取jsapi_ticket
	public static JSONObject getJsapi_ticket() throws ParseException, IOException {
		String jsapi_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
				+ AuthUtil.getAccess_token() + "&type=jsapi";
		JSONObject jsonObject = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(jsapi_url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String result = "";
		if (entity != null) {
			result = EntityUtils.toString(entity, "UTF-8");
			System.out.println(result+"————————————————————————————接收jsapi");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}
	public Map<String, String> makeWXTicket(String jsApiTicket, String url) {
	    Map<String, String> ret = new HashMap<String, String>();
	    String nonceStr = createNonceStr();
	    String timestamp = createTimestamp();
	    String string1;
	    String signature = "";

	    //注意这里参数名必须全部小写，且必须有序
	    string1 = "jsapi_ticket=" + jsApiTicket +
	            "&noncestr=" + nonceStr +
	            "&timestamp=" + timestamp +
	            "&url=" + url;
	     
	    try
	    {
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(string1.getBytes("UTF-8"));
	        signature = byteToHex(crypt.digest());
	        
	    }
	    catch (NoSuchAlgorithmException e)
	    {
	         
	    }
	    catch (UnsupportedEncodingException e)
	    {
	        
	    }

	    ret.put("url", url);
	    ret.put("jsapi_ticket", jsApiTicket);
	    ret.put("nonceStr", nonceStr);
	    ret.put("timestamp", timestamp);
	    ret.put("signature", signature);
	    ret.put("appid", AuthUtil.APPID);

	    return ret;
	}
	//字节数组转换为十六进制字符串
	private static String byteToHex(final byte[] hash) {
	    Formatter formatter = new Formatter();
	    for (byte b : hash)
	    {
	        formatter.format("%02x", b);
	    }
	    String result = formatter.toString();
	    formatter.close();
	    return result;
	}
	//生成随机字符串
	private static String createNonceStr() {
	    return UUID.randomUUID().toString();
	}
	//生成时间戳
	private static String createTimestamp() {
	    return Long.toString(System.currentTimeMillis() / 1000);
	}

	/*
	 * 1.获取用户的信息 玩家id 姓名 城市 头像 性别 2.创建房间 房间id 房间名字 房间状态(0没开始 1开始 2结束) 玩家状态(房主状态)
	 * 用户信息 3.发送加入房间链接:参数(roomid)
	 * 
	 * 
	 * 1.(游戏未开始状态)返回参数(List<Users>,房间id 房间名字 房间状态(0没开始 1开始 2结束)) 2.(type =
	 * 'Score')(游戏开始 中状态)返回参数(List<wanjias>),玩家实时分数,道具,旁观者
	 * 
	 * 
	 */
	// 用户信息 访问路径 房间信息
	public static String getMsg(JhddUsers jhddUser, String topName, RoomInfo roomsInfo, List<SocketUsers> list) {
		System.out.println("getMsg");

		// 给前端传递数据 玩家id 姓名 城市 头像 性别 openid 房间id 房间名字 房间状态 玩家状态
		Integer userid = 0;
		String nickname = "";
		String city = "";
		String headimgurl = "";
		Integer sex = 0;
		String openid = "";
		Integer roomid = null;
		Integer userStatus = 0;
		Integer roomState = 0;
		List<SocketUsers> socketUsers = list;
		JhddUsers user = null;
		try {
			openid = new String(new String(jhddUser.getOpenid()).getBytes("UTF-8"), "ISO8859-1");
			nickname = new String(new String(jhddUser.getUsername()).getBytes("UTF-8"), "ISO8859-1");
			city = new String(new String(jhddUser.getCity()).getBytes("UTF-8"), "ISO8859-1");
			headimgurl = new String(new String(jhddUser.getUserportrait()).getBytes("UTF-8"), "ISO8859-1");
			sex = jhddUser.getUsersex();
			userid = jhddUser.getUserid();
			roomid = roomsInfo.getRoomid();
			// 0未开始 1：游戏中 2:游戏结束
			roomState = roomsInfo.getRoomStatus();
			// 0房主 1：玩家 2:旁观者
			userStatus = roomsInfo.getUserStatus();
			user = jhddUser;
			// 房间所有玩家信息
			// users = roomsInfo.getUserList();
			// System.out.println("roomId*******************:" + roomid);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取请求路径
		String topStr = getTopName(topName);
		String urlName = "?nickname=" + nickname + "&sex=" + sex + "&headimgurl=" + headimgurl + "&city=" + city
				+ "&openid=" + openid + "&userid=" + userid + "&roomId=" + roomid + "&userStatus=" + userStatus
				+ "&roomState=" + roomState + "&user=" + user + "&list=" + socketUsers;
		if (topStr != null && !"".equals(topStr)) {
			System.out.println(topStr + urlName);
			return "redirect:/skip/" + topStr + urlName;

		}
		//
		return "first";

	}

	// 解析请求路径
	public static String getTopName(String topName) {
		if (topName != null && !"".equals(topName)) {
			if (topName.contains("/")) {
				System.out.println("进入解析字符串方法");
				String[] split = topName.split("/");
				String topStr = split[split.length - 1];
				if (AuthUtil.topName.get(topStr) != null) {
					return AuthUtil.topName.get(topStr);
				}
			}
			return topName;
		}
		return null;
	}
}
