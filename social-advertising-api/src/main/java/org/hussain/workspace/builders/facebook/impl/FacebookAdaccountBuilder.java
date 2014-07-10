package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.hussain.workspace.builders.facebook.AccountBuilder;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdaccountBuilder implements FacebookCRUD, AccountBuilder {
	private String batchUrl = "me/adaccounts";
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addAccountArray;
	private JsonArray updateAccountArray;
	private JsonArray readAccountArray;
	private String accessToken;

	// Map<String, FileBody> attachedFile = new HashMap<String, FileBody>();

	public FacebookAdaccountBuilder(String accessToken) {

		this.accessToken = accessToken;
	}

	public String create() throws UnsupportedEncodingException, Exception {
		final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
				1);
		nameValuePairs.add(new BasicNameValuePair("batch", addAccountArray
				.toString()));
		nameValuePairs.add(new BasicNameValuePair("access_token",
				this.accessToken));
		String response = HttpHandler.doPost(FacebookUtil.baseURL,
				new UrlEncodedFormEntity(nameValuePairs));
		return null;
	}

	public void update() {
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public void read() {
		// TODO Auto-generated method stub

	}

	public void addAccount(String name, String currency, Integer timezoneId) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("relative_url", batchUrl);
		FacebookUtil.buildBody(body, "name", name);
		FacebookUtil.buildBody(body, "currency", currency);
		FacebookUtil.buildBody(body, "timezone_id", timezoneId);
		account.addProperty("body", body.toString());
		addAccountArray.add(account);

	}

	public void updateCreditLine(String accountId, String accountPayableEmail) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", FacebookUtil.buildBody(body,
				"account_payable_email", accountPayableEmail));
		updateAccountArray.add(account);
	}

	public void updateSpendCap(String accountId, Integer spendCap) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body",
				FacebookUtil.buildBody(body, "spend_cap", spendCap));
		updateAccountArray.add(account);
	}

	public void updateSpendCapAction(String accountId, String action) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body",
				FacebookUtil.buildBody(body, "spend_cap_action", action));
		updateAccountArray.add(account);
	}

	public void updateAccountName(String accountId, String name) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", FacebookUtil.buildBody(body, "name", name));
		updateAccountArray.add(account);

	}

	public void updateAgencyClientDeclaration(String accountId, Object name) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body",
				FacebookUtil.buildBody(body, "agency_client_declaration", name));
		updateAccountArray.add(account);

	}

	public void updateEndAdvertiser(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body",
				FacebookUtil.buildBody(body, "end_advertiser", pageOrAppId));
		updateAccountArray.add(account);

	}

	public void updateMediaAgency(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body",
				FacebookUtil.buildBody(body, "media_agency", pageOrAppId));
		updateAccountArray.add(account);

	}

	public void updatePartner(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body",
				FacebookUtil.buildBody(body, "partner", pageOrAppId));
		updateAccountArray.add(account);

	}

	public void read(String accountId) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "GET");
		account.addProperty("relative_url", "act_" + accountId);
		readAccountArray.add(account);

	}

	public void read(String accountId, String fields) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "GET");
		account.addProperty("relative_url", "act_" + accountId + "/?fields="
				+ fields);
		readAccountArray.add(account);
	}

	public void update(String key, String value) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", key + "=" + value);
		updateAccountArray.add(account);
	}

}
