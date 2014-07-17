package org.hussain.workspace.builders.facebook.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.content.FileBody;
import org.hussain.workspace.builders.facebook.ImageBuilder;
import org.hussain.workspace.builders.facebook.bean.AdImage;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FacebookAdimageBuilder implements FacebookCRUD, ImageBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addImageBatch;
	private JsonArray updateImageBatch;
	private JsonArray readImageBatch;
	private String accessToken;
	private Map<String, FileBody> adimageMap;

	public List<String> create() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not Used for AdImage Entity
	 */
	public List<Boolean> update() {
		return null;

	}

	public FacebookAdimageBuilder(String accessToken) {

		this.addImageBatch = new JsonArray();
		this.updateImageBatch = new JsonArray();
		this.readImageBatch = new JsonArray();
		this.accessToken = accessToken;
		this.adimageMap = new HashMap<String, FileBody>();
	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public List<AdImage> read() {
		return null;
		// TODO Auto-generated method stub

	}

	/**
	 * To add adimage in the batch.
	 */
	public void addImage(String accountId, String path) {

		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		final StringBuilder body = new StringBuilder(100);
		account.addProperty("relative_url", "act_" + accountId + "/adimages");
		FacebookUtil.buildBody(body, "attached_files",
				FacebookUtil.getFileNameWithoutDot(path), Constants.AMP);
		FacebookUtil.buildBody(body, "include_headers", false, Constants.AMP);
		FacebookUtil.buildBody(body, "redownload", true);
		uploadImage(path);
		account.addProperty("body", body.toString());
		addImageBatch.add(account);
	}

	/**
	 * To create FileBody Object to upload an image.
	 * 
	 * @param path
	 */
	private void uploadImage(String path) {
		final FileBody image = new FileBody(new File(path));
		adimageMap.put(FacebookUtil.getFileName(path), image);
	}
	/**
	 * 
	 */
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
