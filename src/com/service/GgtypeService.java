package com.service;
import java.util.List;

import com.model.Ggtype;
import com.model.PageBean;

public interface GgtypeService {
	/**
	 * ����
	 */
	public void save(Ggtype ggtype);
	/**
	 * �޸�
	 */
	public void modifyGgtype(Ggtype ggtype);
	/**
	 * ɾ��
	 */
	public void deleteGgtype(Integer id);
	/**
	 * ��ȡָ��id�û�
	 */
	public Ggtype getGgtype(Integer id);
	/**
	 * ��ȡ�б�
	 */
	public List<Ggtype> queryGgtypes(Ggtype ggtype,PageBean pageBean);
	
}
