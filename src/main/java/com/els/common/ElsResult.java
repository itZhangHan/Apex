package com.els.common;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ElsResult {

	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	// 响应业务状态 0失败 1成功
	private Integer status;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;
	
	// 房间状态
	private Object roomStatus;

	public static final int SUCCESS = 1;
	public static final int ERROR = 0;
	public Object getRoomStatus() {
		return roomStatus;
	}
	
	public void setRoomStatus(Object roomStatus) {
		this.roomStatus = roomStatus;
	}

	public static ElsResult build(Integer status, String msg, Object data ,Object roomStatus) {
		return new ElsResult(status, msg, data ,roomStatus);
	}

	public static ElsResult ok(Object data ) {
		return new ElsResult(data);
	}

	public static ElsResult ok() {
		return new ElsResult(null);
	}

	public ElsResult() {

	}

	public static ElsResult build(Integer status, String msg) {
		return new ElsResult(status, msg, null);
	}

	public ElsResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

 

	public ElsResult(Integer status, String msg, Object data, Object roomStatus) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
		this.roomStatus = roomStatus;
	}

	public ElsResult(Object object) {
		// TODO Auto-generated constructor stub
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 将json结果集转化为UserResult对象
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            UserResult中的object类型
	 * @return
	 */
	public static ElsResult formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, ElsResult.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj, obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static ElsResult format(String json) {
		try {
			return MAPPER.readValue(json, ElsResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            集合中的类型
	 * @return
	 */
	public static ElsResult formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj, obj);
		} catch (Exception e) {
			return null;
		}
	}
}
