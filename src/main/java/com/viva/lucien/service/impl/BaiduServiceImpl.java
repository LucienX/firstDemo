package com.viva.lucien.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viva.lucien.dao.BaiduDao;
import com.viva.lucien.model.Baidu;
import com.viva.lucien.service.BaiduService;

/**
 * 
 * @author qiaoxing
 *
 * @time:2017年4月10日 下午4:23:24
 * @Description:用户业务逻辑实现类
 */
@Service("baiduService")
public class BaiduServiceImpl implements BaiduService {

	@Autowired
	private BaiduDao baiduDao;

	@Override
	public Baidu save(Baidu baidu) {
		return baiduDao.saveEntity(baidu);
	}

	@Override
	public List<Baidu> savaList(List<Baidu> bl) {
		// TODO Auto-generated method stub
		baiduDao.save(bl);
		return bl;
	}


	

}
