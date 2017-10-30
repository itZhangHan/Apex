package com.els.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.els.bean.JhddRooms;
import com.els.bean.JhddSidelines;
import com.els.bean.JhddUsers;

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
		// topName.put("createRoom", "index0send");

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

	public static String getMsg(JhddUsers jhddUser, String topName, JhddSidelines sidelines, JhddRooms roomsInfo) {
		System.out.println("getMsg");

		// 给前端传递数据 玩家id 姓名 城市 头像 性别 openid 房间id 房间名字 房间状态 玩家状态
		Integer userid = 0;
		String nickname = "";
		String city = "";
		String headimgurl = "";
		Integer sex = 0;
		String openid = "";
		Integer roomid = 0;
		Byte userStatus = 0;
		String roomName = "";
		Byte roomState = 0;
		try {
			openid = new String(new String(jhddUser.getOpenid()).getBytes("UTF-8"), "ISO8859-1");
			nickname = new String(new String(jhddUser.getUsername()).getBytes("UTF-8"), "ISO8859-1");
			city = new String(new String(jhddUser.getCity()).getBytes("UTF-8"), "ISO8859-1");
			headimgurl = new String(new String(jhddUser.getUserportrait()).getBytes("UTF-8"), "ISO8859-1");
			roomName = new String(new String(roomsInfo.getRoomname()).getBytes("UTF-8"), "ISO8859-1");
			sex = jhddUser.getUsersex();
			userid = jhddUser.getUserid();
			roomid = sidelines.getRoomid();
			// 0未开始 1：游戏中 2:游戏结束
			roomState = roomsInfo.getRoomstate();
			// 0房主 1：玩家 2:旁观者
			userStatus = sidelines.getSidelinestate();
			System.out.println("roomId*******************:" + roomid);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取请求路径
		String topStr = getTopName(topName);
		String urlName = "?nickname=" + nickname + "&sex=" + sex + "&headimgurl=" + headimgurl + "&city=" + city
				+ "&openid=" + openid + "&userid=" + userid + "&roomId=" + roomid + "&userStatus=" + userStatus
				+ "&roomName=" + roomName + "&roomState=" + roomState;
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
