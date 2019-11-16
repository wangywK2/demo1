package com.tydic.api.service;

import java.util.List;
import java.util.Map;

public interface DkService {
	/**
	 * @ 辖区概况
	 * @return
	 */
	List jurisdiction() throws Exception;
	/**
	 * @ 查询各类情报的分时段统计结果
	 * @return
	 */
	List information() throws Exception;
	

	/**
	 * @ 查询各类部署的分时段统计结果
	 * @return
	 */
	List deploy() throws Exception;
	
	/**
	 * @ 查询警力资源概况，分为四类：路面警力，屯兵所，常设岗位，装备设备
	 * @return
	 */
	List policeForce() throws Exception;
	
	/**
	 * @ 查询各时段的情报态势和勤务岗位信息,情报态势分为：黑点、盲点
	 * @return
	 */
	List dutyDeploy(String lx,String sj) throws Exception;
	/**
	 * @ 查询指定重点区域的详细描述
	 * @return
	 */
	Map<String,Object> keyAreaDetail(String name) throws Exception;
	
	/**
	 * @ 查询警员的基本信息以及在岗信息、装备信息 
	 * @param jybh
	 * @return
	 */
	Map<String,Object> policeInfo(String jybh) throws Exception;
	/**
	 * @ 获取警员该年度每个月政工评分
	 * @param jybh 警员编号
	 * @return
	 */
	Map<String,Object> annualLabour(String jybh) throws Exception;
	/**
	 * @ 获取警员历年的立功奖项
	 * @param jybh 警员编号
	 * @return
	 */
	List<Map<String,Object>> meritAwards(String jybh) throws Exception;
	/**
	 * @ 获取警员的从警履历
	 * @param jybh
	 * @return
	 */
	List<Map<String,Object>> congJingResume(String jybh) throws Exception;
	/**
	 * @ 获取 警员在大队、分局、支队、总队的政工考评排名
	 * @param jybh
	 * @return
	 */
	List<Map<String,Object>> assessment(String jybh) throws Exception;
	/**
	 * @ 获取 警员年度各类执法量，和月度各类执法量
	 * @param jybh
	 * @return
	 */
	List<Map<String,Object>> lawVolume(String jybh) throws Exception;
	/**
	 * @ 获取警员的勤务绩效评分和排名
	 * @param jybh
	 * @return
	 */
	List<Map<String,Object>> performanceRank(String jybh) throws Exception;
	
	/**
	 * @ 获取民警主动发现的一些事件
	 * @param jybh 警员编号
	 * @return
	 */
	List<Map<String,Object>> activePolice(String jybh) throws Exception;
	
	/**
	 * @ 一警多能
	 * @param jybh 警员编号
	 * @return
	 */
	List<Map<String,Object>> policePluripotent(String jybh) throws Exception;
	
	/**
	 * @ 获取警员 年度和月度的执法等记录
	 * @param jybh
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> servicePerformed(String jybh) throws Exception;
	/**
	 * @ 获取警员 所属单位政工排名
	 * @param jybh
	 * @return
	 */
	Map<String,Object> ssdwZgRank(String jybh);
	/**
	 *  @ 获取警员该年度每个月政工评分
	 * @param jybh
	 * @return
	 */
	Map<String,Object> ssdwQwRank(String jybh);
}
