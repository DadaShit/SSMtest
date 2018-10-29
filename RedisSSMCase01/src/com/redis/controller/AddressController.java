package com.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redis.domain.Area;
import com.redis.domain.City;
import com.redis.domain.Province;
import com.redis.service.AddressService;


/**
 * 地址控制器：省市联动
 * @author Administrator
 *
 */
@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/getAllProvinces")
	@ResponseBody
	public List<Province> getAllProvince(){
		try {		
			List<Province> allProvinces = addressService.getAllProvinces();
			return allProvinces;
		} catch (Exception e) {
			return null;
		}
	}
	@RequestMapping("/getProvinceById")
	@ResponseBody
	public Province getProvinceById(Integer pid){
		System.out.println(pid);
		try {
			System.out.println(addressService.getpProvinceById(pid).getCities().size());
			return addressService.getpProvinceById(pid);
		} catch (Exception e) {
			return null;
		}
	}
	@RequestMapping("/getCityById")
	@ResponseBody
	public City getCityById(Integer cid){
		try {
			return addressService.getCityById(cid);
		} catch (Exception e) {
			return null;
		}
	}
	@RequestMapping("/getAreaById")
	@ResponseBody
	public Area getAreaById(Integer aid){
		try {
			return addressService.getaAreaById(aid);
		} catch (Exception e) {
			return null;
		}
	}
	
}
