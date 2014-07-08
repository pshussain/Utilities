package org.hussain.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.javaapi.producer.ProducerData;
import kafka.producer.ProducerConfig;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.hussain.kafka.producer.KafkaProducer;

/**
 * The MessageQueue class used to produce the message in kafka
 * 
 * @author Hussain
 * 
 */
public class MessageQueue implements Queue {
	private static final Logger LOG = Logger.getLogger(KafkaProducer.class);
	private static String PROP_SER_CLASS = "serializer.class";
	private static String PROP_ZK_CONNECT = "zk.connect";
	private static String PROP_GROUPID = "groupid";
	private static String PROP_COMPRESSION = "compression.codec";
	private Producer<String, String> producer;
	private final Properties props = new Properties();
	private String compressionCodec;
	private String topic;

	/**
	 * Its a constructor to initialize the zookeeper to send message
	 */
	public void init(Configuration kafkaConfiguration) {
		try {
			String serializerClass = kafkaConfiguration
					.getString(PROP_SER_CLASS);
			String zkConnect = kafkaConfiguration.getString(PROP_ZK_CONNECT);
			String groupId = kafkaConfiguration.getString(PROP_GROUPID);

			compressionCodec = kafkaConfiguration.getString(PROP_COMPRESSION,
					"0");
			props.put(PROP_SER_CLASS, serializerClass);
			props.put(PROP_ZK_CONNECT, zkConnect);
			props.put(PROP_GROUPID, groupId);
			props.put(PROP_COMPRESSION, compressionCodec);
			producer = new kafka.javaapi.producer.Producer<String, String>(
					new ProducerConfig(props));
		} catch (Exception e) {
			LOG.error("Init Exception has occurred" + e.getMessage());
		}
	}

	public void init(String file) {
		try {
			final Configuration kafkaConfiguration = new PropertiesConfiguration(
					file);
			final String serializerClass = kafkaConfiguration
					.getString(PROP_SER_CLASS);
			final String zkConnect = kafkaConfiguration
					.getString(PROP_ZK_CONNECT);
			final String groupId = kafkaConfiguration.getString(PROP_GROUPID);

			compressionCodec = kafkaConfiguration.getString(PROP_COMPRESSION,
					"0");
			props.put(PROP_SER_CLASS, serializerClass);
			props.put(PROP_ZK_CONNECT, zkConnect);
			props.put(PROP_GROUPID, groupId);
			props.put(PROP_COMPRESSION, compressionCodec);
			producer = new kafka.javaapi.producer.Producer<String, String>(
					new ProducerConfig(props));
		} catch (Exception e) {
			LOG.error("Init Exception has occurred" + e.getMessage());
		}
	}

	/**
	 * To set topic
	 * 
	 * @param topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * To send message to a given topic
	 */
	public boolean push(String message, String topicName) {
		try {
			final String messageStr = new String(message);
			if (producer == null) {
				producer = new kafka.javaapi.producer.Producer<String, String>(
						new ProducerConfig(props));
			}
			producer.send(new ProducerData<String, String>(topicName,
					messageStr));
			return true;
		} catch (Exception e) {
			LOG.error("Could not able to send the message to kafka : "
					+ e.toString());
			return false;
		}
	}

	/**
	 * To send a message to already defined topic
	 * 
	 * @param message
	 * @return
	 */
	public boolean push(String message) {
		try {
			// System.out.println(message + " : Message in PUSH Method");
			final String messageStr = new String(message);
			if (producer == null) {
				producer = new kafka.javaapi.producer.Producer<String, String>(
						new ProducerConfig(props));
			}

			producer.send(new ProducerData<String, String>(this.topic,
					messageStr));

			return true;
		} catch (Exception e) {
			LOG.error("Could not able to send the message to kafka : "
					+ e.toString());
			System.out.println("Could not able to send the message to kafka : "
					+ e.toString());
			return false;
		}
	}

	/**
	 * To close the connection
	 */
	public void close() {
		producer.close();
	}
}
