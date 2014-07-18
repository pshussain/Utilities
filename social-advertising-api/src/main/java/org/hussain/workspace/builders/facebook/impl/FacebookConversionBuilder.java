package org.hussain.workspace.builders.facebook.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.hussain.workspace.builders.facebook.ConversionPixelBuilder;
import org.hussain.workspace.builders.facebook.bean.OffsitePixel;
import org.hussain.workspace.builders.facebook.enums.Pixel;
import org.hussain.workspace.crud.FacebookCRUD;

import com.google.gson.JsonArray;

public class FacebookConversionBuilder implements FacebookCRUD,
		ConversionPixelBuilder {

	final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	private JsonArray addConversionPixelBatch;
	private JsonArray updateConversionPixelBatch;
	private JsonArray readConversionPixelBatch;
	private String accessToken;
	
	public void addOffsitePixel(String accountId, String name, Pixel tag) {
		// TODO Auto-generated method stub

	}

	public void update(String accountId, String key, String value) {
		// TODO Auto-generated method stub

	}

	public void getPixelCode(String pixelId) {
		// TODO Auto-generated method stub

	}

	public void fetch(String accountId, String fields) {
		// TODO Auto-generated method stub

	}

	public void fetch(String accountId) {
		// TODO Auto-generated method stub

	}

	public void removeOffisitePixel(String pixelId) {
		// TODO Auto-generated method stub

	}

	public List<String> create() throws UnsupportedEncodingException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Boolean> update() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public List<OffsitePixel> read() throws UnsupportedEncodingException,
			Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void authorize(String pixelId, String accountId) {
		// TODO Auto-generated method stub

	}

	public void removeAccount(String pixelId, String accountId) {
		// TODO Auto-generated method stub

	}

}