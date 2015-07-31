package org.lsh.qing.action.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class My163Mail {

	private static String sendUserName = "JohnnyJavaMailTest@163.com";		 // 发送邮件用户名--请在此填上自己的163邮箱名
	private static String sendUserPassword = "johnnyjavamailte"; 			// 发送邮件密码--请在此填上自己邮箱的密码

	/**
	 * 发送邮件方法
	 * 
	 * @param sendTo
	 *            需要发送给的邮箱地址
	 * @param code
	 *            发送的验证码
	 */
	public static void sendMail(String sendTo, String code)
			throws MessagingException {

		Properties props = new Properties();
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.transport.protocol", "smtp");

		// 设置环境信息
		Session session = Session.getInstance(props);
		// 创建邮件对象
		Message msg = new MimeMessage(session);
		msg.setSubject("书磬网注册验证邮件！");
		// 设置邮件内容
		msg.setText("此邮件为书磬网注册验证邮件，验证码为：" + code + ". 请在注册页面填入验证码。");
		// 设置发件人
		msg.setFrom(new InternetAddress(sendUserName));
		Transport transport = session.getTransport();
		// 连接邮件服务器
		transport.connect(sendUserName, sendUserPassword);
		// 发送邮件
		transport.sendMessage(msg,
				new Address[] { new InternetAddress(sendTo) });
		// 关闭连接
		transport.close();
	}

	// 测试用
	public static void main(String[] args) {
		try {
			sendMail("smileqf@163.com", "4546");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		// My163Mail m = new My163Mail();
	}
}
