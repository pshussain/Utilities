package org.hussain.workspace.builders.facebook.enums;

public enum Pixel {
	CHECKOUT("CHECKOUT"), REGISTRATION("REGISTRATION"), LEAD("LEAD"), KEY_PAGE_VIEW(
			"KEY_PAGE_VIEW"), ADD_TO_CART("ADD_TO_CART"), OTHER("OTHER");

	private String tag;

	Pixel(String tag) {
		this.tag = tag;
	}

	public String getPixelTag() {
		return tag;
	}
}
