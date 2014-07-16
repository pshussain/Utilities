package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.UserBuilder;
import org.hussain.workspace.builders.facebook.bean.AdGroup;
import org.hussain.workspace.builders.facebook.bean.AdUser;
import org.hussain.workspace.builders.facebook.enums.Role;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAduserBuilder implements FacebookCRUD, UserBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addUserBatch;
	private JsonArray updateUserBatch;
	private JsonArray readUserBatch;
	private String accessToken;

	public List<String> create() throws Exception {
		List<String> aduserIdList = new ArrayList<String>();
		final HttpEntity entity = FacebookUtil.buildBatch(addUserBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject aduser : responseList) {
			if (FacebookUtil.iSuccess(aduser)) {
				String userId = getUserId(aduser);
				aduserIdList.add(userId);
			}
		}
		return aduserIdList;
	}

	private String getUserId(JsonObject aduser) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Boolean> update() throws UnsupportedEncodingException,
			Exception {
		List<Boolean> aduserIdList = new ArrayList<Boolean>();
		final HttpEntity entity = FacebookUtil.buildBatch(updateUserBatch,
				this.accessToken, false);
		String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println(response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject aduser : responseList) {
			if (FacebookUtil.iSuccess(aduser)) {
				boolean updateStatus = getUpdateStatus(aduser);
				aduserIdList.add(updateStatus);
			}
		}
		return aduserIdList;

	}

	private boolean getUpdateStatus(JsonObject account) {
		// TODO Auto-generated method stub
		return false;
	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public List<AdUser> read() throws Exception {
		List<AdUser> aduserList = new ArrayList<AdUser>();
		final HttpEntity entity = FacebookUtil.buildBatch(readUserBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);

		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject aduser : responseList) {
			if (FacebookUtil.iSuccess(aduser)) {
				AdUser aduserInfo = makeAduser(FacebookUtil.toJson(aduser
						.toString()));
				aduserList.add(aduserInfo);
			}
		}
		return aduserList;

	}

	private AdUser makeAduser(JsonObject json) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(String accountId, String uid, Role role) {
		final JsonObject user = new JsonObject();
		user.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		user.addProperty("relative_url", "act_" + accountId + "/users");
		FacebookUtil.buildBody(body, "uid", uid, Constants.AMP);
		FacebookUtil.buildBody(body, "role", role.getRole(), Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		user.addProperty("body", body.toString());
		addUserBatch.add(user);
	}

	public void fetch(String accountId) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "GET");
		adgroup.addProperty("relative_url", "act_" + accountId
				+ "/users?include_headers=false");
		readUserBatch.add(adgroup);
	}

	public void fetch(String accountId, String fields) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "GET");
		adgroup.addProperty("relative_url", "act_" + accountId
				+ "/users?fields=" + fields + "&include_headers=false");
		readUserBatch.add(adgroup);
	}

}
