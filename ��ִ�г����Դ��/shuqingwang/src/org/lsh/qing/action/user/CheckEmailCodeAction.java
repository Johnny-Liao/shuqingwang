package org.lsh.qing.action.user;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.dao.UserDAO;
import org.lsh.qing.entity.User;

/*
 * ע��ɹ�������������֤ ����ͻ��˻�ȡ��������֤��
 * �����ݿ��е���֤���������֤�ɹ���������ʾ��֤�����
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
		// �����ݿ��ȡ������֤��
		user = (User) session.get("user");
		String code = user.getEmailVerifyCode();
		// �Ƚ���֤��
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
