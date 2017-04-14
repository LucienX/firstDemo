package com.viva.lucien.service;

import java.util.List;

import com.viva.lucien.model.Baidu;

/**
 * 
 * @author qiaoxing
 *
 * 下午4:20:15
 * 业务逻辑接口
 */
public interface BaiduService {
     public Baidu save(Baidu baidu);
     public List<Baidu> savaList(List<Baidu> bl);
}
