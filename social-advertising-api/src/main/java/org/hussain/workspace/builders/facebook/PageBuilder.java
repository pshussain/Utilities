package org.hussain.workspace.builders.facebook;

public interface PageBuilder {
	public void fetch(String accountId);

	public void fetch(String accountId, String fields);
}
