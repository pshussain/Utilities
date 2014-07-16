package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.CampaignBuilder;
import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.AdCampaign;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdcampaignBuilder implements FacebookCRUD, CampaignBuilder {
	private String batchUrl = "me/adaccounts";
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addCampaignBatch;
	private JsonArray updateCampaignBatch;
	private JsonArray readCampaignBatch;

	public FacebookAdcampaignBuilder(String accessToken) {
		addCampaignBatch = new JsonArray();
		updateCampaignBatch = new JsonArray();
		readCampaignBatch = new JsonArray();
		this.accessToken = accessToken;
	}

	private String accessToken;

	public List<String> create() throws UnsupportedEncodingException, Exception {
		List<String> campaignIdList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(addCampaignBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject campaign : responseList) {
			if (FacebookUtil.iSuccess(campaign)) {
				String campaignId = getCampaignId(campaign);
				campaignIdList.add(campaignId);
			}
		}
		return campaignIdList;
	}

	private String getCampaignId(JsonObject campaign) {
		final String body = campaign.get("body").getAsString();
		String campaignId = FacebookUtil.toJson(body).get("account_id")
				.getAsString();
		return campaignId;
	}

	public List<Boolean> update() throws UnsupportedEncodingException,
			Exception {
		List<Boolean> campaignIdList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(updateCampaignBatch,
				this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject campaign : responseList) {
			if (FacebookUtil.iSuccess(campaign)) {
				boolean updateStatus = getUpdateStatus(campaign);
				campaignIdList.add(updateStatus);
			}
		}
		return campaignIdList;
	}

	private boolean getUpdateStatus(JsonObject campaign) {
		final String body = campaign.get("body").getAsString();
		boolean status = FacebookUtil.toJson(body).get("success")
				.getAsBoolean();
		return status;
	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public List<AdCampaign> read() throws UnsupportedEncodingException,
			Exception {
		List<AdCampaign> accountList = new ArrayList<AdCampaign>();
		final HttpEntity entity = FacebookUtil.buildBatch(readCampaignBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);

		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject account : responseList) {
			if (FacebookUtil.iSuccess(account)) {
				AdCampaign campaignInfo = makeCampaign(FacebookUtil
						.toJson(account.toString()));
				accountList.add(campaignInfo);
			}
		}
		return accountList;

	}

	private AdCampaign makeCampaign(JsonObject campaign) {
		String body = campaign.get("body").getAsString();
		AdCampaign campaignBean = (AdCampaign) FacebookUtil.fromJson(
				FacebookUtil.toJson(body), AdCampaign.class);
		return campaignBean;
	}

	public void addCampaign(String accountId, String name, String objective,
			String campaignGroupStatus, String buyingType) {
		final JsonObject campaign = new JsonObject();
		campaign.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		campaign.addProperty("relative_url", "act_" + accountId
				+ "/adcampaign_groups");
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "objective", objective, Constants.AMP);
		FacebookUtil.buildBody(body, "campaign_group_status",
				campaignGroupStatus, Constants.AMP);
		FacebookUtil.buildBody(body, "buying_type", buyingType, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		campaign.addProperty("body", body.toString());
		addCampaignBatch.add(campaign);

	}

	public void updateName(String accountId, String name) {
		final JsonObject campaign = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		campaign.addProperty("method", "POST");
		campaign.addProperty("relative_url", accountId);
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		campaign.addProperty("body", body.toString());
		updateCampaignBatch.add(campaign);

	}

	public void updateObjective(String accountId, String objective) {
		final JsonObject campaign = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		campaign.addProperty("method", "POST");
		campaign.addProperty("relative_url", accountId);
		FacebookUtil.buildBody(body, "objective", objective, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		campaign.addProperty("body", body.toString());
		updateCampaignBatch.add(campaign);

	}

	public void updateStatus(String accountId, String status) {
		final JsonObject campaign = new JsonObject();
		final StringBuilder body = new StringBuilder(100);
		campaign.addProperty("method", "POST");
		campaign.addProperty("relative_url", accountId);
		FacebookUtil.buildBody(body, "status", status, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		campaign.addProperty("body", body.toString());
		updateCampaignBatch.add(campaign);

	}

	public void update(String accountId, String key, String value) {
		final JsonObject campaign = new JsonObject();
		campaign.addProperty("method", "POST");
		campaign.addProperty("relative_url", accountId);
		campaign.addProperty("body", key + "=" + value);
		updateCampaignBatch.add(campaign);
	}

	public void update(String accountId, Map<String, String> keyVal) {
		final JsonObject campaign = new JsonObject();
		campaign.addProperty("method", "POST");
		campaign.addProperty("relative_url", accountId);
		StringBuilder updateBody = new StringBuilder();
		campaign.addProperty("body",
				FacebookUtil.buildUpdateBody(updateBody, keyVal));
		updateCampaignBatch.add(campaign);
	}

	public void fetch(String accountId) {
		// TODO Auto-generated method stub

	}

	public void fetch(String accountId, String fields) {
		// TODO Auto-generated method stub

	}

}
