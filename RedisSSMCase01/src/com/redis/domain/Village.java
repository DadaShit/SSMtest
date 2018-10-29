package com.redis.domain;

import java.io.Serializable;

/**
 * 具体的小区
 * @author Administrator
 *
 */
public class Village implements Serializable{
	private static final long serialVersionUID = 5373292422669120360L;
	private Integer vid;
	private String vname;
	private Area area;
	private City city;
	private Province province;
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	
}
