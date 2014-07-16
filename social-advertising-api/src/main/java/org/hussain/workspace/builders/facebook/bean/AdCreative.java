package org.hussain.workspace.builders.facebook.bean;

import com.google.gson.JsonObject;

public class AdCreative {
	private String id;
	private String object_type;
	private Integer actor_id;
	private String actor_image_hash;
	private String actor_name;
	private String body;
	private String call_to_action_type;
	private boolean follow_redirect;
	private JsonObject image_crops;
	private String image_file;
	private String image_hash;
	private String image_url;
	private String link_deep_link_url;
	private String link_url;
	private String name;
	private Integer object_id;
	private String object_store_url;
	private String object_story_id;
	private JsonObject object_story_spec;
	private String object_url;
	private String title;
	private String url_tags;
	private String video_id;

	public Integer getActor_id() {
		return actor_id;
	}

	public void setActor_id(Integer actor_id) {
		this.actor_id = actor_id;
	}

	public String getActor_image_hash() {
		return actor_image_hash;
	}

	public void setActor_image_hash(String actor_image_hash) {
		this.actor_image_hash = actor_image_hash;
	}

	public String getActor_name() {
		return actor_name;
	}

	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCall_to_action_type() {
		return call_to_action_type;
	}

	public void setCall_to_action_type(String call_to_action_type) {
		this.call_to_action_type = call_to_action_type;
	}

	public boolean isFollow_redirect() {
		return follow_redirect;
	}

	public void setFollow_redirect(boolean follow_redirect) {
		this.follow_redirect = follow_redirect;
	}

	public JsonObject getImage_crops() {
		return image_crops;
	}

	public void setImage_crops(JsonObject image_crops) {
		this.image_crops = image_crops;
	}

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}

	public String getImage_hash() {
		return image_hash;
	}

	public void setImage_hash(String image_hash) {
		this.image_hash = image_hash;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getLink_deep_link_url() {
		return link_deep_link_url;
	}

	public void setLink_deep_link_url(String link_deep_link_url) {
		this.link_deep_link_url = link_deep_link_url;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getObject_id() {
		return object_id;
	}

	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}

	public String getObject_store_url() {
		return object_store_url;
	}

	public void setObject_store_url(String object_store_url) {
		this.object_store_url = object_store_url;
	}

	public String getObject_story_id() {
		return object_story_id;
	}

	public void setObject_story_id(String object_story_id) {
		this.object_story_id = object_story_id;
	}

	public JsonObject getObject_story_spec() {
		return object_story_spec;
	}

	public void setObject_story_spec(JsonObject object_story_spec) {
		this.object_story_spec = object_story_spec;
	}

	public String getObject_url() {
		return object_url;
	}

	public void setObject_url(String object_url) {
		this.object_url = object_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl_tags() {
		return url_tags;
	}

	public void setUrl_tags(String url_tags) {
		this.url_tags = url_tags;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}
}
