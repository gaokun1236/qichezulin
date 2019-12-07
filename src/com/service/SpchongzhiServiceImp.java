package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.SpchongzhiDao;
import com.model.PageBean;
import com.model.Spchongzhi;

public class SpchongzhiServiceImp implements SpchongzhiService {
	private SpchongzhiDao spchongzhiDao;
	
	private PageBean pageBean;
	
	public SpchongzhiDao getSpchongzhiDao() {  
        return spchongzhiDao;  
    }  
  
    public void setSpchongzhiDao(SpchongzhiDao spchongzhiDao) {  
        this.spchongzhiDao= spchongzhiDao;  
    }
	
	
	@Override
	public List<Spchongzhi> querySpchongzhis(Spchongzhi spchongzhi,PageBean pageBean, String sdate, String edate){
		return spchongzhiDao.queryBySpchongzhi(spchongzhi,pageBean,sdate,edate);
	}
	
	@Override
	 public Spchongzhi getSpchongzhi(Integer id){
			return spchongzhiDao.getSpchongzhi(id);
	}
	
	@Override
	@Transactional
	public void save(Spchongzhi spchongzhi){
		spchongzhiDao.save(spchongzhi);
	}
	
	@Override
	@Transactional
	public void modifySpchongzhi(Spchongzhi spchongzhi){
		spchongzhiDao.update(spchongzhi);
	}
	
	@Override
	@Transactional
	public void deleteSpchongzhi(Integer id){
		spchongzhiDao.delete(id);
	}
}
