package org.hussain.workspace.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class FacebookUtil {
	public static String buildBody(StringBuilder body, String key, Object value) {
		return body.append(key).append("=").append(value).toString();

	}

	public static String buildBody(StringBuilder body, String key,
			Object value, String amp) {
		return body.append(key).append("=").append(value).append(amp)
				.toString();

	}

	public static String buildUpdateBody(StringBuilder updateBody,
			Map<String, String> keyVal) {
		int len = keyVal.size();
		int counter = 0;
		for (Map.Entry<String, String> entry : keyVal.entrySet()) {
			if (counter < len - 1)
				FacebookUtil.buildBody(updateBody, entry.getKey(),
						entry.getValue(), Constants.AMP);
			else
				FacebookUtil.buildBody(updateBody, entry.getKey(),
						entry.getValue());
			counter++;

		}
		return updateBody.toString();

	}

	public static HttpEntity buildBatch(JsonArray addAccountArray,
			String accessToken, boolean downloadHeader)
			throws UnsupportedEncodingException, Exception {
		final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
				1);
		nameValuePairs.add(new BasicNameValuePair("batch", addAccountArray
				.toString()));
		nameValuePairs.add(new BasicNameValuePair("access_token", accessToken));
		return new UrlEncodedFormEntity(nameValuePairs);
	}

	public static HttpEntity buildBatch(JsonArray addAccountArray,
			Map<String, FileBody> attachedFiles, String accessToken,
			boolean downloadHeader) throws UnsupportedEncodingException,
			Exception {
		final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
				1);
		nameValuePairs.add(new BasicNameValuePair("batch", addAccountArray
				.toString()));
		nameValuePairs.add(new BasicNameValuePair("access_token", accessToken));
		return new UrlEncodedFormEntity(nameValuePairs);
	}

	public static ArrayList<JsonObject> getResponseAsList(String result) {
		Type collectionType = new TypeToken<ArrayList<JsonObject>>() {
		}.getType();
		ArrayList<JsonObject> entityData = null;
		try {
			entityData = new Gson().fromJson(result, collectionType);
		} catch (Exception e) {
			System.out.println("Error :: " + e.getMessage() + result);
		}
		return entityData;

	}

	public static boolean iSuccess(JsonObject account) {
		return account.get("code").getAsString().equals("200") ? true : false;
	}

	public static JsonObject toJson(String response) {
		final Gson gson = new Gson();
		return gson.fromJson(response, JsonObject.class);
	}
}
