package com.service;
import java.util.List;

import com.model.Rizhi;
import com.model.PageBean;

public interface RizhiService {
	/**
	 * ����
	 */
	public void save(Rizhi rizhi);
	/**
	 * �޸�
	 */
	public void modifyRizhi(Rizhi rizhi);
	/**
	 * ɾ��
	 */
	public void deleteRizhi(Integer id);
	/**
	 * ��ȡָ��id�û�
	 */
	public Rizhi getRizhi(Integer id);
	/**
	 * ��ȡ�б�
	 */
	public List<Rizhi> queryRizhis(Rizhi rizhi,PageBean pageBean);
	
}
