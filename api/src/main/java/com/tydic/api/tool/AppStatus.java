package com.tydic.api.tool;
/**
 * @description  服务系统返回状态码
 * @author SHPolice
 *
 */
public enum AppStatus {
	
	SUCCESS("200","请求成功"),ERROR("200","接口异常"),UNSUCCESS("202","缺失参数");
	
	public final String code;
	public final String desc;
	private AppStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
}
