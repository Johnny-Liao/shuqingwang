package org.lsh.qing.action.user;

import org.lsh.qing.action.BaseAction;

/*
 * ÍË³öµÇÂ¼ Çå³ýsession
 */
public class ExitAction extends BaseAction {
	
	public String execute(){
		session.remove("user");
		return "success";
	}

}
