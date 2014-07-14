package org.hussain.workspace.social_system;

import java.io.UnsupportedEncodingException;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Test;

public class AccountTest {
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	// @Test
	// To Create A New Audience
	public void createAccount() throws UnsupportedEncodingException, Exception {

		FacebookAdaccountBuilder fbAccount = SocialEntity
				.facebookAccount(accessToken);
		fbAccount.addAccount("New Test AdAccount", "USD", 1);
		fbAccount.create();

	}

	// To update multiple accounts
	// @Test
	public void updateAccount() throws Exception {

		FacebookAdaccountBuilder fbAccount = SocialEntity
				.facebookAccount(accessToken);
		fbAccount.addAccount("New Test AdAccount", "USD", 1);
		// fbAccount.create();

		fbAccount.updateAccountName("275668082617836",
				"Update Test New AdAccount");
		fbAccount.updateAccountName("1419302888335966",
				"Batch AdAccount Name Update");
		System.out.println(fbAccount.update());
	}

	// To read multiple accounts
	@Test
	public void readAccount() throws Exception {

		FacebookAdaccountBuilder fbAccount = SocialEntity
				.facebookAccount(accessToken);
		fbAccount.addAccount("New Test AdAccount", "USD", 1);
		// fbAccount.create();

		fbAccount.fetch("275668082617836", "name,timezone_name,users");
//		fbAccount.fetch("578846975538588");
		for (AdAccount account : fbAccount.read()) {
			System.out.println(account.getAccountId());
			System.out.println(account.getTimezone_name());
			System.out.println(account.getName());
			System.out.println(account.getUsers().get(0).getRole());
		}
	}
}
