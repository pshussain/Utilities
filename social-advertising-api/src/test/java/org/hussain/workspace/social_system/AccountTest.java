package org.hussain.workspace.social_system;

import java.io.UnsupportedEncodingException;

import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	@Test
	// To Create A New Audience
	public void createAccount() throws UnsupportedEncodingException, Exception {

		String name = "NEW CUSTOM AUDIENCE";
		String description = "This is a testing a create Audience";
		String optOutLink = "http://komli.com";

		FacebookAdaccountBuilder fbAccount = SocialEntity
				.facebookAccount(accessToken);
		fbAccount.addAccount("New Test Account", "USD", 1);
		fbAccount.create();
		// Assert.assertNotNull(res);
		// System.out.println("audience id " + res);
	}
}
