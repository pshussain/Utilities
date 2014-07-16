package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.CreativeBuilder;
import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.AdCreative;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdcreativeBuilder implements FacebookCRUD, CreativeBuilder {

	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addCreativeBatch;
	private JsonArray updateCreativeBatch;
	private JsonArray readCreativeBatch;
	private String accessToken;

	public FacebookAdcreativeBuilder(String accessToken) {
		this.accessToken = accessToken;
		addCreativeBatch = new JsonArray();
		updateCreativeBatch = new JsonArray();
		readCreativeBatch = new JsonArray();
	}

	public List<Boolean> update() {
		return null;
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public List<String> create() throws UnsupportedEncodingException, Exception {
		List<String> accountIdList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(addCreativeBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject account : responseList) {
			if (FacebookUtil.iSuccess(account)) {
				String accountId = getCreativeId(account);
				accountIdList.add(accountId);
			}
		}
		return accountIdList;

	}

	private String getCreativeId(JsonObject creative) {
		System.out.println(creative);
		final String body = creative.get("body").getAsString();
		String creativeId = FacebookUtil.toJson(body).get("creative_id")
				.getAsString();
		return creativeId;
	}

	public void addLinkAd(String accountId, String title, String body,
			String objectUrl, String imageFile, String imageHash, String name,
			String actorId) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "POST");
		final StringBuilder batchBody = new StringBuilder(100);
		creative.addProperty("relative_url", "act_" + accountId
				+ "/adcreatives");
		FacebookUtil.buildBody(batchBody, "title", title, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "body", body, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "object_url", objectUrl,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "image_hash", imageHash,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "name", name, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "actor_id", actorId, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "include_headers", false,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "redownload", true);
		creative.addProperty("body", batchBody.toString());
		addCreativeBatch.add(creative);

	}

	public void addPageLikeAd(String accountId, String objectId, String body,
			String name, String linkUrl, String imageFile, String imageHash,
			String title) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "POST");
		final StringBuilder batchBody = new StringBuilder(100);
		creative.addProperty("relative_url", "act_" + accountId
				+ "/adcreatives");
		FacebookUtil.buildBody(batchBody, "object_id", objectId, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "body", body, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "name", name, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "link_url", linkUrl, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "image_hash", imageHash,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "title", title, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "include_headers", false,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "redownload", true);
		creative.addProperty("body", batchBody.toString());
		addCreativeBatch.add(creative);

	}

	public void addEventAd(String accountId, String objectId, String body,
			String name, String imageFile, String title) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "POST");
		final StringBuilder batchBody = new StringBuilder(100);
		creative.addProperty("relative_url", "act_" + accountId
				+ "/adcreatives");
		FacebookUtil.buildBody(batchBody, "object_id", objectId, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "body", body, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "name", name, Constants.AMP);
		// Need to write image upload feature
		FacebookUtil.buildBody(batchBody, "image_file", imageFile,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "title", title, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "include_headers", false,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "redownload", true);
		creative.addProperty("body", batchBody.toString());
		addCreativeBatch.add(creative);

	}

	public void addMobileAppInstall(String accountId, String obejctStoreUrl,
			String imageHash, String body, String actorName, String name,
			String actorImageHash, String callToActionType, String videoId) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "POST");
		final StringBuilder batchBody = new StringBuilder(100);
		creative.addProperty("relative_url", "act_" + accountId
				+ "/adcreatives");
		FacebookUtil.buildBody(batchBody, "object_store_url", obejctStoreUrl,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "image_hash", imageHash,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "body", body, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "name", name, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "actor_image_hash", actorImageHash,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "call_to_action_type",
				callToActionType, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "video_id", videoId, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "include_headers", false,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "redownload", true);
		creative.addProperty("body", batchBody.toString());
		addCreativeBatch.add(creative);

	}

	public void addMobileAppEngage(String accountId, String obejctStoreUrl,
			String imageHash, String title, String callToActionType,
			String linkDeepLinkUrl, String body, String name,
			String actorImageHash) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "POST");
		final StringBuilder batchBody = new StringBuilder(100);
		creative.addProperty("relative_url", "act_" + accountId
				+ "/adcreatives");
		FacebookUtil.buildBody(batchBody, "object_store_url", obejctStoreUrl,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "image_hash", imageHash,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "title", title, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "call_to_action_type",
				callToActionType, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "link_deep_link_url",
				linkDeepLinkUrl, Constants.AMP);

		FacebookUtil.buildBody(batchBody, "body", body, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "name", name, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "actor_image_hash", actorImageHash,
				Constants.AMP);

		FacebookUtil.buildBody(batchBody, "include_headers", false,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "redownload", true);
		creative.addProperty("body", batchBody.toString());
		addCreativeBatch.add(creative);

	}

	public void addDesktopApp(String accountId, String objectId,
			String imageHash, String body, String actorName, String urlTags,
			String linkUrl, String name, String actorImageHash) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "POST");
		final StringBuilder batchBody = new StringBuilder(100);
		creative.addProperty("relative_url", "act_" + accountId
				+ "/adcreatives");
		FacebookUtil.buildBody(batchBody, "object_id", objectId, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "image_hash", imageHash,
				Constants.AMP);

		FacebookUtil.buildBody(batchBody, "body", body, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "url_tags", urlTags, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "link_url", linkUrl, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "name", name, Constants.AMP);
		FacebookUtil.buildBody(batchBody, "actor_image_hash", actorImageHash,
				Constants.AMP);

		FacebookUtil.buildBody(batchBody, "include_headers", false,
				Constants.AMP);
		FacebookUtil.buildBody(batchBody, "redownload", true);
		creative.addProperty("body", batchBody.toString());
		addCreativeBatch.add(creative);

	}

	public List<AdCreative> read() throws UnsupportedEncodingException,
			Exception {
		List<AdCreative> creativeList = new ArrayList<AdCreative>();
		final HttpEntity entity = FacebookUtil.buildBatch(readCreativeBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);

		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject creative : responseList) {
			if (FacebookUtil.iSuccess(creative)) {
				AdCreative creativeInfo = makeCreative(FacebookUtil
						.toJson(creative.toString()));
				creativeList.add(creativeInfo);
			}
		}
		return creativeList;
	}

	private AdCreative makeCreative(JsonObject json) {
		String body = json.get("body").getAsString();
		AdCreative creativeBean = (AdCreative) FacebookUtil.fromJson(
				FacebookUtil.toJson(body), AdCreative.class);
		return creativeBean;
	}

	public void update(String creativeId, String key, String value) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "POST");
		creative.addProperty("relative_url", "act_" + creativeId);
		creative.addProperty("body", key + "=" + value);
		updateCreativeBatch.add(creative);
	}

	public void update(String creativeId, Map<String, String> keyVal) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "POST");
		creative.addProperty("relative_url", creativeId);
		StringBuilder updateBody = new StringBuilder();
		creative.addProperty("body",
				FacebookUtil.buildUpdateBody(updateBody, keyVal));
		updateCreativeBatch.add(creative);
	}

	public void fetch(String adCampaignGroupId) {
		final JsonObject creative = new JsonObject();
		creative.addProperty("method", "GET");
		creative.addProperty("relative_url", adCampaignGroupId
				+ "?include_headers=false");
		readCreativeBatch.add(creative);

	}

	public void fetch(String adCampaignGroupId, String fields) {
		final JsonObject account = new JsonObject();
		account.addProperty("method", "GET");
		account.addProperty("relative_url", adCampaignGroupId + "/?fields="
				+ fields + "&include_headers=false");
		readCreativeBatch.add(account);
	}

}
