package org.hussain.workspace.crud;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.AdCampaign;

public interface FacebookCRUD {
	public List<String> create() throws UnsupportedEncodingException, Exception;

	public List<Boolean> update() throws Exception;

	public void delete();

	public <T> T read() throws UnsupportedEncodingException, Exception;

}
