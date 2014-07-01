package org.hussain.workspace.builders.facebook.impl;

import org.hussain.workspace.builders.facebook.AccountBuilder;
import org.hussain.workspace.crud.FacebookCRUD;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdaccountBuilder implements FacebookCRUD, AccountBuilder {
	private String url = "me/adaccounts";
	JsonArray accountArray;

	public String create() {
		// TODO Auto-generated method stub
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
		JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		account.addProperty("relative_url", url);
		account.addProperty("body", "name=" + name + "&currency=" + currency
				+ "&timezone_id=" + timezoneId);
		accountArray.add(account);

	}

	public void updateCreditLine(String accountId, String accountPayableEmail) {
		// TODO Auto-generated method stub

	}

	public void updateSpendCap(String accountId, Integer spendCap) {
		// TODO Auto-generated method stub

	}

	public void updateSpendCapAction(String accountId, String action) {
		// TODO Auto-generated method stub

	}

	public void updateAccountName(String accountId, String name) {
		// TODO Auto-generated method stub

	}

	public void updateAgencyClientDeclaration(String accountId, Object name) {
		// TODO Auto-generated method stub

	}

	public void updateEndAdvertiser(String accountId, Long pageOrAppId) {
		// TODO Auto-generated method stub

	}

	public void updateMediaAgency(String accountId, Long pageOrAppId) {
		// TODO Auto-generated method stub

	}

	public void updatePartner(String accountId, Long pageOrAppId) {
		// TODO Auto-generated method stub

	}

	public void read(String accountId) {
		// TODO Auto-generated method stub

	}

	public void read(String accountId, String fields) {
		// TODO Auto-generated method stub

	}

}
