package org.hussain.workspace.builders.facebook.enums;

public enum Role {
	ADMIN(1001), ADVERTISER(1002), ANALYST(1003);

	private Integer role;

	Role(Integer role) {
		this.role = role;
	}

	public Integer getRole() {
		return role;
	}
}
