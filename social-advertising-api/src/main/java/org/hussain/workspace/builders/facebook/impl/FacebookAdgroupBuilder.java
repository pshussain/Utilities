package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.AdgroupBuilder;
import org.hussain.workspace.builders.facebook.bean.AdGroup;
import org.hussain.workspace.builders.facebook.targeting.AdvancedDemographics;
import org.hussain.workspace.builders.facebook.targeting.Behavior;
import org.hussain.workspace.builders.facebook.targeting.Demographic;
import org.hussain.workspace.builders.facebook.targeting.Interest;
import org.hussain.workspace.builders.facebook.targeting.Location;
import org.hussain.workspace.builders.facebook.targeting.Mobile;
import org.hussain.workspace.builders.facebook.targeting.Placement;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdgroupBuilder implements FacebookCRUD, AdgroupBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addGroupBatch;
	private JsonArray updateGroupBatch;
	private JsonArray readGroupBatch;
	private String accessToken;

	public FacebookAdgroupBuilder(String accessToken) {
		this.addGroupBatch = new JsonArray();
		this.updateGroupBatch = new JsonArray();
		this.readGroupBatch = new JsonArray();
		this.accessToken = accessToken;
	}

	public List<String> create() throws Exception {
		List<String> adgroupIdList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(addGroupBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println(response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject adgroup : responseList) {
			if (FacebookUtil.iSuccess(adgroup)) {
				String accountId = getAdgroupId(adgroup);
				adgroupIdList.add(accountId);
			}
		}
		return adgroupIdList;
	}

	private String getAdgroupId(JsonObject adgroup) {
		final String body = adgroup.get("body").getAsString();
		String adgroupId = FacebookUtil.toJson(body).get("id").getAsString();
		return adgroupId;
	}

	public List<Boolean> update() throws Exception {
		List<Boolean> adgroupIdList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(updateGroupBatch,
				this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject adgroup : responseList) {
			if (FacebookUtil.iSuccess(adgroup)) {
				boolean updateStatus = getUpdateStatus(adgroup);
				adgroupIdList.add(updateStatus);
			}
		}
		return adgroupIdList;

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

	public void fetch(String adgroupId) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "GET");
		adgroup.addProperty("relative_url", adgroupId
				+ "?include_headers=false");
		readGroupBatch.add(adgroup);
	}

	public void fetch(String adgroupId, String fields) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "GET");
		adgroup.addProperty("relative_url", adgroupId + "/?fields=" + fields
				+ "&include_headers=false");
		readGroupBatch.add(adgroup);
	}

	public void update(String adgroupId, String key, String value) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "POST");
		adgroup.addProperty("relative_url", adgroupId);
		adgroup.addProperty("body", key + "=" + value);
		updateGroupBatch.add(adgroup);

	}

	public void update(String adgroupId, Map<String, String> keyVal) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "POST");
		adgroup.addProperty("relative_url", adgroupId);
		StringBuilder updateBody = new StringBuilder();
		adgroup.addProperty("body",
				FacebookUtil.buildUpdateBody(updateBody, keyVal));
		updateGroupBatch.add(adgroup);
	}

	public void addAdgroup(String accountId, String campaignId, String name,
			String bidType, String bidInfo, String creativeId,
			Location location, Mobile mobile, Demographic demographic,
			Placement placement, Interest interests, Behavior behavior,
			AdvancedDemographics advDemographic,
			JsonArray relationshipStatuses, String trackingSpec,
			String objective, String adgroupStatus, List<String> viewTags,
			List<String> socialPrefs) {

		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);

		adgroup.addProperty("relative_url", "act_" + accountId + "/adgroups");

		FacebookUtil.buildBody(body, "name", name, Constants.AMP);
		FacebookUtil.buildBody(body, "adgroup_status", adgroupStatus,
				Constants.AMP);
		FacebookUtil.buildBody(body, "bid_type", bidType, Constants.AMP);
		FacebookUtil.buildBody(body, "bid_info", bidInfo, Constants.AMP);
		FacebookUtil.buildBody(body, "campaign_id", campaignId, Constants.AMP);

		final JsonObject creative = new JsonObject();
		creative.addProperty("creative_id", creativeId);
		FacebookUtil.buildBody(body, "creative", creative, Constants.AMP);
		FacebookUtil.buildBody(body, "objective", objective, Constants.AMP);

		JsonObject targeting = new JsonObject();
		/**
		 * Adding Location Targeting info
		 */
		JsonObject geoLocation = new JsonObject();
		addToTarget(geoLocation, "countries", location.getCountries());
		addToTarget(geoLocation, "cities", location.getCities());
		addToTarget(geoLocation, "regions", location.getRegions());
		addToTarget(geoLocation, "zips", location.getZipcode());
		addToTarget(targeting, "geo_locations", geoLocation);

		/**
		 * Adding Demographic targeting info
		 */
		addToTarget(targeting, "genders", demographic.getGender());
		addToTarget(targeting, "age_min", demographic.getMinAge());
		addToTarget(targeting, "age_max", demographic.getMaxAge());
		addToTarget(targeting, "keywords", demographic.getKeywords());

		/**
		 * Adding Mobile Device Targeting info
		 */
		addToTarget(targeting, "user_os", mobile.getOS());
		addToTarget(targeting, "user_device", mobile.getDevice());
		/**
		 * Site_category: Allowed value is feature_phones. This will allow you
		 * to target mobile users who do not have Android or iOS devices. Do NOT
		 * use this field and user_os or user_device in the same adgroup because
		 * the two are mutually exclusive.
		 */
		addToTarget(targeting, "site_category", mobile.getCategory());

		/**
		 * Adding placement targeting info
		 * */
		addToTarget(targeting, "page_types", placement.getPlacement());

		/**
		 * Adding Interest targeting info
		 */
		addToTarget(targeting, "interests", interests.getInterests());

		/**
		 * Adding Behavior targeting info
		 */
		addToTarget(targeting, "behaviors", behavior.getBehavior());

		/**
		 * Adding Relationship Status info
		 */
		addToTarget(targeting, "relationship_statuses", relationshipStatuses);

		FacebookUtil.buildBody(body, "targeting", targeting, Constants.AMP);

		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		adgroup.addProperty("body", body.toString());
		System.out.println(body);
		addGroupBatch.add(adgroup);

	}

	private void addToTarget(JsonObject targeting, String key, JsonObject value) {
		if (value != null) {
			targeting.add(key, value);
		}

	}

	private void addToTarget(JsonObject targeting, String key, String value) {
		if (!value.isEmpty()) {
			targeting.addProperty(key, value);
		}
	}

	private void addToTarget(JsonObject targeting, String key, JsonArray value) {
		if (value.size() > 0) {
			targeting.add(key, value);
		}
	}

}
