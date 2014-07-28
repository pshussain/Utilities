package org.hussain.workspace.builders.facebook.bean;

import java.util.List;

public class AdImage {
	private String hash;
	private String url;
	private String id;
	private String width;
	private String height;
	private String original_width;
	private String original_height;
	private List<String> creatives;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getOriginal_width() {
		return original_width;
	}

	public void setOriginal_width(String original_width) {
		this.original_width = original_width;
	}

	public String getOriginal_height() {
		return original_height;
	}

	public void setOriginal_height(String original_height) {
		this.original_height = original_height;
	}

	public List<String> getCreatives() {
		return creatives;
	}

	public void setCreatives(List<String> creatives) {
		this.creatives = creatives;
	}
}
