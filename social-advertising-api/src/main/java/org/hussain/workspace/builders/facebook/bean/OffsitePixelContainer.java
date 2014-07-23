package org.hussain.workspace.builders.facebook.bean;

import java.util.List;

public class OffsitePixelContainer {
	private List<OffsitePixel> pixels;

	public List<OffsitePixel> getPixels() {
		return pixels;
	}

	public void setPixels(List<OffsitePixel> pixels) {
		this.pixels = pixels;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	private String next;
	private String previous;
}
