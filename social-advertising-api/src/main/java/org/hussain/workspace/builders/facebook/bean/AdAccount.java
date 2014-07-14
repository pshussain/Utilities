package org.hussain.workspace.builders.facebook.bean;

public class AdAccount {
	@Override
	public String toString() {
		return "AdAccount [id=" + id + ", account_id=" + account_id + ", name="
				+ name + "]";
	}

	private String id;
	private String account_id;
	private String name;

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
}
