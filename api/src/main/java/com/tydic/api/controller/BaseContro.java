package com.tydic.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.tydic.api.tool.AppStatus;

public abstract class BaseContro {
	
	public JSONObject success(Object data) {
		JSONObject json = new JSONObject();
		json.put("code", AppStatus.SUCCESS.code);
		json.put("data", data);
		return json;
	}
	
	public JSONObject error(Object error) {
		JSONObject json = new JSONObject();
		json.put("code", AppStatus.ERROR.code);
		json.put("error", error);
		return json;
	}
	
	public JSONObject unsuccess(Object error) {
		JSONObject json = new JSONObject();
		json.put("code", AppStatus.UNSUCCESS.code);
		json.put("error", error);
		return json;
	}
}
