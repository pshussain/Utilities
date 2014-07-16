package org.hussain.workspace.builders.facebook.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.SetBuilder;
import org.hussain.workspace.builders.facebook.bean.AdSet;
import org.hussain.workspace.crud.FacebookCRUD;
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

	public List<String> create() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Boolean> update() {
		return null;
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public List<AdSet> read() {
		return null;
		// TODO Auto-generated method stub

	}

	public void addSet() {
		// TODO Auto-generated method stub

	}

	public void addSet(String accountId, String name, String campaignGroupId,
			String campaignStatus, String startTime, String endTime,
			String updatedTime, String created_time, Integer dailyBudget,
			Integer lifetimeBudget) {
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
				.buildBody(body, "updated_time", updatedTime, Constants.AMP);
		FacebookUtil
				.buildBody(body, "daily_budget", dailyBudget, Constants.AMP);
		FacebookUtil.buildBody(body, "lifetime_budget", lifetimeBudget,
				Constants.AMP);

		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		campaign.addProperty("body", body.toString());
		addSetBatch.add(campaign);
	}

}
