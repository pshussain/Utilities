package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.AccountBuilder;
import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdaccountBuilder implements FacebookCRUD, AccountBuilder {
	private String batchUrl = "me/adaccounts";
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addAccountBatch;
	private JsonArray updateAccountBatch;
	private JsonArray readAccountBatch;
	private String accessToken;

	// Map<String, FileBody> attachedFile = new HashMap<String, FileBody>();

	public FacebookAdaccountBuilder(String accessToken) {
		this.accessToken = accessToken;
		addAccountBatch = new JsonArray();
		updateAccountBatch = new JsonArray();
		readAccountBatch = new JsonArray();
	}

	public List<String> create() throws UnsupportedEncodingException, Exception {
		List<String> accountIdList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(addAccountBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject account : responseList) {
			if (FacebookUtil.iSuccess(account)) {
				String accountId = getAccountId(account);
				accountIdList.add(accountId);
			}
		}
		return accountIdList;
	}

	public List<Boolean> update() throws Exception {
		List<Boolean> accountIdList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(updateAccountBatch,
				this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println(response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject account : responseList) {
			if (FacebookUtil.iSuccess(account)) {
				boolean updateStatus = getUpdateStatus(account);
				accountIdList.add(updateStatus);
			}
		}
		return accountIdList;
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

	public List<AdAccount> read() throws UnsupportedEncodingException,
			Exception {
		List<AdAccount> accountList = new ArrayList<AdAccount>();
		final HttpEntity entity = FacebookUtil.buildBatch(readAccountBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);

		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject account : responseList) {
			if (FacebookUtil.iSuccess(account)) {
				AdAccount accountInfo = makeAccount(FacebookUtil.toJson(account
						.toString()));
				accountList.add(accountInfo);
			}
		}
		return accountList;

	}

	private AdAccount makeAccount(JsonObject account) {
		String body = account.get("body").getAsString();
		AdAccount accountBean = (AdAccount) FacebookUtil.fromJson(
				FacebookUtil.toJson(body), AdAccount.class);
		return accountBean;
	}

	public void addAccount(String name, String currency, Integer timezoneId) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("relative_url", batchUrl);
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "currency", currency, Constants.AMP);
		FacebookUtil.buildBody(body, "timezone_id", timezoneId, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		account.addProperty("body", body.toString());
		addAccountBatch.add(account);

	}

	public void updateCreditLine(String accountId, String accountPayableEmail) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		FacebookUtil.buildBody(body, "account_payable_email",
				accountPayableEmail);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		account.addProperty("body", body.toString());
		updateAccountBatch.add(account);
	}

	public void updateSpendCap(String accountId, Integer spendCap) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		account.addProperty("body",
				FacebookUtil.buildBody(body, "spend_cap", spendCap));
		updateAccountBatch.add(account);
	}

	public void updateSpendCapAction(String accountId, String action) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		account.addProperty("body",
				FacebookUtil.buildBody(body, "spend_cap_action", action));
		updateAccountBatch.add(account);
	}

	public void updateAccountName(String accountId, String name) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		account.addProperty("body", body.toString());
		updateAccountBatch.add(account);

	}

	public void updateAgencyClientDeclaration(String accountId, Object name) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		FacebookUtil.buildBody(body, "agency_client_declaration", name,
				Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		account.addProperty("body", body.toString());
		updateAccountBatch.add(account);

	}

	public void updateEndAdvertiser(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		FacebookUtil.buildBody(body, "end_advertiser", pageOrAppId,
				Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		account.addProperty("body", body.toString());
		updateAccountBatch.add(account);

	}

	public void updateMediaAgency(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		FacebookUtil
				.buildBody(body, "media_agency", pageOrAppId, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		account.addProperty("body", body.toString());
		updateAccountBatch.add(account);

	}

	public void updatePartner(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		FacebookUtil.buildBody(body, "partner", pageOrAppId, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		account.addProperty("body", body.toString());
		updateAccountBatch.add(account);

	}

	public void fetch(String accountId) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "GET");
		account.addProperty("relative_url", "act_" + accountId
				+ "?include_headers=false");
		readAccountBatch.add(account);

	}

	public void fetch(String accountId, String fields) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "GET");
		account.addProperty("relative_url", "act_" + accountId + "/?fields="
				+ fields + "&include_headers=false");
		readAccountBatch.add(account);
	}

	public void update(String accountId, String key, String value) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", "act_" + accountId);
		account.addProperty("body", key + "=" + value);
		updateAccountBatch.add(account);
	}

	public void update(Map<String, String> keyVal) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		StringBuilder updateBody = new StringBuilder();
		account.addProperty("body",
				FacebookUtil.buildUpdateBody(updateBody, keyVal));
		updateAccountBatch.add(account);
	}

	private String getAccountId(JsonObject account) {
		final String body = account.get("body").getAsString();
		String accountId = FacebookUtil.toJson(body).get("account_id")
				.getAsString();
		return accountId;
	}
}
