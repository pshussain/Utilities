package org.hussain.workspace.builders.facebook.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.content.FileBody;
import org.hussain.workspace.builders.facebook.ImageBuilder;
import org.hussain.workspace.builders.facebook.bean.AdImage;
import org.hussain.workspace.builders.facebook.bean.AdImageContainer;
import org.hussain.workspace.builders.facebook.bean.AdSet;
import org.hussain.workspace.builders.facebook.bean.OffsitePixel;
import org.hussain.workspace.crud.FacebookCRUD;
import org.hussain.workspace.http.HttpHandler;
import org.hussain.workspace.utils.Constants;
import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class FacebookAdimageBuilder implements FacebookCRUD, ImageBuilder {
	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addImageBatch;
	private JsonArray updateImageBatch;
	private JsonArray readImageBatch;
	private String accessToken;
	private Map<String, FileBody> adimageMap;

	public HashMap<String, String> create() throws Exception {
		List<String> adimageList = new ArrayList<String>();
		System.out.println(adimageMap);
		final HttpEntity entity = FacebookUtil.buildMultipartBatch(adimageMap,
				addImageBatch, this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);
		System.out.println(response);
		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		HashMap<String, String> imageMap = new HashMap<String, String>();
		for (JsonObject adimage : responseList) {
			if (FacebookUtil.iSuccess(adimage)) {
				getAdimageHash(adimage, imageMap);
			}
		}
		return imageMap;
	}

	public HashMap<String, String> uploadImage(String accountId, String filePath)
			throws Exception {
		String url = Constants.baseURL + "/act_" + accountId + "/adimages";
		HashMap<String, String> adImageMap = new HashMap<String, String>();
		final String response = HttpHandler.doPost(url, FacebookUtil
				.buildMultipart(FacebookUtil.getFileName(filePath),
						new FileBody(new File(filePath)), this.accessToken,
						true));
		JsonObject image = FacebookUtil.toJson(response);
		if (image.has("error")) {
			JsonObject message = image.get("error").getAsJsonObject();
			adImageMap.put("error", message.get("message").getAsString());

		} else {

			/**
			 * {"CTC6.png":{"hash":"d9c90e0e65b3219f156d759589344c95","url":
			 * "https://fbcdn-creative-a.akamaihd.net/hads-ak-xpa1/t45.1600-4/10150500_6016957318326_260373045_n.png"
			 * }}
			 */
			for (Entry<String, JsonElement> entry : image.entrySet()) {
				String key = entry.getKey();
				JsonObject imageSet = entry.getValue().getAsJsonObject();
				for (Entry<String, JsonElement> entryInner : imageSet
						.entrySet()) {
					JsonObject imageHash = entryInner.getValue()
							.getAsJsonObject();
					adImageMap.put(imageHash.get("hash").getAsString(),
							imageHash.get("url").getAsString());
				}

			}
		}
		return adImageMap;
	}

	/**
	 * [{"code":200,"headers":[{"name":"Connection","value":"close"},{"name":
	 * "Expires"
	 * ,"value":"Sat, 01 Jan 2000 00:00:00 GMT"},{"name":"Cache-Control"
	 * ,"value":"private, no-cache, no-store, must-revalidate"},{"name":
	 * "Access-Control-Allow-Origin"
	 * ,"value":"*"},{"name":"Pragma","value":"no-cache"
	 * },{"name":"Content-Type","value":"text\/javascript;
	 * charset=UTF-8"},{"name
	 * ":"Facebook-API-Version","value":"v1.0"}],"body":"{\
	 * "images\":{\"CTC6.png\":{\"hash\":\"d9c90e0e65b3219f156d759589344c95\",\"url\":\"https:\\\/\\\/fbcdn-creative-a.akamaihd.net\\\/hads
	 * - a k - x f a 1 \ \ \ / t 4 5 . 1 6 0 0 - 4 \ \ \ / 1 0 5 5 0 7 8 0 _ 6 0
	 * 1 7 8 2 5 1 0 7 8 8 4 _ 1 0 9 3 3 0 9 4 8 5 _ n . p n g \ " } } } " } ]
	 * 
	 * @param adimage
	 * @param imageMap
	 */
	private void getAdimageHash(JsonObject adimage,
			HashMap<String, String> imageMap) {
		final String body = adimage.get("body").getAsString();
		final JsonObject bodyJSON = FacebookUtil.toJson(body);
		if (body != null) {
			JsonObject imageObj = bodyJSON.get("images").getAsJsonObject();
			for (Entry<String, JsonElement> entry : imageObj.entrySet()) {
				String key = entry.getKey();
				JsonObject imageHash = entry.getValue().getAsJsonObject();
				imageMap.put(imageHash.get("hash").getAsString(), imageHash
						.get("url").getAsString());
			}
		}
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

	public List<AdImage> read() throws UnsupportedEncodingException, Exception {
		List<AdImage> adimageList = new ArrayList<AdImage>();
		final HttpEntity entity = FacebookUtil.buildBatch(readImageBatch,
				this.accessToken, false);
		final String response = HttpHandler.doPost(Constants.baseURL, entity);

		final List<JsonObject> responseList = FacebookUtil
				.getResponseAsList(response);
		for (JsonObject adimage : responseList) {
			if (FacebookUtil.iSuccess(adimage)) {
				AdImage adimageInfo = makeAdimage(FacebookUtil.toJson(adimage
						.toString()));
				adimageList.add(adimageInfo);
			}
		}
		return adimageList;

	}

	private AdImage makeAdimage(JsonObject json) {
		String body = json.get("body").getAsString();
		AdImage adimageBean = (AdImage) FacebookUtil.fromJson(
				FacebookUtil.toJson(body), AdImage.class);
		return adimageBean;
	}

	private AdImage makeAdimage(String data) {
		AdImage adimageBean = (AdImage) FacebookUtil.fromJson(
				FacebookUtil.toJson(data), AdImage.class);
		return adimageBean;
	}

	/**
	 * To add adimage in the batch.
	 */
	public void addImage(String accountId, String path) {

		final JsonObject account = new JsonObject();
		account.addProperty("method", "POST");
		// final StringBuilder body = new StringBuilder(100);
		account.addProperty("relative_url", "act_" + accountId + "/adimages");
		account.addProperty("attached_files", FacebookUtil
				.getFileNameWithoutDot(FacebookUtil.getFileName(path)));
		final FileBody image = new FileBody(new File(path));
		adimageMap.put(FacebookUtil.getFileNameWithoutDot(FacebookUtil
				.getFileName(path)), image);
		addImageBatch.add(account);
		System.out.println(account);
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

	public void fetch(String accountId, List<String> hashes) {
		final JsonObject adimage = new JsonObject();
		adimage.addProperty("method", "GET");
		adimage.addProperty("relative_url", "act_" + accountId
				+ "/adimages?hashes=" + hashes + "&include_headers=false");
		readImageBatch.add(adimage);
	}

	public AdImageContainer readByAccount(String accountId) throws Exception {
		// final JsonObject adgroup = new JsonObject();
		// String url = "https://graph.facebook.com/act_" + accountId
		// + "/adimages?";
		// final String response = HttpHandler.doGet(url + "&access_token="
		// + accessToken);
		// JsonObject adImageJson = FacebookUtil.toJson(response);
		// JsonArray imageDataArray = adImageJson.get("data").getAsJsonArray();
		// AdImageContainer container = new AdImageContainer();
		// for (JsonElement image : imageDataArray) {
		// final AdImage imageBean = new AdImage();
		// imageBean.setId(image.getAsJsonObject().get("id").getAsString());
		// imageBean
		// .setHash(image.getAsJsonObject().get("hash").getAsString());
		// container.addImage(imageBean);
		// }
		//
		// return container;

		return readByAccount(accountId, null, null);

	}

	public AdImageContainer readByAccount(String accountId, List<String> fields)
			throws Exception {
		// final JsonObject adgroup = new JsonObject();
		// String url = "https://graph.facebook.com/act_" + accountId
		// + "/adimages?";
		// final String response = HttpHandler.doGet(url + "&access_token="
		// + accessToken);
		// JsonObject adImageJson = FacebookUtil.toJson(response);
		// JsonArray imageDataArray = adImageJson.get("data").getAsJsonArray();
		// AdImageContainer container = new AdImageContainer();
		// for (JsonElement image : imageDataArray) {
		// final AdImage imageBean = new AdImage();
		// imageBean.setId(image.getAsJsonObject().get("id").getAsString());
		// imageBean
		// .setHash(image.getAsJsonObject().get("hash").getAsString());
		// container.addImage(imageBean);
		// }
		// String after = adImageJson.get("paging").getAsJsonObject()
		// .get("cursors").getAsJsonObject().get("after").getAsString();
		// if (after != null) {
		// container.setAfter(after);
		// }
		// return container;
		return readByAccount(accountId, fields, null);
	}

	public AdImageContainer readByAccount(String accountId,
			List<String> fields, String after) throws Exception {

		final JsonObject adgroup = new JsonObject();
		final StringBuilder baseURL = new StringBuilder(
				"https://graph.facebook.com/act_" + accountId + "/adimages?");
		if (after != null) {
			baseURL.append("&after=").append(after);
		}
		if (fields != null) {
			int len = fields.size();
			int counter = 0;
			final StringBuilder fieldsBuffer = new StringBuilder();
			for (String field : fields) {
				if (counter < len - 1)
					fieldsBuffer.append(field).append(",");
				else
					fieldsBuffer.append(field);
				counter++;
				System.out.println(counter + "=" + fieldsBuffer);
			}
			baseURL.append("&fields=").append(fieldsBuffer);
			System.out.println(baseURL);
		}
		final String response = HttpHandler.doGet(baseURL + "&access_token="
				+ accessToken);
		final JsonObject adImageJson = FacebookUtil.toJson(response);
		final JsonArray imageDataArray = adImageJson.get("data")
				.getAsJsonArray();
		final AdImageContainer container = new AdImageContainer();
		for (JsonElement image : imageDataArray) {
			container.addImage((AdImage) FacebookUtil.fromJson(
					image.getAsJsonObject(), AdImage.class));
		}
		final String tempAfter = adImageJson.get("paging").getAsJsonObject()
				.get("cursors").getAsJsonObject().get("after").getAsString();
		final String tempBefore = adImageJson.get("paging").getAsJsonObject()
				.get("cursors").getAsJsonObject().get("before").getAsString();
		if (tempAfter != null) {
			container.setAfter(tempAfter);
		}

		if (tempBefore != null) {
			container.setBefore(tempBefore);
		}
		return container;
	}

	public List<AdImage> readByHash(String accountId, List<String> hashes) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdImage> readByHash(String accountId, List<String> hashes,
			List<String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdImage> readByHash(String accountId, List<String> hashes,
			List<String> fields, String after) {
		// TODO Auto-generated method stub
		return null;
	}

}
