package com.tydic.api.dao.master;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("dkMpeer")
public interface DKMapper {
	/**
	 * @ 辖区概况
	 * @return
	 */
	List<Map<String,Object>> jurisdiction();
	
	/**
	 * @ 查询各类情报的分时段统计结果
	 * @return
	 */
	List<Map<String,Object>> information();
	
	
	/**
	 * @ 查询各类部署的分时段统计结果
	 * @return
	 */
	List<Map<String,Object>> deploy();
	
	/**
	 * @ 查询警力资源概况，分为四类：路面警力，屯兵所，常设岗位，装备设备
	 * @return
	 */
	List<Map<String,Object>> policeForce();
	/***
	 * @ 查询各时段的情报态势和勤务岗位信息
	 * @param lx 类型
	 * @param sj 时间 -> 格式：HH:ss
	 * @return
	 */
	@Select("select id.gwlx lx,dc.gpsx,dc.gpsy from itms_duty id,itms_duty_time dt,itms_duty_coordinate dc where id.uuid = dt.zbzj and id.uuid = dc.zjid" 
			+ " and id.srlx= #{lx} and TIME_FORMAT(#{sj},'%k:%i') BETWEEN TIME_FORMAT(dt.kssj,'%k:%i') and TIME_FORMAT(dt.jssj,'%k:%i') "
			+ " union all select ii.lx,ii.gpsx,ii.gpsy from itms_intelligence ii,itms_intelligence_time it where ii.uuid = it.zjid "
			+ " and ii.lx= #{lx} and TIME_FORMAT(#{sj},'%k:%i') BETWEEN TIME_FORMAT(it.kssj,'%k:%i') and TIME_FORMAT(it.jssj,'%k:%i')")
	List<Map<String,Object>> dutyDeploy(String lx,String sj);
	
	/**
	 * @ 查询指定重点区域的详细描述
	 * @param name 重点区域名称
	 * @return
	 */
	@Select("select remark from ITMS_KEY_AREA where name=#{name}")
	Map<String,Object> keyAreaDetail(String name);
	
	/**
	 * @查询警员的基本信息
	 * @param jybh 警员编号
	 * @return
	 */
	@Select("select xm,jx,ls xq,zgpj,TIMESTAMPDIFF(YEAR, csny, CURDATE()) nl,zgzt,zgr zg,jbr zg_jb,xjr xj,bi.kjlzb kjl,bi.bzlzb bzl,bi.dbzb djl,bi.jdzb cll from itms_basic_information bi where bi.jybh=#{jybh}")
	Map<String,Object> policeInfo(String jybh);
	
	/**
	 * @获取警员该年度每个月政工评分
	 * @param jybh 警员编号
	 * @return
	 */
	@Select("select CONCAT(jan,',',feb,',',mar,',',apr,',',may,',',june,',',july,',',aug,',',sept) rest from itms_political_work where jybh=#{jybh} ")
	Map<String,Object> annualLabour(String jybh);
	
	
	/**
	 * @获取警员历年的立功奖项
	 * @param jybh 警员编号
	 * @return
	 */
	@Select("select ia.jlm,ia.bfdwlx bjdwlx,ia.hjsj,ia.zyd from itms_award ia where ia.jybh=#{jybh}")
	List<Map<String,Object>> meritAwards(String jybh);
	
	/**
	 * @获取警员的从警履历
	 * @param jybh 警员编号
	 * @return
	 */
	@Select(" select DATE_FORMAT(sj,'%Y%m%d') sj,llsj from itms_cv ic where ic.jybh=#{jybh}")
	List<Map<String,Object>> congJingResume(String jybh);
	
	/**
	 * @获取 警员在大队、分局、支队、总队的政工考评排名
	 * @param jybh 警员编号
	 * @return
	 */
	@Select(" select ic.ydpm_dd ddpm,ic.ydpm_fj fjpm,ic.ydpm_zhid zhidpm,ic.ydpm_zongd zongdpm,ic.ydbbzs bbzs from ITMS_CHECK ic where ic.jybh=#{jybh} ")
	List<Map<String,Object>> assessment(String jybh);
	
	/**
	 * @ 获取 警员年度各类执法量，和月度各类执法量
	 * @param jybh
	 * @return
	 */
	@Select(" select '0' lx,es.nd_zfzl zfzl,es.nd_lmjt lmjtl,es.nd_zzfk zafkl,es.nd_zdry zdrygk,es.nd_qt qt from ITMS_EFFICIENCY_SERVICE es where es.jybh=#{jybh} "
		  + " union all select '1' lx,es.yd_zfzl zfzl,es.yd_lmjt lmjtl,es.yd_zzfk zafkl,es.yd_zdry zdrygk,es.yd_qt qt from ITMS_EFFICIENCY_SERVICE es where es.jybh=#{jybh} ")
	List<Map<String,Object>> lawVolume(String jybh);
	
