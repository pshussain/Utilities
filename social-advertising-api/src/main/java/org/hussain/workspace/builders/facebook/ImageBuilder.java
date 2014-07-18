package org.hussain.workspace.builders.facebook;

import java.util.List;

public interface ImageBuilder {
	public void addImage(String accountId, String path);

	public void fetch(String accountId);

	public void fetch(String accountId, List<String> hashes);
}
