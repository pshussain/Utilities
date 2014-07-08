package org.hussain.workspace.builders.facebook.impl;

import org.hussain.workspace.builders.facebook.AccountBuilder;
import org.hussain.workspace.crud.FacebookCRUD;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdaccountBuilder implements FacebookCRUD, AccountBuilder {
	private String batchUrl = "me/adaccounts";
	private String singleUrl = "me/adaccounts";
	JsonArray accountArray;

	public String create(boolean isBatch) {
		if (accountArray.size() > 1)
			// Use BatchUrl
			return batchUrl;
		else
			// Use SingleUrl
			return singleUrl;

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
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "name=" + name + "&currency=" + currency
				+ "&timezone_id=" + timezoneId);
		accountArray.add(account);

	}

	public void updateCreditLine(String accountId, String accountPayableEmail) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "account_payable_email="
				+ accountPayableEmail);
		accountArray.add(account);
	}

	public void updateSpendCap(String accountId, Integer spendCap) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "spend_cap=" + spendCap);
		accountArray.add(account);
	}

	public void updateSpendCapAction(String accountId, String action) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "spend_cap_action=" + action);
		accountArray.add(account);
	}

	public void updateAccountName(String accountId, String name) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "name=" + name);
		accountArray.add(account);

	}

	public void updateAgencyClientDeclaration(String accountId, Object name) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "agency_client_declaration=" + name);
		accountArray.add(account);

	}

	public void updateEndAdvertiser(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "end_advertiser=" + pageOrAppId);
		accountArray.add(account);

	}

	public void updateMediaAgency(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "media_agency=" + pageOrAppId);
		accountArray.add(account);

	}

	public void updatePartner(String accountId, Long pageOrAppId) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", "partner=" + pageOrAppId);
		accountArray.add(account);

	}

	public void read(String accountId) {
		// TODO Auto-generated method stub

	}

	public void read(String accountId, String fields) {
		// TODO Auto-generated method stub

	}

	public void update(String key, String value) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", batchUrl);
		account.addProperty("body", key + "=" + value);
		accountArray.add(account);
	}

}
