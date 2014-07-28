package org.hussain.workspace.builders.facebook.bean;

import java.util.ArrayList;
import java.util.List;

public class AdImageContainer {
	public AdImageContainer() {
		adImages = new ArrayList<AdImage>();
	}

	private List<AdImage> adImages;

	public List<AdImage> getAdImages() {
		return adImages;
	}

	@Override
	public String toString() {
		return "AdImageContainer [adImages=" + adImages + ", after=" + after
				+ ", before=" + before + "]";
	}

	public void setAdImage(List<AdImage> adImages) {
		this.adImages = adImages;
	}

	public void addImage(AdImage image) {
		adImages.add(image);
	}

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	private String after;
	private String before;
}
