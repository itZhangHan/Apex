package com.els.common;

import com.google.gson.Gson;

public class JsonUtils {

	/**
	 * 将json转换成bean对象
	 * 
	 * @author fuyzh
	 * @param jsonStr
	 * @return
	 */
	public static Object jsonToBean(String jsonStr, Class<?> cl) {
		Gson gson = new Gson();
		Object obj = null;
		if (gson != null) {
			obj = gson.fromJson(jsonStr, cl);
		}
		return obj;
	}

	/**
	 * 将对象转换成json格式
	 * 
	 * @author fuyzh
	 * @param ts
	 * @return
	 */
	public static String objectToJson(Object ts) {
		Gson gson = new Gson();
		String jsonStr = null;
		if (gson != null) {
			jsonStr = gson.toJson(ts);
		}
		return jsonStr;
	}
}
