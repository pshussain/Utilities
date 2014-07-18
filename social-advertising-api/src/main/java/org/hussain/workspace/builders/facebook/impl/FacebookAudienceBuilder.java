package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.AudienceBuilder;
import org.hussain.workspace.builders.facebook.bean.Audience;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAudienceBuilder implements FacebookCRUD, AudienceBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addAudienceBatch;
	private JsonArray updateAudienceBatch;
	private JsonArray readAudienceBatch;

	private JsonArray addUserBatch;

	private String accessToken;

	public List<String> create() throws UnsupportedEncodingException, Exception {
		List<String> audienceIdList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(addAudienceBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject audience : responseList) {
			if (FacebookUtil.iSuccess(audience)) {
				String audienceId = getAudienceId(audience);
				audienceIdList.add(audienceId);
			}
		}
		return audienceIdList;
	}

	private String getAudienceId(JsonObject account) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Boolean> update() throws UnsupportedEncodingException,
			Exception {
		List<Boolean> audienceIdList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(updateAudienceBatch,
				this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject account : responseList) {
			if (FacebookUtil.iSuccess(account)) {
				boolean updateStatus = getUpdateStatus(account);
				audienceIdList.add(updateStatus);
			}
		}
		return audienceIdList;

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

	public List<Audience> read() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateAudience(String audienceId, String key, String value) {
		// TODO Auto-generated method stub

	}

	public void read(String accountId) {
		// TODO Auto-generated method stub

	}

	public void read(String accountId, String fields) {
		// TODO Auto-generated method stub

	}

	public void fetch(String accountId) {
		// TODO Auto-generated method stub

	}

	public void fetch(String accountId, String fields) {
		// TODO Auto-generated method stub

	}

	public void addUser() {
		// TODO Auto-generated method stub

	}

	public void readPixel(String accountId) {
		final JsonObject audience = new JsonObject();
		audience.addProperty("method", "GET");
		audience.addProperty("relative_url", "act_" + accountId
				+ "/adspixels?fields=code&include_headers=false");
		/*
		 * Need to add parsing logic for pixel code.
		 */
	}

	public void addEmailToAudience(String audienceId, String schema,
			List<String> emailAddresses) {
		// TODO Auto-generated method stub

	}

	public void addWebAudience(String accountId, String name, String subtype,
			int retentionDays, JsonObject rule) {
		final JsonObject audience = new JsonObject();
		audience.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		audience.addProperty("relative_url", "act_" + accountId
				+ "/customaudiences");
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "subtype", subtype, Constants.AMP);
		FacebookUtil.buildBody(body, "retention_days", retentionDays,
				Constants.AMP);
		FacebookUtil.buildBody(body, "rule", rule, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		audience.addProperty("body", body.toString());
		addAudienceBatch.add(audience);
	}

	public void addCustomAudience(String accountId, String name,
			String description, String optOutLink) {
		final JsonObject audience = new JsonObject();
		audience.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		audience.addProperty("relative_url", "act_" + accountId
				+ "/customaudiences");
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "description", description, Constants.AMP);
		FacebookUtil.buildBody(body, "opt_out_link", optOutLink, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		audience.addProperty("body", body.toString());
		addAudienceBatch.add(audience);

	}

	public void update(String audienceId, String key, String value) {
		final JsonObject audience = new JsonObject();
		audience.addProperty("method", "POST");
		audience.addProperty("relative_url", audienceId);
		audience.addProperty("body", key + "=" + value);
		updateAudienceBatch.add(audience);
	}

	public void update(String audienceId, Map<String, String> keyVal) {
		final JsonObject audience = new JsonObject();
		audience.addProperty("method", "POST");
		audience.addProperty("relative_url", audienceId);
		StringBuilder updateBody = new StringBuilder();
		audience.addProperty("body",
				FacebookUtil.buildUpdateBody(updateBody, keyVal));
		updateAudienceBatch.add(audience);
	}

	public void createPixel(String accountId) {
		// TODO Auto-generated method stub

	}

	public void addFacebookIdToAudience(String audienceId, String schema,
			List<String> facebookIds) {
		addUserAudience(audienceId, schema, facebookIds);

	}

	public void addPhoneToAudience(String audienceId, String schema,
			List<String> phoneNumbers) {
		addUserAudience(audienceId, schema, phoneNumbers);

	}

	public void addAdvertiserIdToAudience(String audienceId, String schema,
			List<String> advertiserIds) {
		addUserAudience(audienceId, schema, advertiserIds);
	}

	private void addUserAudience(String audienceId, String schema,
			List<String> userList) {
		final JsonObject user = new JsonObject();
		user.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		user.addProperty("relative_url", audienceId + "/users");
		FacebookUtil.buildBody(body, "schema", schema, Constants.AMP);
		FacebookUtil
				.buildBody(body, "data", userList.toString(), Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		user.addProperty("payload", body.toString());
		addUserBatch.add(user);
	}
}
