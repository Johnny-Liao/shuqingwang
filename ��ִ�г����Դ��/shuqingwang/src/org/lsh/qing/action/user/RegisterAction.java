package org.lsh.qing.action.user;

import javax.mail.MessagingException;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.action.mail.My163Mail;
import org.lsh.qing.dao.UserDAO;
import org.lsh.qing.entity.User;
import org.lsh.qing.util.Constant;
import org.lsh.qing.util.EncryptUtil;
import org.lsh.qing.util.VerifyUtil;

/*
 * �û�ע��
 */
public class RegisterAction extends BaseAction {
	public User user;
	public UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {

		// ��������м���
		user.setPassword(EncryptUtil.md5Encrypt(user.getPassword()));

		String EmailVerifyCode = VerifyUtil.createCode();

		// �����ʼ�
		try {
			My163Mail.sendMail(user.getEmail(), EmailVerifyCode);
		} catch (MessagingException e1) {
			e1.printStackTrace();
			System.out.println("�ʼ����ͳ���");
		}

		user.setUserIntegral(Constant.NORMAL);
		user.setIsEmailVerify(Constant.NO);

		// ��ȡ������֤��
		user.setEmailVerifyCode(EmailVerifyCode);
		// ��ȡʱ��
		user.setLastLoginTime(System.currentTimeMillis());
		// ��ȡIP��ַ
		user.setLastLoginIp(httpReq.getRemoteAddr());
		session.put("user", user);
		try {
			userDAO.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "verify";
	}
}
