package org.hussain.workspace.builders.facebook;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hussain.workspace.builders.facebook.enums.Pixel;

public interface ConversionPixelBuilder {

	public void addOffsitePixel(String accountId, String name, Pixel tag);

	public void updateName(String pixelId, String name);

	public void updateValue(String pixelId, String value);

	public void updateTag(String pixelId, Pixel tag);

	public List<Boolean> update(String pixelId, String key, String value)
			throws UnsupportedEncodingException, Exception;

	public void getPixelCode(String pixelId);

	public void fetchByPixel(String pixelId);

	public void fetchByAccount(String accountId);

	public void fetchAccount(String pixelId);

	public void removeOffisitePixel(String pixelId);

	public List<Boolean> authorize(String pixelId, String accountId)
			throws UnsupportedEncodingException, Exception;

	public List<Boolean> authorize(String pixelId, List<Long> accountIds)
			throws UnsupportedEncodingException, Exception;

}
