package org.lsh.qing.action.user;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.util.ImageUtil;

/*
 * ����ͼƬ��֤��
 */
public class VerifyCodeAction extends BaseAction {
	private InputStream input;

	public String execute() throws Exception {
		Map<String, BufferedImage> map = ImageUtil.createImage();
		// ���ش�ӳ���а����ļ��� Set ��ͼ��Ȼ��������
		String code = map.keySet().iterator().next();
		session.put("code", code);
		// ��ȡͼƬ����
		BufferedImage image = map.get(code);
		// ��ͼƬ���д���
		input = ImageUtil.getInputStream(image);
		input.close();
		return "success";
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}
}
