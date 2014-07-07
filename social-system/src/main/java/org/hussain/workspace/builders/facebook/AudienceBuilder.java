package org.hussain.workspace.builders.facebook;

public interface AudienceBuilder {
	public void addUser(String name, String currency, Integer timezoneId);

	public void updateAudience(String accountId, String accountPayableEmail);

	public void read(String accountId);

	public void read(String accountId, String fields);

}