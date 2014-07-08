package org.hussain.kafka.producer;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.hussain.kafka.MessageQueue;

/**
 * This class is used to send a message to kafka via zookeeper
 * 
 * @author Hussain
 * 
 */
public class KafkaProducer {
	private static final Logger LOG = Logger.getLogger(KafkaProducer.class);
	private final MessageQueue queue;
	private Configuration config;

	/**
	 * Constructor to initiate the kafka queue with given topic
	 * 
	 * @param conf
	 * @param topic
	 */
	public KafkaProducer(String conf, String topic) {
		try {
			config = new PropertiesConfiguration(conf);

		} catch (Exception e) {
			System.out.println("Error in Social Producer : " + e.toString());
		}
		final String topicName = config.getString(topic);
		this.queue = new MessageQueue();
		this.queue.init(conf);
		this.queue.setTopic(topicName);

	}

	/**
	 * To send message to kafka
	 * 
	 * @param message
	 * @return
	 */
	public boolean produce(String message) {
		if (message != null && !message.equals(""))
			return this.queue.push(message);
		else
			return false;
	}

	/**
	 * To close the queue
	 */
	public void close() {
		this.queue.close();
	}

}
