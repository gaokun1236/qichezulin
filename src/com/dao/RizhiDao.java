package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.PageBean;
import com.model.Rizhi;
import com.model.Rizhi;
import com.util.StringUtil;

@Component
public class RizhiDao extends HibernateDaoSupport  {
	public void save(final Rizhi rizhi) {
		getHibernateTemplate().save(rizhi);
	}

	public void update(final Rizhi rizhi) {
		getHibernateTemplate().update(rizhi);
	}

	public void delete(Integer id) {
		Rizhi rizhi = getRizhi(id);
		getHibernateTemplate().delete(rizhi);
	}

	public Rizhi getRizhi(Integer id) {
		return (Rizhi) this.getHibernateTemplate().load(Rizhi.class, id);
	}
	
	public List<Rizhi> query(final Rizhi rizhi, final PageBean pageBean) {
		List rizhiList = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallBack方法必须且唯一要实现的方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// 执行hibernate分页查询
				StringBuffer hql = new StringBuffer("from Rizhi");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Rizhi> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Rizhi> list = query.list();
				session.close();
				return list;
			}

		});

		return rizhiList;
	}

}
