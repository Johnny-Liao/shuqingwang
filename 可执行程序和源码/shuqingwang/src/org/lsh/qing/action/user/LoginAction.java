package org.lsh.qing.action.user;

import java.util.List;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.dao.UserDAO;
import org.lsh.qing.entity.CartItem;
import org.lsh.qing.entity.User;
import org.lsh.qing.service.CartFactory;
import org.lsh.qing.service.CartService;
import org.lsh.qing.util.EncryptUtil;

/*
 * 用户登录
 */
public class LoginAction extends BaseAction {
	private User user;
	private String nameMsg = "";
	public UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getNameMsg() {
		return nameMsg;
	}

	public void setNameMsg(String nameMsg) {
		this.nameMsg = nameMsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		String password = EncryptUtil.md5Encrypt(user.getPassword());
		try {
			user = userDAO.findByEmail(user.getEmail());
			session.put("user", user);
			if (user != null && password.equals(user.getPassword())) {
				if (user.getIsEmailVerify().equals("Y")) { //判断用户是否邮箱验证
					// 获取时间
					user.setLastLoginTime(System.currentTimeMillis());
					// 获取IP地址
					user.setLastLoginIp(httpReq.getRemoteAddr());
					userDAO.save(user);
					CartService cart = CartFactory.getInstance(session);
					List<CartItem> items = cart.getBuyPros();
					if (items.isEmpty()) {
						nameMsg = "success";
					} else {
						nameMsg = "order";
					}
				} else {
					nameMsg = "is_email";
				}
			} else {
				request.put("login_error", "用户名或者密码错误");
				nameMsg = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nameMsg;
	}
}
