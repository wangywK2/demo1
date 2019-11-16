package com.tydic.api.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.tydic.api.dao.master.DKMapper;
import com.tydic.api.service.DkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api("数据可视化接口")
public class DkContro extends BaseContro{
	@Autowired
	@Qualifier("dkService")
	private DkService dk;
	@Autowired
	@Qualifier("dkMpeer")
	private DKMapper dm;
	


	
	@GetMapping("/dutyDeploy/{sj}/{lx}")
	@ApiOperation(value = "接口文档标题",notes = "接口文档描述"
			+ "<br>	   返回结果： {\"code\": \"200\",\"data\": [{\"lx\": \"类型\",\"gpsx\": \"GPS-X坐标值\",\"gpsy\": \"GPS-Y坐标值\"}]} or {\"code\":\"500或者202\",\"error\":\"异常信息\"}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "sj",value = "*时间精确到分，时间格式为 HH24MI ，如12：42则输入12:42",paramType = "path",dataType = "String",required = true),
		@ApiImplicitParam(name = "lx",value = "*分为日常、双休、节日",paramType = "path",dataType = "String",required = true)
	})
	public JSONObject dutyDeploy(@PathVariable("sj") String sj,@PathVariable("lx") String lx) {
		if(StringUtils.isBlank(sj) || StringUtils.isBlank(lx)) {
			return this.unsuccess("缺失参数");
		}
		try {
			return this.success(dk.dutyDeploy(lx,sj));
		} catch (Exception e) {
			return this.error(e.getMessage());
		}
	}
}