	/**
	 * @ 获取警员的勤务绩效评分和排名
	 * @param jybh 警员编号
	 * @return
	 */
	@Select(" select es.jxpf,es.jxpm from ITMS_EFFICIENCY_SERVICE es where es.jybh=#{jybh} ")
	List<Map<String,Object>> performanceRank(String jybh);
	
	/**
	 * @ 获取民警主动发现的一些事件
	 * @param jybh 警员编号
	 * @return
	 */
	@Select(" select ap.jybh jh,DATE_FORMAT(ap.sj,'%Y%m%d%k%i') sj,ap.fxjqms fsjqms,ap.czfk from itms_active_police ap where ap.jybh=#{jybh} ")
	List<Map<String,Object>> activePolice(String jybh);
	
	/**
	 * @ 一警多能
	 * @param jybh 警员编号
	 * @return
	 */
	@Select(" select pp.jybh jh,DATE_FORMAT(pp.sj,'%Y%m%d%k%i') sj,pp.jqlx,pp.fxjqms fsjqms, pp.czfk from ITMS_POLICE_PLURIPOTENT pp where pp.jybh=#{jybh} ")
	List<Map<String,Object>> policePluripotent(String jybh);
	
	/**
	 * @ 获取警员 年度和月度的执法等记录
	 * @param jybh 警员编号
	 * @return
	 * @throws Exception
	 */
	@Select(" select de.nd_lmzqsc,de.nd_xllc,de.nd_zfl,de.nd_jbasj,de.nd_zdfx,de.nd_yjdn,de.nd_tqrw,de.nd_zxxd,de.yd_qwpj,de.yd_tqrw,de.yd_yjdn,de.yd_zdfx,de.yd_zqpm,de.yd_zxxd from ITMS_DUTY_EXECUTION de where de.jybh=#{jybh}  ")
	Map<String,Object> servicePerformed(String jybh);
	
	/**
	 * @ 获取警员 所属单位政工排名
	 * @param jybh
	 * @return
	 */
	@Select(" select CONCAT(jan,',',feb,',',mar,',',apr,',',may,',',june,',',july,',',aug,',',sept) rest from itms_basic_information bi LEFT JOIN ITMS_ZZDWZG_RANK zr on zr.ssdw = bi.ls where bi.jybh=#{jybh} ")
	Map<String,Object> ssdwZgRank(String jybh);
	
	/**
	 *  @ 获取警员该年度每个月政工评分
	 * @param jybh
	 * @return
	 */
	@Select(" select CONCAT(jan,',',feb,',',mar,',',apr,',',may,',',june,',',july,',',aug,',',sept) rest from itms_basic_information bi LEFT JOIN ITMS_ZZDWQWKH_RANK zr on zr.ssdw = bi.ls where bi.jybh=#{jybh} ")
	Map<String,Object> ssdwQwRank(String jybh);
	
	
	
	
	
	
	
	
	
	
	/**
	 * @查询警员的基本信息
	 * @param jybh 警员编号
	 * @return
	 */
	@Select(" select xm,jx,ls xq,zgpj,TIMESTAMPDIFF(YEAR, csny, CURDATE()) nl,zgzt from itms_basic_information bi where bi.jybh=#{jybh} ")
	Map<String,Object> basicInformation(String jybh);
	
	/**
	 * @警员该年度的考勤情况，分为在岗、休假两种状态
	 * @param jybh 警员编号
	 * @return
	 */
	@Select(" select zgr zg,jbr zg_jb,xjr xj from itms_basic_information bi where bi.jybh=#{jybh} ")
	Map<String,Object> vacation(String jybh);
	
	/**
	 * @ 获取警员装备信息
	 * @param jybh 警员编号
	 * @return
	 */
	@Select("select bi.kjlzb kjl,bi.bzlzb bzl,bi.dbzb djl,bi.jdzb cll from itms_basic_information bi.jybh=#{jybh}")
	Map<String,Object> kits(String jybh);
	
	
	
	@Select("select 21 '21',1 '1' ,25 '25',2 '2',3 '3',4 '4',5 '5',30 '30'")
	Map<String,Object> test_1();
	
	
	
	
	
	
}
