package org.hussain.workspace.social_system;

import java.io.UnsupportedEncodingException;

import org.hussain.workspace.builders.facebook.impl.FacebookAdcreativeBuilder;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Test;

public class CreativeBuilderTest {
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	@Test
	public void createCreative() throws UnsupportedEncodingException, Exception {
		FacebookAdcreativeBuilder builder = SocialEntity
				.facebookCreative(accessToken);
		System.out.println(builder.create());

	}
}
