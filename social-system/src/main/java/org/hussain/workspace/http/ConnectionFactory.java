package org.hussain.workspace.http;

import java.io.IOException;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * To create an http connection pool and closeable http client to execute the
 * requests
 * 
 * @author Hussain
 * 
 */
public class ConnectionFactory {

	PoolingHttpClientConnectionManager connMgr;
	CloseableHttpClient httpClient;

	/**
	 * Constructor to create a http pool connection manager
	 * 
	 * @throws Exception
	 */
	private ConnectionFactory() throws Exception {
		connMgr = new PoolingHttpClientConnectionManager();
		connMgr.setMaxTotal(25);
		connMgr.setDefaultMaxPerRoute(20);
		SocketConfig defaultSocketConfig = SocketConfig.custom()
				.setTcpNoDelay(true).setSoKeepAlive(false).build();
		httpClient = HttpClients
				.custom()
				.setConnectionManager(connMgr)
				.setDefaultRequestConfig(
						RequestConfig.custom()
								.setConnectionRequestTimeout(300000).build())
				.build();
	}

	/**
	 * To return singleton connection manager object
	 * 
	 * @param confDir
	 * @param action
	 * @return
	 * @throws Exception
	 */
	public static ConnectionFactory getInstance(String confDir, String action)
			throws Exception {
		return new ConnectionFactory();
	}

	/**
	 * To return closeable http client object to execute the requests
	 * 
	 * @return
	 */
	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	/**
	 * To close the closeable http client object
	 * 
	 * @throws IOException
	 */
	public void closeClient() throws IOException {
		httpClient.close();
	}

	/**
	 * To close the connection manager pool
	 */
	public void closeConnection() {
		connMgr.close();
	}
}