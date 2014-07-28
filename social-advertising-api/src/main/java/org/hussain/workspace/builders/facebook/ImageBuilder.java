package org.hussain.workspace.builders.facebook;

import java.util.List;

import org.hussain.workspace.builders.facebook.bean.AdImageContainer;

public interface ImageBuilder {
	public void addImage(String accountId, String path);

	public AdImageContainer readByAccount(String accountId) throws Exception;

	public AdImageContainer readByAccount(String accountId, List<String> fields)
			throws Exception;

	public AdImageContainer readByAccount(String accountId,
			List<String> fields, String after) throws Exception;

	public AdImageContainer readByHash(String accountId, List<String> hashes)
			throws Exception;

	public AdImageContainer readByHash(String accountId, List<String> hashes,
			List<String> fields) throws Exception;

	public AdImageContainer readByHash(String accountId, List<String> hashes,
			List<String> fields, String after) throws Exception;
}
