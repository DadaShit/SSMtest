package com.redis.redisDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.redis.domain.Area;
import com.redis.domain.City;
import com.redis.domain.Province;
import com.redis.domain.Village;
import com.redis.mapper.AddressMapper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * 在redis数据库中查询，如果存在则返回，不存在则先从数据库中查询再存放到redis中，本案例只用了get、set方法
 * 存字符串，因为所有对象都可以转化为json字符串，比较方便，如需设置过期时间，则设置jedis.expire(key, seconds)即可，second单位
 * 秒，-1表示不过期，不设置默认为不过期
 * @author admin
 *
 */
@Repository("addressDao")
public class AddressDao {
	@Autowired
	private JedisPool jedisPool;
	@Autowired
	private AddressMapper addressMapper;
	/**
	 * @return 省列表
	 * @throws Exception
	 */
	public List<Province> getAllProvinces()throws Exception{
		System.out.println("enter DAO:getAllProvinces");
		if (exitKey("getAllProvinces")) {
			String str=get("getAllProvinces");
			List<Province> fromJson = new Gson().fromJson(str, new TypeToken<List<Province>>(){}.getType());
			return fromJson;
		}else {
			System.out.println("redis数据库中不存在该键!重新查询并加入redis数据库");
			List<Province> list=addressMapper.getAllProvinces();
			set("getAllProvinces", list);
			return list;
		}
		
	}
	
	/**
	 * 根据省id获取该省所有信息(一对多，查询其下所有市)
	 * @return
	 * @throws Exception
	 */
	public Province getpProvinceById(Integer pid)throws Exception{
		if (exitKey("getpProvinceById"+pid)) {
			String str=get("getpProvinceById"+pid);
			Province province=new Gson().fromJson(str, Province.class);
			return province;
		}else {
			System.out.println("redis数据库中不存在该键!重新查询并加入redis数据库");
			Province province = addressMapper.getpProvinceById(pid);
			set("getpProvinceById"+pid, province);
			return province;
		}
	}
	/**
	 * 通过市id查询该市的所有信息
	 * @return
	 * @throws Exception
	 */
	public City getCityById(Integer cid)throws Exception{
		if (exitKey("getCityById"+cid)) {
			String str=get("getCityById"+cid);
			City city=new Gson().fromJson(str, City.class);
			return city;
		}else {
			System.out.println("redis数据库中不存在该键!重新查询并加入redis数据库");
			City city = addressMapper.getCityById(cid);
			set("getCityById"+cid, city);	
			return city;
		}
	}
	/**
	 * 通过区id获取该区的信息(包括其下所有小区)
	 * @return
	 * @throws Exception
	 */
	public Area getaAreaById(Integer aid)throws Exception{
		if (exitKey("getaAreaById"+aid)) {
			String str=get("getaAreaById"+aid);
			Area area=new Gson().fromJson(str, Area.class);
			return area;
		}else {
			System.out.println("redis数据库中不存在该键!重新查询并加入redis数据库");
			Area area=addressMapper.getaAreaById(aid);
			set("getaAreaById"+aid, area);
			return area;
		}
	}
	/**
	 * 根据具体小区id获取该小区的具体信息(一对一)
	 * @return
	 * @throws Exception
	 */
	public Village getVillageById( Integer vid)throws Exception{
		if (exitKey("getVillageById"+vid)) {
			String str=get("getVillageById"+vid);
			Village village=new Gson().fromJson(str, Village.class);
			return village;
		}else {
			System.out.println("redis数据库中不存在该键!重新查询并加入redis数据库");
			Village village=addressMapper.getVillageById(vid);
			set("getVillageById"+vid, village);
			return village;
		}
	}
	
	
	
	
	
	/**
	 * 存值
	 * @param key 键
	 * @param value 值
	 */
	private void set(String key,Object value){
		Jedis jedis=jedisPool.getResource();
		jedis.set(key, new Gson().toJson(value));
		jedis.close();
	}
	/**
	 * 判断键是否存在
	 * @param key 键
	 * @return
	 */
	private boolean exitKey(String key){
		System.out.println("enter exitKey");
		Jedis jedis=null;
		try {
			jedis=jedisPool.getResource();
		}finally{
			if (jedis!=null) {
				jedis.close();
			}
		}
		return jedis.exists(key);
	}
	/**
	 * 根据键取值
	 * @param key 键
	 * @return json字符串
	 */
	private  String get(String key)throws Exception{
		Jedis jedis=jedisPool.getResource();
		System.out.println(jedis);
		String string=jedis.get(key);
		jedis.close();
		System.out.println(string);
		return string;
	}
}
