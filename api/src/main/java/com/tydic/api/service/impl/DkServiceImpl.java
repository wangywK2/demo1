package com.tydic.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tydic.api.dao.master.DKMapper;
import com.tydic.api.service.DkService;
@Service("dkService")
public class DkServiceImpl implements DkService {

	@Autowired
	@Qualifier("dkMpeer")
	private DKMapper dk;
	
	@Override
	public List jurisdiction() throws Exception {
		return dk.jurisdiction();
	}

	@Override
	public List information() throws Exception {
		return dk.information();
	}

	@Override
	public List deploy() throws Exception {
		return dk.deploy();
	}

	@Override
	public List policeForce() throws Exception {
		return dk.policeForce();
	}

	@Override
	public List dutyDeploy(String lx,String sj) throws Exception {
		return dk.dutyDeploy(lx,sj);
	}

	@Override
	public Map<String,Object> keyAreaDetail(String name) throws Exception {
		return dk.keyAreaDetail(name);
	}

	@Override
	public Map<String, Object> policeInfo(String jybh) throws Exception {
		return dk.policeInfo(jybh);
	}

	@Override
	public Map<String, Object> annualLabour(String jybh) throws Exception {
		return dk.annualLabour(jybh);
	}

	@Override
	public List<Map<String, Object>> meritAwards(String jybh) throws Exception {
		return dk.meritAwards(jybh);
	}

	@Override
	public List<Map<String, Object>> congJingResume(String jybh) throws Exception {
		return dk.congJingResume(jybh);
	}

	@Override
	public List<Map<String, Object>> assessment(String jybh) throws Exception {
		return dk.assessment(jybh);
	}

	@Override
	public List<Map<String, Object>> lawVolume(String jybh) throws Exception {
		return dk.lawVolume(jybh);
	}

	@Override
	public List<Map<String, Object>> performanceRank(String jybh) throws Exception {
		return dk.performanceRank(jybh);
	}

	@Override
	public List<Map<String, Object>> activePolice(String jybh) throws Exception {
		return dk.activePolice(jybh);
	}

	@Override
	public List<Map<String, Object>> policePluripotent(String jybh) throws Exception {
		return dk.policePluripotent(jybh);
	}

	@Override
	public Map<String, Object> servicePerformed(String jybh) throws Exception {
		return dk.servicePerformed(jybh);
	}

	@Override
	public Map<String, Object> ssdwZgRank(String jybh) {
		return dk.ssdwZgRank(jybh);
	}

	@Override
	public Map<String, Object> ssdwQwRank(String jybh) {
		return dk.ssdwQwRank(jybh);
	}
	
	
}
