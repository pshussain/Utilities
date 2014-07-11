package org.hussain.workspace.crud;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FacebookCRUD {
	public List<String> create() throws UnsupportedEncodingException, Exception;

	public void update() throws Exception;

	public void delete();

	public void read();

}
