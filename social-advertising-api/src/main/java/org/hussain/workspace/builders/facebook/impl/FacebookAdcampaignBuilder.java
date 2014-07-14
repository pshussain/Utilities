package org.hussain.workspace.builders.facebook.impl;

import java.util.List;

import org.hussain.workspace.builders.facebook.CampaignBuilder;
import org.hussain.workspace.builders.facebook.bean.AdCampaign;
import org.hussain.workspace.crud.FacebookCRUD;

import com.google.gson.JsonArray;

public class FacebookAdcampaignBuilder implements FacebookCRUD, CampaignBuilder {
	JsonArray campaignArray;

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

	public List<AdCampaign> read() {
		return null;
		// TODO Auto-generated method stub

	}

	public void addCampaign(String accountId, String name, String objective,
			String campaignGroupStatus, String buyingType) {
		// TODO Auto-generated method stub

	}

	public void updateName(String name) {
		// TODO Auto-generated method stub

	}

	public void updateObjective(String objective) {
		// TODO Auto-generated method stub

	}

	public void updateStatus(String status) {
		// TODO Auto-generated method stub

	}

}
