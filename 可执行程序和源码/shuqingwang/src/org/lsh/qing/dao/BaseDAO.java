package org.lsh.qing.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport{
	@Resource(name="mysessionFactory")
	public void setMySessionFactory(SessionFactory sf){
		super.setSessionFactory(sf);
	}
}
