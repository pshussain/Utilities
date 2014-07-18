package org.hussain.workspace.builders.facebook;

import org.hussain.workspace.builders.facebook.enums.Pixel;

public interface ConversionPixelBuilder {

	public void addOffsitePixel(String accountId, String name, Pixel tag);

	public void update(String accountId, String key, String value);

	public void getPixelCode(String pixelId);

	public void fetch(String accountId, String fields);

	public void fetch(String accountId);

	public void removeOffisitePixel(String pixelId);

	public void removeAccount(String pixelId, String accountId);

	public void authorize(String pixelId, String accountId);

}
