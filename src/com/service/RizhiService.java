package com.service;
import java.util.List;

import com.model.Rizhi;
import com.model.PageBean;

public interface RizhiService {
	/**
	 * 保存
	 */
	public void save(Rizhi rizhi);
	/**
	 * 修改
	 */
	public void modifyRizhi(Rizhi rizhi);
	/**
	 * 删除
	 */
	public void deleteRizhi(Integer id);
	/**
	 * 获取指定id用户
	 */
	public Rizhi getRizhi(Integer id);
	/**
	 * 获取列表
	 */
	public List<Rizhi> queryRizhis(Rizhi rizhi,PageBean pageBean);
	
}
