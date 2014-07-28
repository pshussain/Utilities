package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.SetBuilder;
import org.hussain.workspace.builders.facebook.bean.AdCampaign;
import org.hussain.workspace.builders.facebook.bean.AdGroup;
import org.hussain.workspace.builders.facebook.bean.AdSet;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdsetBuilder implements FacebookCRUD, SetBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addSetBatch;
	private JsonArray updateSetBatch;
	private JsonArray readSetBatch;
	private String accessToken;

	public FacebookAdsetBuilder(String accessToken) {
		this.addSetBatch = new JsonArray();
		this.updateSetBatch = new JsonArray();
		this.readSetBatch = new JsonArray();
		this.accessToken = accessToken;
	}

	public List<String> create() throws Exception {
		List<String> adsetIdList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(addSetBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println("create :" + response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject adset : responseList) {
			if (FacebookUtil.iSuccess(adset)) {
				String adsetId = getAdsetId(adset);
				adsetIdList.add(adsetId);
			}
		}
		return adsetIdList;
	}

	private String getAdsetId(JsonObject adset) {
		// create
		// :[{"code":200,"body":"{\"id\":\"6021492195131\",\"data\":{\"campaigns\":{\"6021492195131\":{\"id\":\"6021492195131\",\"account_id\":1419302888335966,\"name\":\"New Adset\",\"lifetime_budget\":15000,\"campaign_status\":\"ACTIVE\",\"daily_imps\":0,\"frequency_cap\":0,\"frequency_cap_reset_period\":0,\"start_time\":1406019428,\"end_time\":1406105828,\"updated_time\":1406019418,\"created_time\":1406019418,\"campaign_group_id\":6021492191931,\"prorated_daily_budget\":15000,\"budget_remaining\":15000}}}}"}]

		final String body = adset.get("body").getAsString();
		String adsetId = FacebookUtil.toJson(body).get("id").getAsString();
		return adsetId;
	}

	public List<Boolean> update() throws UnsupportedEncodingException,
			Exception {
		List<Boolean> adsetIdList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(updateSetBatch,
				this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject adset : responseList) {
			if (FacebookUtil.iSuccess(adset)) {
				boolean updateStatus = getUpdateStatus(adset);
				adsetIdList.add(updateStatus);
			}
		}
		return adsetIdList;

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

	public List<AdSet> read() throws Exception {
		List<AdSet> accountList = new ArrayList<AdSet>();
		final HttpEntity entity = FacebookUtil.buildBatch(readSetBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);

		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject adset : responseList) {
			if (FacebookUtil.iSuccess(adset)) {
				AdSet adsetInfo = makeAdset(FacebookUtil.toJson(adset
						.toString()));
				accountList.add(adsetInfo);
			}
		}
		return accountList;

	}

	private AdSet makeAdset(JsonObject json) {
		String body = json.get("body").getAsString();
		AdSet adsetBean = (AdSet) FacebookUtil.fromJson(
				FacebookUtil.toJson(body), AdSet.class);
		return adsetBean;
	}

	public void addSet(String accountId, String name, String campaignGroupId,
			String campaignStatus, long startTime, long endTime,
			Integer dailyBudget, Integer lifetimeBudget) {
		final JsonObject campaign = new JsonObject();
		campaign.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		campaign.addProperty("relative_url", "act_" + accountId
				+ "/adcampaigns");
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "campaign_group_id", campaignGroupId,
				Constants.AMP);
		FacebookUtil.buildBody(body, "campaign_status", campaignStatus,
				Constants.AMP);
		FacebookUtil.buildBody(body, "start_time", startTime, Constants.AMP);
		FacebookUtil.buildBody(body, "end_time", endTime, Constants.AMP);
		FacebookUtil
				.buildBody(body, "daily_budget", dailyBudget, Constants.AMP);
		FacebookUtil.buildBody(body, "lifetime_budget", lifetimeBudget,
				Constants.AMP);

		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		campaign.addProperty("body", body.toString());
		addSetBatch.add(campaign);
	}

	public void fetch(String adsetId) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "GET");
		adgroup.addProperty("relative_url", adsetId + "?include_headers=false");
		readSetBatch.add(adgroup);
	}

	public void fetch(String adsetId, String fields) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "GET");
		adgroup.addProperty("relative_url", adsetId + "/?fields=" + fields
				+ "&include_headers=false");
		readSetBatch.add(adgroup);
	}

	public void update(String adsetId, String key, String value) {
		final JsonObject adset = new JsonObject();
		adset.addProperty("method", "POST");
		adset.addProperty("relative_url", adsetId);
		adset.addProperty("body", key + "=" + value);
		updateSetBatch.add(adset);
	}

	public void update(String adsetId, Map<String, String> keyVal) {
		final JsonObject adset = new JsonObject();
		adset.addProperty("method", "POST");
		adset.addProperty("relative_url", adsetId);
		StringBuilder updateBody = new StringBuilder();
		adset.addProperty("body",
				FacebookUtil.buildUpdateBody(updateBody, keyVal));
		updateSetBatch.add(adset);

	}

}
