package org.lsh.qing.util;

import java.util.UUID;

public class VerifyUtil {
	public static String createCode() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static void main(String[] args) {
		System.out.println(createCode());
		System.out.println(createCode());
		System.out.println(createCode());
	}

}
