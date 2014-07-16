package org.hussain.workspace.builders.facebook.bean;

import java.util.List;

import com.google.gson.JsonObject;

public class AdGroup {
	private String id;
	private String account_id;
	private Object adgroup_review_feedback;
	private String adgroup_status;
	private String bid_type;
	private JsonObject bid_info;
	private String campaignId;
	private String campaign_group_id;
	private JsonObject conversion_specs;
	private long created_time;
	private List<String> creative_ids;
	private FailedDeliveryChecks failed_delivery_checks;
	private String name;
	private JsonObject targeting;
	private JsonObject tracking_specs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public Object getAdgroup_review_feedback() {
		return adgroup_review_feedback;
	}

	public void setAdgroup_review_feedback(Object adgroup_review_feedback) {
		this.adgroup_review_feedback = adgroup_review_feedback;
	}

	public String getAdgroup_status() {
		return adgroup_status;
	}

	public void setAdgroup_status(String adgroup_status) {
		this.adgroup_status = adgroup_status;
	}

	public String getBid_type() {
		return bid_type;
	}

	public void setBid_type(String bid_type) {
		this.bid_type = bid_type;
	}

	public JsonObject getBid_info() {
		return bid_info;
	}

	public void setBid_info(JsonObject bid_info) {
		this.bid_info = bid_info;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaign_group_id() {
		return campaign_group_id;
	}

	public void setCampaign_group_id(String campaign_group_id) {
		this.campaign_group_id = campaign_group_id;
	}

	public JsonObject getConversion_specs() {
		return conversion_specs;
	}

	public void setConversion_specs(JsonObject conversion_specs) {
		this.conversion_specs = conversion_specs;
	}

	public long getCreated_time() {
		return created_time;
	}

	public void setCreated_time(long created_time) {
		this.created_time = created_time;
	}

	public List<String> getCreative_ids() {
		return creative_ids;
	}

	public void setCreative_ids(List<String> creative_ids) {
		this.creative_ids = creative_ids;
	}

	public FailedDeliveryChecks getFailed_delivery_checks() {
		return failed_delivery_checks;
	}

	public void setFailed_delivery_checks(
			FailedDeliveryChecks failed_delivery_checks) {
		this.failed_delivery_checks = failed_delivery_checks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JsonObject getTargeting() {
		return targeting;
	}

	public void setTargeting(JsonObject targeting) {
		this.targeting = targeting;
	}

	public JsonObject getTracking_specs() {
		return tracking_specs;
	}

	public void setTracking_specs(JsonObject tracking_specs) {
		this.tracking_specs = tracking_specs;
	}

	public long getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(long updated_time) {
		this.updated_time = updated_time;
	}

	public List<String> getView_tags() {
		return view_tags;
	}

	public void setView_tags(List<String> view_tags) {
		this.view_tags = view_tags;
	}

	private long updated_time;
	private List<String> view_tags;

	public class FailedDeliveryChecks {
		private String summary;
		private String description;
		private String check_name;

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCheck_name() {
			return check_name;
		}

		public void setCheck_name(String check_name) {
			this.check_name = check_name;
		}

		public ExtraInfo getExtra_info() {
			return extra_info;
		}

		public void setExtra_info(ExtraInfo extra_info) {
			this.extra_info = extra_info;
		}

		private ExtraInfo extra_info;

		public class ExtraInfo {
			private List<String> adgroup_ids;

			public List<String> getAdgroup_ids() {
				return adgroup_ids;
			}

			public void setAdgroup_ids(List<String> adgroup_ids) {
				this.adgroup_ids = adgroup_ids;
			}
		}
	}
}
