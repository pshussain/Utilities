package org.hussain.workspace.builders.facebook;

public interface AccountBuilder {
	public void addAccount(String name, String currency, Integer timezoneId);

	public void updateCreditLine(String accountId, String accountPayableEmail);

	public void updateSpendCap(String accountId, Integer spendCap);

	public void updateSpendCapAction(String accountId, String action);

	public void updateAccountName(String accountId, String name);

	public void updateAgencyClientDeclaration(String accountId, Object name);

	public void updateEndAdvertiser(String accountId, Long pageOrAppId);

	public void updateMediaAgency(String accountId, Long pageOrAppId);

	public void updatePartner(String accountId, Long pageOrAppId);

	public void update(String accountId, String key, String value);

	public void fetch(String accountId);

	public void fetch(String accountId, String fields);

}
