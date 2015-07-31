package org.lsh.qing.action.user;

import javax.annotation.Resource;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.dao.UserDAO;
import org.lsh.qing.entity.User;
import org.lsh.qing.util.Constant;

/*
 * �û�ע��
 */
public class RegisterOKAction extends BaseAction {
	public UserDAO userDAO;

	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * ע��ɹ������isEmailVerify�ֶ�
	 * 
	 * @return
	 */
	public String execute() {
		User user = (User) session.get("user");
		user.setIsEmailVerify(Constant.YES);
		System.out.println("==========");
		session.put("user", user);
		try {
			userDAO.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "verify";
	}
}
