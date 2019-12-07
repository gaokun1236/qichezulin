package com.service;
import java.util.List;

import com.model.Spchongzhi;
import com.model.PageBean;

public interface SpchongzhiService {
	public void save(Spchongzhi spchongzhi);
	public void modifySpchongzhi(Spchongzhi spchongzhi);
	public void deleteSpchongzhi(Integer id);
	public Spchongzhi getSpchongzhi(Integer id);
	public List<Spchongzhi> querySpchongzhis(Spchongzhi spchongzhi,PageBean pageBean, String sdate, String edate);
	
}
