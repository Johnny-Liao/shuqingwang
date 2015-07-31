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

	private static String sendUserName = "JohnnyJavaMailTest@163.com";		 // �����ʼ��û���--���ڴ������Լ���163������
	private static String sendUserPassword = "johnnyjavamailte"; 			// �����ʼ�����--���ڴ������Լ����������

	/**
	 * �����ʼ�����
	 * 
	 * @param sendTo
	 *            ��Ҫ���͸��������ַ
	 * @param code
	 *            ���͵���֤��
	 */
	public static void sendMail(String sendTo, String code)
			throws MessagingException {

		Properties props = new Properties();
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.transport.protocol", "smtp");

		// ���û�����Ϣ
		Session session = Session.getInstance(props);
		// �����ʼ�����
		Message msg = new MimeMessage(session);
		msg.setSubject("������ע����֤�ʼ���");
		// �����ʼ�����
		msg.setText("���ʼ�Ϊ������ע����֤�ʼ�����֤��Ϊ��" + code + ". ����ע��ҳ��������֤�롣");
		// ���÷�����
		msg.setFrom(new InternetAddress(sendUserName));
		Transport transport = session.getTransport();
		// �����ʼ�������
		transport.connect(sendUserName, sendUserPassword);
		// �����ʼ�
		transport.sendMessage(msg,
				new Address[] { new InternetAddress(sendTo) });
		// �ر�����
		transport.close();
	}

	// ������
	public static void main(String[] args) {
		try {
			sendMail("smileqf@163.com", "4546");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		// My163Mail m = new My163Mail();
	}
}
