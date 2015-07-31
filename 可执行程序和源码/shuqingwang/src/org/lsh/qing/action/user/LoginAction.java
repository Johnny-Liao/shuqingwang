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
 * �û���¼
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
				if (user.getIsEmailVerify().equals("Y")) { //�ж��û��Ƿ�������֤
					// ��ȡʱ��
					user.setLastLoginTime(System.currentTimeMillis());
					// ��ȡIP��ַ
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
				request.put("login_error", "�û��������������");
				nameMsg = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nameMsg;
	}
}
