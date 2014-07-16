package org.hussain.workspace.builders.facebook.enums;

public enum Permission {
	ACCOUNT_ADMIN("ACCOUNT_ADMIN"), ADMANAGER_READ("ADMANAGER_READ"), ADMANAGER_WRITE(
			"ADMANAGER_WRITE"), BILLING_READ("BILLING_READ"), BILLING_WRITE(
			"BILLING_WRITE"), REPORTS("REPORTS");

	private String permission;

	Permission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
