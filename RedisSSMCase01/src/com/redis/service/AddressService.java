package com.redis.service;

import java.util.List;

import com.redis.domain.Area;
import com.redis.domain.City;
import com.redis.domain.Province;
import com.redis.domain.Village;

public interface AddressService {
	/**
	 * @return 省列表
	 * @throws Exception
	 */
	public List<Province> getAllProvinces()throws Exception;
	
	/**
	 * 根据省id获取该省所有信息(一对多，查询其下所有市)
	 * @return
	 * @throws Exception
	 */
	public Province getpProvinceById(Integer pid)throws Exception;
	/**
	 * 通过市id查询该市的所有信息
	 * @return
	 * @throws Exception
	 */
	public City getCityById(Integer cid)throws Exception;
	/**
	 * 通过区id获取该区的信息(包括其下所有小区)
	 * @return
	 * @throws Exception
	 */
	public Area getaAreaById(Integer aid)throws Exception;
	/**
	 * 根据具体小区id获取该小区的具体信息(一对一)
	 * @return
	 * @throws Exception
	 */
	public Village getVillageById(Integer vid)throws Exception;
}
