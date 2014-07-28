package org.hussain.workspace.builders.facebook;

import java.util.List;

import org.hussain.workspace.builders.facebook.bean.AdImage;
import org.hussain.workspace.builders.facebook.bean.AdImageContainer;

public interface ImageBuilder {
	public void addImage(String accountId, String path);

	public void fetch(String accountId);

	public void fetch(String accountId, List<String> hashes);

	public AdImageContainer readByAccount(String accountId) throws Exception;

	public AdImageContainer readByAccount(String accountId, List<String> fields)
			throws Exception;

	public AdImageContainer readByAccount(String accountId,
			List<String> fields, String after) throws Exception;

	public List<AdImage> readByHash(String accountId, List<String> hashes);

	public List<AdImage> readByHash(String accountId, List<String> hashes,
			List<String> fields);

	public List<AdImage> readByHash(String accountId, List<String> hashes,
			List<String> fields, String after);
}
