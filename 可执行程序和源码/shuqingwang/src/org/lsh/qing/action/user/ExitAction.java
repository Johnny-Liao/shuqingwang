package org.lsh.qing.action.user;

import org.lsh.qing.action.BaseAction;

/*
 * �˳���¼ ���session
 */
public class ExitAction extends BaseAction {
	
	public String execute(){
		session.remove("user");
		return "success";
	}

}
