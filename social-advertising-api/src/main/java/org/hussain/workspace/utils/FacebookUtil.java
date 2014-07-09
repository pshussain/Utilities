package org.hussain.workspace.utils;

public class FacebookUtil {
	public static String buildBody(StringBuilder body, String key, Object value) {
		return body.append(key).append("=").append(value).toString();

	}
}
