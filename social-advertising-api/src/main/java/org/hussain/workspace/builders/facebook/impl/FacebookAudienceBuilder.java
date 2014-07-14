package org.hussain.workspace.builders.facebook.impl;

import java.util.List;

import org.hussain.workspace.builders.facebook.AudienceBuilder;
import org.hussain.workspace.builders.facebook.bean.Audience;
import org.hussain.workspace.crud.FacebookCRUD;

public class FacebookAudienceBuilder implements FacebookCRUD, AudienceBuilder {

	public List<String> create() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Boolean> update() {
		return null;
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public List<Audience> read() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(String name, String currency, Integer timezoneId) {
		// TODO Auto-generated method stub

	}

	public void updateAudience(String accountId, String accountPayableEmail) {
		// TODO Auto-generated method stub

	}

	public void read(String accountId) {
		// TODO Auto-generated method stub

	}

	public void read(String accountId, String fields) {
		// TODO Auto-generated method stub

	}

}
