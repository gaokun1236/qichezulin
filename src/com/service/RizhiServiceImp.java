package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.RizhiDao;
import com.model.PageBean;
import com.model.Rizhi;

public class RizhiServiceImp implements RizhiService {
	private RizhiDao rizhiDao;
	
	private PageBean pageBean;
	
	public RizhiDao getRizhiDao() {  
        return rizhiDao;  
    }  
  
    public void setRizhiDao(RizhiDao rizhiDao) {  
        this.rizhiDao= rizhiDao;  
    }
	
	
	@Override
	public List<Rizhi> queryRizhis(Rizhi rizhi,PageBean pageBean){
		return rizhiDao.query(rizhi,pageBean);
	}
	
	@Override
	 public Rizhi getRizhi(Integer id){
			return rizhiDao.getRizhi(id);
	}
	
	@Override
	@Transactional
	public void save(Rizhi rizhi){
		rizhiDao.save(rizhi);
	}
	
	@Override
	@Transactional
	public void modifyRizhi(Rizhi rizhi){
		rizhiDao.update(rizhi);
	}
	
	@Override
	@Transactional
	public void deleteRizhi(Integer id){
		rizhiDao.delete(id);
	}
}
