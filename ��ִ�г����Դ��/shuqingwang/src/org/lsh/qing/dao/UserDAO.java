package org.lsh.qing.dao;

import org.lsh.qing.entity.User;

public interface UserDAO {
	public void save(User user) throws Exception;

	public User findByEmail(String email) throws Exception;

	public void modfiy_is_email_verify(User user) throws Exception;

	public void modfiyTimeIp(User user) throws Exception;
}
