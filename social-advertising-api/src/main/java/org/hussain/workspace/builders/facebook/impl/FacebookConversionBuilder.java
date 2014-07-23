package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.ConversionPixelBuilder;
import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.OffsitePixel;
import org.hussain.workspace.builders.facebook.bean.OffsitePixelContainer;
import org.hussain.workspace.builders.facebook.enums.Pixel;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class FacebookConversionBuilder implements FacebookCRUD,
		ConversionPixelBuilder {

	public FacebookConversionBuilder(String accessToken) {
		this.addConversionPixelBatch = new JsonArray();
		this.updateConversionPixelBatch = new JsonArray();
		this.readConversionPixelBatch = new JsonArray();
		this.readAuthorizedAccountBatch = new JsonArray();
		this.accessToken = accessToken;
	}

	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addConversionPixelBatch;
	private JsonArray updateConversionPixelBatch;
	private JsonArray readConversionPixelBatch;
	private JsonArray readAuthorizedAccountBatch;
	private String accessToken;

	public void addOffsitePixel(String accountId, String name, Pixel tag) {
		final JsonObject offsitePixel = new JsonObject();
		offsitePixel.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		offsitePixel.addProperty("relative_url", "act_" + accountId
				+ "/offsitepixels");
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "tag", tag.getPixelTag(), Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		offsitePixel.addProperty("body", body.toString());
		addConversionPixelBatch.add(offsitePixel);
	}

	public void getPixelCode(String pixelId) {
		final JsonObject offsitePixel = new JsonObject();
		offsitePixel.addProperty("method", "GET");
		final StringBuilder body = new StringBuilder(100);
		offsitePixel.addProperty("relative_url", pixelId + "/snippets");
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		offsitePixel.addProperty("body", body.toString());
		readConversionPixelBatch.add(offsitePixel);

	}

	public OffsitePixel getPixelCode(String pixelId, Integer value)
			throws Exception {
		final String response = HttpHandler.doGet(Constants.baseURL + "/"
				+ pixelId + "?value=" + value + "&access_token=" + accessToken);
		OffsitePixel offsitePixelBean = (OffsitePixel) FacebookUtil.fromJson(
				FacebookUtil.toJson(response), OffsitePixel.class);
		return offsitePixelBean;

	}

	public void fetch(String accountId, String fields) {
		// TODO Auto-generated method stub

	}

	public void fetch(String accountId) {
		// TODO Auto-generated method stub

	}

	public void removeOffisitePixel(String pixelId) {
		// TODO Auto-generated method stub

	}

	public List<String> create() throws UnsupportedEncodingException, Exception {
		List<String> pixelList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(
				addConversionPixelBatch, this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		System.out.println(response);
		for (JsonObject pixel : responseList) {
			if (FacebookUtil.iSuccess(pixel)) {
				String pixelId = getPixelId(pixel);
				pixelList.add(pixelId);
			}
		}
		return pixelList;
	}

	private String getPixelId(JsonObject conversionPixel) {
		final String pixelId = conversionPixel.get("body").getAsString();
		return pixelId;
	}

	public List<Boolean> update() throws Exception {
		List<Boolean> pixelList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(
				updateConversionPixelBatch, this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject pixel : responseList) {
			if (FacebookUtil.iSuccess(pixel)) {
				boolean updateStatus = getUpdateStatus(pixel);
				pixelList.add(updateStatus);
			}
		}
		return pixelList;
	}

	private boolean getUpdateStatus(JsonObject pixel) {
		final boolean body = pixel.get("body").getAsBoolean();
		return body;
	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public List<OffsitePixel> read() throws UnsupportedEncodingException,
			Exception {
		List<OffsitePixel> pixelList = new ArrayList<OffsitePixel>();
		final HttpEntity entity = FacebookUtil.buildBatch(
				readConversionPixelBatch, this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println(response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject pixel : responseList) {
			if (FacebookUtil.iSuccess(pixel)) {
				OffsitePixel pixelInfo = makePixel(FacebookUtil.toJson(pixel
						.toString()));
				pixelList.add(pixelInfo);
			}
		}
		return pixelList;
	}

	private OffsitePixel makePixel(JsonObject json) {
		System.out.println(json);
		String body = json.get("body").getAsString();
		JsonObject bodyJSON = new Gson().fromJson(body, JsonObject.class);
		OffsitePixel offsitePixelBean = (OffsitePixel) FacebookUtil.fromJson(
				FacebookUtil.toJson(body), OffsitePixel.class);
		return offsitePixelBean;
	}

	public OffsitePixelContainer readAccountPixels()
			throws UnsupportedEncodingException, Exception {
		OffsitePixelContainer container = new OffsitePixelContainer();
		final HttpEntity entity = FacebookUtil.buildBatch(
				readConversionPixelBatch, this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println(response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject pixel : responseList) {
			if (FacebookUtil.iSuccess(pixel)) {
				makeAccountPixel(FacebookUtil.toJson(pixel.toString()),
						container);
			}
		}
		return container;
	}

	private void makeAccountPixel(JsonObject json,
			OffsitePixelContainer container) {
		List<OffsitePixel> accounts = new ArrayList<OffsitePixel>();
		String body = json.get("body").getAsString();
		JsonObject bodyJSON = new Gson().fromJson(body, JsonObject.class);
		JsonArray data = bodyJSON.get("data").getAsJsonArray();

		for (JsonElement account : data) {
			JsonObject accountObj = account.getAsJsonObject();
			OffsitePixel offsitePixelBean = (OffsitePixel) FacebookUtil
					.fromJson(accountObj, OffsitePixel.class);
			accounts.add(offsitePixelBean);
		}

		JsonObject paging = bodyJSON.get("paging").getAsJsonObject();
		String nextOffset = null;
		String previousOffset = null;
		if (paging.has("next"))
			nextOffset = paging.get("next").getAsString();

		if (paging.has("previous"))
			previousOffset = paging.get("previous").getAsString();
		container.setPixels(accounts);
		container.setNext(nextOffset);
		container.setPrevious(previousOffset);

	}

	public Map<String, List<String>> readAuthorizedAccounts()
			throws UnsupportedEncodingException, Exception {
		List<String> accountList = new ArrayList<String>();
		Map<String, List<String>> pixelAccounts = new HashMap<String, List<String>>();
		final HttpEntity entity = FacebookUtil.buildBatch(
				readAuthorizedAccountBatch, this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject pixel : responseList) {
			if (FacebookUtil.iSuccess(pixel)) {
				makeAccount(FacebookUtil.toJson(pixel.toString()),
						pixelAccounts);
			}
		}
		return pixelAccounts;
	}

	private void makeAccount(JsonObject json,
			Map<String, List<String>> pixelAccounts) {
		String body = json.get("body").getAsString();
		// "body":"{\"data\":{\"6016905187726\":[{\"account_id\":1454681918119229},{\"account_id\":100237586827788}]}
		JsonObject bodyJSON = new Gson().fromJson(body, JsonObject.class);
		JsonObject data = bodyJSON.get("data").getAsJsonObject();
		List<String> accounts = new ArrayList<String>();
		for (Entry<String, JsonElement> entry : data.entrySet()) {

			String key = entry.getKey();

			JsonArray accountArray = entry.getValue().getAsJsonArray();
			for (JsonElement account : accountArray) {
				JsonObject accountObj = account.getAsJsonObject();

				accounts.add(accountObj.get("account_id").getAsString());
			}
			pixelAccounts.put(key, accounts);
		}

	}

	public void removeAccount(String pixelId, String accountId) {
		// TODO Auto-generated method stub

	}

	public void updateName(String pixelId, String name) {
		final JsonObject pixel = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		pixel.addProperty("method", "POST");
		pixel.addProperty("relative_url", pixelId);
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		pixel.addProperty("body", body.toString());
		updateConversionPixelBatch.add(pixel);

	}

	public void updateValue(String pixelId, String value) {
		final JsonObject pixel = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		pixel.addProperty("method", "POST");
		pixel.addProperty("relative_url", pixelId);
		FacebookUtil.buildBody(body, "value", value, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		pixel.addProperty("body", body.toString());
		updateConversionPixelBatch.add(pixel);

	}

	public void updateTag(String pixelId, Pixel tag) {
		final JsonObject pixel = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		pixel.addProperty("method", "POST");
		pixel.addProperty("relative_url", pixelId);
		FacebookUtil.buildBody(body, "tag", tag.getPixelTag(), Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		pixel.addProperty("body", body.toString());
		updateConversionPixelBatch.add(pixel);

	}

	public List<Boolean> update(String pixelId, String key, String value)
			throws UnsupportedEncodingException, Exception {
		List<Boolean> pixelList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(
				updateConversionPixelBatch, this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println(response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject clickTag : responseList) {
			if (FacebookUtil.iSuccess(clickTag)) {
				boolean updateStatus = getUpdateStatus(clickTag);
				pixelList.add(updateStatus);
			}
		}
		return pixelList;

	}

	public List<Boolean> authorize(String pixelId, List<Long> accountIds)
			throws UnsupportedEncodingException, Exception {
		List<Boolean> pixelList = new ArrayList<Boolean>();

		final JsonObject offsitePixel = new JsonObject();
		offsitePixel.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		offsitePixel.addProperty("relative_url", pixelId + "/adaccounts");
		FacebookUtil.buildBody(body, "adaccounts",
				FacebookUtil.getJsonArray(accountIds), Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		offsitePixel.addProperty("body", body.toString());
		addConversionPixelBatch.add(offsitePixel);
		System.out.println(addConversionPixelBatch);
		final HttpEntity entity = FacebookUtil.buildBatch(
				addConversionPixelBatch, this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		System.out.println(response);
		for (JsonObject pixel : responseList) {
			if (FacebookUtil.iSuccess(pixel)) {
				boolean authorize = isAuthorized(pixel);
				pixelList.add(authorize);
			}
		}
		return pixelList;
	}

	private boolean isAuthorized(JsonObject pixel) {
		final boolean body = pixel.get("body").getAsBoolean();
		return body;
	}

	public List<Boolean> authorize(String pixelId, String accountId)
			throws UnsupportedEncodingException, Exception {
		List<Long> accountIds = new ArrayList<Long>();
		accountIds.add(Long.valueOf(accountId));
		return authorize(pixelId, accountIds);

	}

	public void fetchByPixel(String pixelId) {
		final JsonObject pixel = new JsonObject();
		pixel.addProperty("method", "GET");
		pixel.addProperty("relative_url", pixelId + "?include_headers=false");
		readConversionPixelBatch.add(pixel);

	}

	public void fetchByAccount(String accountId) {
		final JsonObject pixel = new JsonObject();
		pixel.addProperty("method", "GET");
		pixel.addProperty("relative_url", "act_" + accountId
				+ "/offsitepixels?include_headers=false");
		readConversionPixelBatch.add(pixel);

	}

	public void fetchByAccount(String accountId, String previous, String next) {
		final JsonObject pixel = new JsonObject();
		pixel.addProperty("method", "GET");
		if (next != null || !next.equals(""))
			pixel.addProperty("relative_url", "act_" + accountId
					+ "/offsitepixels?__after_id=" + next
					+ "&include_headers=false");
		if (previous != null || !previous.equals(""))
			pixel.addProperty("relative_url", "act_" + accountId
					+ "/offsitepixels?__previous_id=" + previous
					+ "&include_headers=false");
		if ((next == null || next.equals(""))
				&& (previous == null || previous.equals("")))
			pixel.addProperty("relative_url", "act_" + accountId
					+ "/offsitepixels?include_headers=false");
		readConversionPixelBatch.add(pixel);

	}

	public void fetchAccount(String pixelId) {
		final JsonObject pixel = new JsonObject();
		pixel.addProperty("method", "GET");
		pixel.addProperty("relative_url", pixelId
				+ "/adaccounts?include_headers=false");
		readAuthorizedAccountBatch.add(pixel);

	}

}