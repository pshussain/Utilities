package org.hussain.kafka;

import org.apache.commons.configuration.Configuration;

public interface Queue {
	public void init(Configuration kafkaConfiguration);

	public boolean push(String message, String topic);

}
