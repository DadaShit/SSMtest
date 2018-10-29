package com.redis.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 城市
 * @author Administrator
 *
 */
public class City implements Serializable{
	private static final long serialVersionUID = 1388977744271045322L;
private Integer cid;
private String cname;
private List<Area> areas;
public List<Area> getAreas() {
	return areas;
}
public void setAreas(List<Area> areas) {
	this.areas = areas;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}

}
