package org.lsh.qing.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class BaseAction implements RequestAware, SessionAware,
		ApplicationAware, ServletRequestAware, ServletContextAware,
		ServletResponseAware {
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected static HttpServletRequest httpReq;
	protected HttpServletResponse response;
	protected ServletContext httpApplication;

	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;

	}

	public void setServletContext(ServletContext httpApplication) {
		this.httpApplication = httpApplication;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@SuppressWarnings("static-access")
	public void setServletRequest(HttpServletRequest httpReq) {
		this.httpReq = httpReq;

	}

}
