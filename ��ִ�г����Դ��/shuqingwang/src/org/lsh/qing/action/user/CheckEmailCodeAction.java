package org.lsh.qing.action.user;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.dao.UserDAO;
import org.lsh.qing.entity.User;

/*
 * 注册成功后对邮箱进行验证 如果客户端获取的邮箱验证码
 * 跟数据库中的验证码相等则验证成功，否则提示验证码错误。
 */
public class CheckEmailCodeAction extends BaseAction {
	private String validateCode;
	private boolean ok = false;
	private User user;
	public UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String execute() throws Exception {
		// 从数据库获取邮箱验证码
		user = (User) session.get("user");
		String code = user.getEmailVerifyCode();
		// 比较验证码
		if (code.equals(validateCode)) {
			userDAO.modfiy_is_email_verify(user);
			ok = true;
		}

		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
