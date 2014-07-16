package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.AdgroupBuilder;
import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.AdGroup;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdgroupBuilder implements FacebookCRUD, AdgroupBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addGroupBatch;
	private JsonArray updateGroupBatch;
	private JsonArray readGroupBatch;
	private String accessToken;

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

	public List<AdGroup> read() throws UnsupportedEncodingException, Exception {
		List<AdGroup> adgroupList = new ArrayList<AdGroup>();
		final HttpEntity entity = FacebookUtil.buildBatch(readGroupBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);

		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject adgroup : responseList) {
			if (FacebookUtil.iSuccess(adgroup)) {
				AdGroup adgroupInfo = makeAdgroup(FacebookUtil.toJson(adgroup
						.toString()));
				adgroupList.add(adgroupInfo);
			}
		}
		return adgroupList;
	}

	private AdGroup makeAdgroup(JsonObject json) {
		String body = json.get("body").getAsString();
		AdGroup adgroupBean = (AdGroup) FacebookUtil.fromJson(
				FacebookUtil.toJson(body), AdGroup.class);
		return adgroupBean;
	}

	public void addAdgroup(String accountId, String name, String adgroupStatus,
			String bidType, String bidInfo, JsonObject conversionSpecs,
			String campaignId, JsonObject creative, String objective,
			JsonObject targeting, JsonObject trackingSpecs,
			JsonObject viewTags, JsonObject socialPrefs) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		adgroup.addProperty("relative_url", "act_" + accountId + "/adgroups");
		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "adgroup_status", adgroupStatus,
				Constants.AMP);
		FacebookUtil.buildBody(body, "bid_type", bidType, Constants.AMP);
		FacebookUtil.buildBody(body, "bid_info", bidInfo, Constants.AMP);
		FacebookUtil.buildBody(body, "conversion_specs", conversionSpecs,
				Constants.AMP);
		FacebookUtil.buildBody(body, "campaign_id", campaignId, Constants.AMP);
		FacebookUtil.buildBody(body, "creative", creative, Constants.AMP);
		FacebookUtil.buildBody(body, "objective", objective, Constants.AMP);
		FacebookUtil.buildBody(body, "targeting", targeting, Constants.AMP);
		FacebookUtil.buildBody(body, "tracking_specs", trackingSpecs,
				Constants.AMP);
		FacebookUtil.buildBody(body, "view_tags", viewTags, Constants.AMP);
		FacebookUtil
				.buildBody(body, "social_prefs", socialPrefs, Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		adgroup.addProperty("body", body.toString());
		addGroupBatch.add(adgroup);

	}

	public void fetch(String adgroupId) {
		// TODO Auto-generated method stub

	}

	public void fetch(String adgroupId, String fields) {
		// TODO Auto-generated method stub

	}

}
