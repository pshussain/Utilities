package org.hussain.async.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class  EthSettings {

	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	static String ethIp, formatedEthIp;
	static String[] ethIps = new String[3];
	static final Pattern DOTREPLACE_PATTERN = Pattern.compile("\\.");

	public static final String[] getFormattedEthIp(String ethSettings) {
		NetworkInterface interfaceIp = null;

		try {
			interfaceIp = NetworkInterface.getByName(ethSettings);

			if (interfaceIp == null) {
				ethIp = "127.0.0.1";
			} else {
				final Enumeration<InetAddress> e = interfaceIp
						.getInetAddresses();
				InetAddress inet = null;
				inet = (InetAddress) e.nextElement();
				final String gotIp = inet.getHostAddress();
				final Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
				final Matcher matcher = pattern.matcher(gotIp);
				if (matcher.matches()) {
					ethIp = gotIp;
				} else if (e.hasMoreElements()) {
					inet = (InetAddress) e.nextElement();
					ethIp = inet.getHostAddress();
				} else {
					ethIp = "127.0.0.1";
				}
			}
		} catch (SocketException e1) {
			ethIp = "127.0.0.1";
			e1.printStackTrace();
		}

		formatedEthIp = ethIp.replaceAll(DOTREPLACE_PATTERN.pattern(), "");
		ethIps[0] = ethIp;
		ethIps[1] = formatedEthIp;
		return ethIps;
	}
}