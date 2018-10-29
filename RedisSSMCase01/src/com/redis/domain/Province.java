package com.redis.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 省
 * @author Administrator
 *
 */
public class Province implements Serializable{
	private static final long serialVersionUID = -8471912851181964087L;
	private Integer pid;
	private String pname;
	private List<City> cities;
	private List<Area> areas;
	private List<Village> villages;
	public List<Area> getAreas() {
		return areas;
	}
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	public List<Village> getVillages() {
		return villages;
	}
	public void setVillages(List<Village> villages) {
		this.villages = villages;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
