package com.dao;

import java.util.List;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.PageBean;
import com.model.Spchongzhi;
import com.util.StringUtil;

@Component
public class SpchongzhiDao extends HibernateDaoSupport {

	public void save(final Spchongzhi spchongzhi) {
		getHibernateTemplate().save(spchongzhi);
	}

	public void update(final Spchongzhi spchongzhi) {
		getHibernateTemplate().update(spchongzhi);
	}

	public void delete(final Integer id) {
		Spchongzhi spchongzhi = getSpchongzhi(id);
		getHibernateTemplate().delete(spchongzhi);
	}

	public Spchongzhi getSpchongzhi(final Integer id) {
		return (Spchongzhi) this.getHibernateTemplate().load(Spchongzhi.class, id);
	}

	public List<Spchongzhi> queryBySpchongzhi(final Spchongzhi spchongzhi, final PageBean pageBean, final String sdate, final String edate) {
		List spchongzhiList = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallBack方法必须且唯一要实现的方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// 执行hibernate分页查询
				StringBuffer hql = new StringBuffer("from Spchongzhi where 1=1 ");
				if (spchongzhi != null) {
					if (StringUtil.isNotEmpty(spchongzhi.getSpchongzhiName())) {
						hql.append(" and spchongzhiName like '%" + spchongzhi.getSpchongzhiName() + "%'");
					}
					if (spchongzhi.getSpchongzhiId()!=null) {
						hql.append(" and spchongzhiId = '" + spchongzhi.getSpchongzhiId() + "'");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and spchongzhiDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and spchongzhiDate < '" + edate + "'");
					}
					if (spchongzhi.getSpchongzhiType()!=null) {
						hql.append(" and spchongzhiType = '" + spchongzhi.getSpchongzhiType() + "'");
					}
					if (spchongzhi.getSpchongzhiType1()!=null) {
						hql.append(" and spchongzhiType1 = '" + spchongzhi.getSpchongzhiType1() + "'");
					}
					if (spchongzhi.getSptypeId()!=null) {
						hql.append(" and sptypeId = '" + spchongzhi.getSptypeId() + "'");
					}
					if (spchongzhi.getShangpinId()!=null) {
						hql.append(" and shangpinId = '" + spchongzhi.getShangpinId() + "'");
					}
					if (spchongzhi.getYonghuId()!=null) {
						hql.append(" and yonghuId = '" + spchongzhi.getYonghuId() + "'");
					}
					if (spchongzhi.getYhroleId()!=null) {
						hql.append(" and yhroleId = '" + spchongzhi.getYhroleId() + "'");
					}
					if (spchongzhi.getYhbumenId()!=null) {
						hql.append(" and yhbumenId = '" + spchongzhi.getYhbumenId() + "'");
					}
					if (spchongzhi.getUserId()!=null) {
						hql.append(" and userId = '" + spchongzhi.getUserId() + "'");
					}
					if (spchongzhi.getBumenId()!=null) {
						hql.append(" and bumenId = '" + spchongzhi.getBumenId() + "'");
					}
					if (spchongzhi.getRoleId()!=null) {
						hql.append(" and roleId = '" + spchongzhi.getRoleId() + "'");
					}
				}
				hql.append(" order by spchongzhiId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Spchongzhi> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Spchongzhi> list = query.list();
				session.close();
				return list;
			}

		});

		return spchongzhiList;
	}

}
