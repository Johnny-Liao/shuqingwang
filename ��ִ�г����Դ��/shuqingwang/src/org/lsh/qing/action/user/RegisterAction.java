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
 * 用户注册
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

		// 对密码进行加密
		user.setPassword(EncryptUtil.md5Encrypt(user.getPassword()));

		String EmailVerifyCode = VerifyUtil.createCode();

		// 发送邮件
		try {
			My163Mail.sendMail(user.getEmail(), EmailVerifyCode);
		} catch (MessagingException e1) {
			e1.printStackTrace();
			System.out.println("邮件发送出错！");
		}

		user.setUserIntegral(Constant.NORMAL);
		user.setIsEmailVerify(Constant.NO);

		// 获取邮箱验证码
		user.setEmailVerifyCode(EmailVerifyCode);
		// 获取时间
		user.setLastLoginTime(System.currentTimeMillis());
		// 获取IP地址
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
