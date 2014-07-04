package org.hussain.workspace.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

public class FacebookHandler {
	/**
	 * doGet method to execute the GET request
	 * 
	 * @throws Exception
	 */
	public String doGet(String url) throws Exception {
		final HttpGet get = new HttpGet();
		get.setURI(new URI(url));
		final CloseableHttpResponse response = ConnectionFactory.getInstance()
				.getHttpClient().execute(get);
		try {
			final HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity);
		} finally {
			response.close();
		}

	}

	/**
	 * doPost method to execute the POST request
	 * 
	 * @throws Exception
	 */
	public String doPost(String baseURL, HttpEntity entity) throws Exception {
		final HttpPost post = new HttpPost();
		post.setURI(new URI(baseURL));
		post.setEntity(entity);

		final CloseableHttpResponse response = ConnectionFactory.getInstance()
				.getHttpClient().execute(post);
		try {
			final HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity);
		} finally {
			response.close();
		}
	}

	/**
	 * doDelete method to execute the DELETE request
	 * 
	 * @param url
	 * @param isRemote
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String doDelete(String url, boolean isRemote, HttpParams params)
			throws Exception {
		final HttpDelete delete = new HttpDelete();
		delete.setURI(new URI(url));
		if (params != null) {
			delete.setParams(params);

		}
		final CloseableHttpResponse response = ConnectionFactory.getInstance()
				.getHttpClient().execute(delete, new BasicHttpContext());
		try {
			final HttpEntity httpEntity = response.getEntity();

			return EntityUtils.toString(httpEntity);
		} finally {
			response.close();
		}

	}

}
