package org.hussain.workspace.builders.facebook.bean;

import java.util.List;

import com.google.gson.JsonArray;

public class AdAccount {

	private String id;
	private String account_id;
	private String account_groups;
	private String name;
	private Integer account_status;
	private Integer age;
	private Object agency_client_declaration;
	private Integer amount_spent;
	private Integer balance;
	private String business_city;
	private String business_country_name;
	private String business_name;
	private String business_stats;
	private String business_street2;
	private String business_street;
	private String business_zip;
	private Long end_advertiser;
	private Long media_agency;
	private Long partner;
	private JsonArray capabilities;
	private String currency;
	private Integer daily_spend_limit;
	private Integer is_personal;
	private boolean offsite_pixels_tos_accepted;
	private Integer spend_cap;
	private String funding_source;
	private JsonArray funding_source_details;
	private Integer timezone_id;
	private String timezone_name;
	private Integer timezone_offset_hours_etc;
	private JsonArray tos_accepted;
	private List<User> users;
	private Integer tax_id_status;

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getAccount_groups() {
		return account_groups;
	}

	public void setAccount_groups(String account_groups) {
		this.account_groups = account_groups;
	}

	public Integer getAccount_status() {
		return account_status;
	}

	public void setAccount_status(Integer account_status) {
		this.account_status = account_status;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Object getAgency_client_declaration() {
		return agency_client_declaration;
	}

	public void setAgency_client_declaration(Object agency_client_declaration) {
		this.agency_client_declaration = agency_client_declaration;
	}

	public Integer getAmount_spent() {
		return amount_spent;
	}

	public void setAmount_spent(Integer amount_spent) {
		this.amount_spent = amount_spent;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getBusiness_city() {
		return business_city;
	}

	public void setBusiness_city(String business_city) {
		this.business_city = business_city;
	}

	public String getBusiness_country_name() {
		return business_country_name;
	}

	public void setBusiness_country_name(String business_country_name) {
		this.business_country_name = business_country_name;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public String getBusiness_stats() {
		return business_stats;
	}

	public void setBusiness_stats(String business_stats) {
		this.business_stats = business_stats;
	}

	public String getBusiness_street2() {
		return business_street2;
	}

	public void setBusiness_street2(String business_street2) {
		this.business_street2 = business_street2;
	}

	public String getBusiness_street() {
		return business_street;
	}

	public void setBusiness_street(String business_street) {
		this.business_street = business_street;
	}

	public String getBusiness_zip() {
		return business_zip;
	}

	public void setBusiness_zip(String business_zip) {
		this.business_zip = business_zip;
	}

	public Long getEnd_advertiser() {
		return end_advertiser;
	}

	public void setEnd_advertiser(Long end_advertiser) {
		this.end_advertiser = end_advertiser;
	}

	public Long getMedia_agency() {
		return media_agency;
	}

	public void setMedia_agency(Long media_agency) {
		this.media_agency = media_agency;
	}

	public Long getPartner() {
		return partner;
	}

	public void setPartner(Long partner) {
		this.partner = partner;
	}

	public JsonArray getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(JsonArray capabilities) {
		this.capabilities = capabilities;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getDaily_spend_limit() {
		return daily_spend_limit;
	}

	public void setDaily_spend_limit(Integer daily_spend_limit) {
		this.daily_spend_limit = daily_spend_limit;
	}

	public Integer getIs_personal() {
		return is_personal;
	}

	public void setIs_personal(Integer is_personal) {
		this.is_personal = is_personal;
	}

	public boolean isOffsite_pixels_tos_accepted() {
		return offsite_pixels_tos_accepted;
	}

	public void setOffsite_pixels_tos_accepted(
			boolean offsite_pixels_tos_accepted) {
		this.offsite_pixels_tos_accepted = offsite_pixels_tos_accepted;
	}

	public Integer getSpend_cap() {
		return spend_cap;
	}

	public void setSpend_cap(Integer spend_cap) {
		this.spend_cap = spend_cap;
	}

	public String getFunding_source() {
		return funding_source;
	}

	public void setFunding_source(String funding_source) {
		this.funding_source = funding_source;
	}

	public JsonArray getFunding_source_details() {
		return funding_source_details;
	}

	public void setFunding_source_details(JsonArray funding_source_details) {
		this.funding_source_details = funding_source_details;
	}

	public Integer getTimezone_id() {
		return timezone_id;
	}

	public void setTimezone_id(Integer timezone_id) {
		this.timezone_id = timezone_id;
	}

	public String getTimezone_name() {
		return timezone_name;
	}

	public void setTimezone_name(String timezone_name) {
		this.timezone_name = timezone_name;
	}

	public Integer getTimezone_offset_hours_etc() {
		return timezone_offset_hours_etc;
	}

	public void setTimezone_offset_hours_etc(Integer timezone_offset_hours_etc) {
		this.timezone_offset_hours_etc = timezone_offset_hours_etc;
	}

	public JsonArray getTos_accepted() {
		return tos_accepted;
	}

	public void setTos_accepted(JsonArray tos_accepted) {
		this.tos_accepted = tos_accepted;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getTax_id_status() {
		return tax_id_status;
	}

	public void setTax_id_status(Integer tax_id_status) {
		this.tax_id_status = tax_id_status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return account_id;
	}

	public void setAccountId(String account_id) {
		this.account_id = account_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public class User {
		public Long getUid() {
			return uid;
		}

		public void setUid(Long uid) {
			this.uid = uid;
		}

		public JsonArray getPermissions() {
			return permissions;
		}

		public void setPermissions(JsonArray permissions) {
			this.permissions = permissions;
		}

		public Long getRole() {
			return role;
		}

		public void setRole(Long role) {
			this.role = role;
		}

		private Long uid;
		private JsonArray permissions;
		private Long role;
	}
}
