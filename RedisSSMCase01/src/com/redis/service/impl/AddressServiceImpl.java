package com.redis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.domain.Area;
import com.redis.domain.City;
import com.redis.domain.Province;
import com.redis.domain.Village;
import com.redis.redisDao.AddressDao;
import com.redis.service.AddressService;


@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	public List<Province> getAllProvinces() throws Exception {
		return addressDao.getAllProvinces();
	}

	public Province getpProvinceById(Integer pid) throws Exception {
		return addressDao.getpProvinceById(pid);
	}

	public City getCityById(Integer cid) throws Exception {
		return addressDao.getCityById(cid);
	}

	public Area getaAreaById(Integer aid) throws Exception {
		return addressDao.getaAreaById(aid);
	}

	public Village getVillageById(Integer vid) throws Exception {
		return addressDao.getVillageById(vid);
	}

}
