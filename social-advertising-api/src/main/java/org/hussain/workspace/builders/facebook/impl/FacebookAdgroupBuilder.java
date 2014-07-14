package org.hussain.workspace.builders.facebook.impl;

import java.util.List;

import org.hussain.workspace.builders.facebook.AdgroupBuilder;
import org.hussain.workspace.builders.facebook.bean.AdGroup;
import org.hussain.workspace.crud.FacebookCRUD;

import com.google.gson.JsonObject;

public class FacebookAdgroupBuilder implements FacebookCRUD, AdgroupBuilder {

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

	public List<AdGroup> read() {
		return null;
		// TODO Auto-generated method stub

	}

	public void addAdgroup(String accountId, String bidType, String bidInfo,
			JsonObject conversionSpecs, String campaignId, JsonObject creative,
			String objective, JsonObject targeting, JsonObject trackingSpecs,
			JsonObject socialPrefs) {
		// TODO Auto-generated method stub

	}

}
