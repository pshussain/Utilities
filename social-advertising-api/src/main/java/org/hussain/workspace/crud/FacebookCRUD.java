package org.hussain.workspace.crud;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.AdCampaign;

public interface FacebookCRUD {
	public <T> T create() throws UnsupportedEncodingException, Exception;

	public List<Boolean> update() throws Exception;

	public void delete();

	public <T> T read() throws UnsupportedEncodingException, Exception;

}
