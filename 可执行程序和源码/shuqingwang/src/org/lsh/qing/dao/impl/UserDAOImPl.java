package org.lsh.qing.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.lsh.qing.dao.BaseDAO;
import org.lsh.qing.dao.UserDAO;
import org.lsh.qing.entity.User;
import org.lsh.qing.util.Constant;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImPl extends BaseDAO implements UserDAO {

	public User findByEmail(final String email) throws Exception {
		User user = (User) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from User where email=?");
						query.setString(0, email);
						return query.uniqueResult();

					}
				});
		return user;
	}

	public void modfiyTimeIp(User user) throws Exception {

	}

	public void modfiy_is_email_verify(final User user) throws Exception {
		this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("update from User set isEmailVerify=? where email=?");
				query.setString(0, Constant.YES);
				query.setString(1, user.getEmail());
				return null;

			}
		});

	}

	public void save(User user) throws Exception {
		this.getHibernateTemplate().save(user);
	}

}
