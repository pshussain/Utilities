package org.hussain.workspace.crud;

import java.io.UnsupportedEncodingException;

public interface FacebookCRUD {
	public String create() throws UnsupportedEncodingException, Exception;

	public void update();

	public void delete();

	public void read();

}
