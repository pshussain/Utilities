package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.ClickTrackTagBuilder;
import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.ClickTag;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookClickTrackingTagBuilder implements FacebookCRUD,
		ClickTrackTagBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addClickTagBatch;
	private JsonArray updateClickTagBatch;
	private JsonArray readClickTagBatch;
	private String accessToken;

	public FacebookClickTrackingTagBuilder(String accessToken) {
		this.addClickTagBatch = new JsonArray();
		this.updateClickTagBatch = new JsonArray();
		this.readClickTagBatch = new JsonArray();
		this.accessToken = accessToken;
	}

	public void addTrackingTag(String adgroupId, String url,
			String templateParam) {
		final JsonObject clickTag = new JsonObject();
		clickTag.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		clickTag.addProperty("relative_url", adgroupId + "/trackingtag");
		FacebookUtil.buildBody(body, "url", url, Constants.AMP);
		FacebookUtil.buildBody(body, "add_template_param", templateParam,
				Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		clickTag.addProperty("body", body.toString());
		addClickTagBatch.add(clickTag);

	}

	public void updateUrl(String adgroupId, String url) {
		final JsonObject clickTag = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		clickTag.addProperty("method", "POST");
		clickTag.addProperty("relative_url", adgroupId + "/trackingtag");
		FacebookUtil.buildBody(body, "url", url);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		clickTag.addProperty("body", body.toString());
		updateClickTagBatch.add(clickTag);

	}

	public void updateTemplateParam(String adgroupId, String templateParam) {
		final JsonObject clickTag = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		clickTag.addProperty("method", "POST");
		clickTag.addProperty("relative_url", adgroupId + "/trackingtag");
		FacebookUtil.buildBody(body, "add_template_param", templateParam);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		clickTag.addProperty("body", body.toString());
		updateClickTagBatch.add(clickTag);
	}

	public void update(String adgroupId, String key, String value) {
		final JsonObject clickTag = new JsonObject();
		clickTag.addProperty("method", "POST");
		clickTag.addProperty("relative_url", adgroupId + "/trackingtag");
		clickTag.addProperty("body", key + "=" + value);
		updateClickTagBatch.add(clickTag);

	}

	public void update(String adgroupId, Map<String, String> keyVal) {
		final JsonObject clickTag = new JsonObject();
		clickTag.addProperty("method", "POST");
		clickTag.addProperty("relative_url", adgroupId + "/trackingtag");
		StringBuilder updateBody = new StringBuilder();
		clickTag.addProperty("body",
				FacebookUtil.buildUpdateBody(updateBody, keyVal));
		updateClickTagBatch.add(clickTag);

	}

	public void fetch(String clickTrackTagId) {

	}

	public List<String> create() throws UnsupportedEncodingException, Exception {
		List<String> clickTagList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(addClickTagBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		System.out.println(response);
		for (JsonObject clickTag : responseList) {
			if (FacebookUtil.iSuccess(clickTag)) {
				String accountId = getClickTagId(clickTag);
				clickTagList.add(accountId);
			}
		}
		return clickTagList;
	}

	private String getClickTagId(JsonObject clickTag) {
		final String body = clickTag.get("body").getAsString();
		String clickTrackingTagId = FacebookUtil.toJson(body).get("id").getAsString();
		return clickTrackingTagId;
	}

	public List<Boolean> update() throws Exception {
		List<Boolean> clickTagList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(updateClickTagBatch,
				this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println(response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject clickTag : responseList) {
			if (FacebookUtil.iSuccess(clickTag)) {
				boolean updateStatus = getUpdateStatus(clickTag);
				clickTagList.add(updateStatus);
			}
		}
		return clickTagList;
	}

	private boolean getUpdateStatus(JsonObject account) {
		final String body = account.get("body").getAsString();
		boolean status = FacebookUtil.toJson(body).get("success")
				.getAsBoolean();
		return status;
	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public List<ClickTag> read() throws UnsupportedEncodingException, Exception {
		List<ClickTag> clickTagList = new ArrayList<ClickTag>();
		final HttpEntity entity = FacebookUtil.buildBatch(readClickTagBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);

		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject clickTag : responseList) {
			if (FacebookUtil.iSuccess(clickTag)) {
				ClickTag accountInfo = makeClickTag(FacebookUtil
						.toJson(clickTag.toString()));
				clickTagList.add(accountInfo);
			}
		}
		return clickTagList;
	}

	private ClickTag makeClickTag(JsonObject json) {
		// TODO Auto-generated method stub
		return null;
	}

}
