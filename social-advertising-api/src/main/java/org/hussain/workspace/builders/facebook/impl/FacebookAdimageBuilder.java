package org.hussain.workspace.builders.facebook.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.ImageBuilder;
import org.hussain.workspace.builders.facebook.bean.AdImage;
import org.hussain.workspace.crud.FacebookCRUD;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdimageBuilder implements FacebookCRUD, ImageBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addImageBatch;
	private JsonArray updateImageBatch;
	private JsonArray readImageBatch;
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

	public List<AdImage> read() {
		return null;
		// TODO Auto-generated method stub

	}

	public void addImage(String accountId, String fileName, String path) {
		// TODO Auto-generated method stub

	}

	public void fetch(String accountId) {
		final JsonObject adgroup = new JsonObject();
		adgroup.addProperty("method", "GET");
		adgroup.addProperty("relative_url", "act_" + accountId
				+ "/adimages?include_headers=false");
		readImageBatch.add(adgroup);
	}

	public void fetch(String accountId, String fields) {
		final JsonObject adimage = new JsonObject();
		adimage.addProperty("method", "GET");
		adimage.addProperty("relative_url", "act_" + accountId
				+ "/adimages?hashes=" + fields + "&include_headers=false");
		readImageBatch.add(adimage);
	}

}
