package org.hussain.workspace.builders.facebook;

import org.hussain.workspace.builders.facebook.enums.Role;

public interface UserBuilder {
	public void addUser(String accountId, String uid, Role role);

	public void fetch(String accountId);

	public void fetch(String accountId, String fields);
}
