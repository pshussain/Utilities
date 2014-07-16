package org.hussain.workspace.builders.facebook;

public interface ImageBuilder {
	public void addImage(String accountId, String fileName, String path);

	public void fetch(String accountId);

	public void fetch(String accountId, String fields);
}
