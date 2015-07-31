package org.lsh.qing.action.user;

import org.lsh.qing.action.BaseAction;

/*
 * Ajax 对图片验证码进行验证，
 * 如果相等则返回true
 * 不相等返回false。
 */
public class CheckVerifyCodeAction extends BaseAction {
	private String VerifyCode;
	private boolean ok = false;

	public String execute() {
		// 获取生成的验证码
		String code = (String) session.get("code");
		// 比较生成的验证码跟输入的验证码是否相等
		if (code.equalsIgnoreCase(VerifyCode)) {
			ok = true;
		}
		return "success";

	}

	public String getVerifyCode() {
		return VerifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		VerifyCode = verifyCode;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
