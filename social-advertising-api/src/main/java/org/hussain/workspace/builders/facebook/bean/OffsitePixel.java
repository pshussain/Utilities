package org.hussain.workspace.builders.facebook.bean;

public class OffsitePixel {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJs_pixel() {
		return js_pixel;
	}

	public void setJs_pixel(String js_pixel) {
		this.js_pixel = js_pixel;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	private String id;

	@Override
	public String toString() {
		return "OffsitePixel [id=" + id + ", name=" + name + ", tag=" + tag
				+ ", value=" + value + ", status=" + status + ", js_pixel="
				+ js_pixel + ", creator=" + creator + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name;
	private String tag;
	private Integer value;
	private String status;
	private String js_pixel;
	private String creator;
}
