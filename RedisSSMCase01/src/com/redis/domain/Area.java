package com.redis.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 区
 * @author Administrator
 *
 */
public class Area implements Serializable{
	private static final long serialVersionUID = -814062630136233280L;
	private Integer aid;
	private String aname;
	private List<Village> villages;
	public List<Village> getVillages() {
		return villages;
	}
	public void setVillages(List<Village> villages) {
		this.villages = villages;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
}
