package org.lsh.qing.action.user;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import org.lsh.qing.action.BaseAction;
import org.lsh.qing.util.ImageUtil;

/*
 * 生成图片验证码
 */
public class VerifyCodeAction extends BaseAction {
	private InputStream input;

	public String execute() throws Exception {
		Map<String, BufferedImage> map = ImageUtil.createImage();
		// 返回此映射中包含的键的 Set 视图。然后对其迭代
		String code = map.keySet().iterator().next();
		session.put("code", code);
		// 获取图片对象
		BufferedImage image = map.get(code);
		// 对图片进行处理
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
