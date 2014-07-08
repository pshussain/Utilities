package com.komli.social.producer;

import static org.junit.Assert.assertTrue;

import org.hussain.kafka.producer.KafkaProducer;
import org.junit.Test;

/**
 * Unit test for simple KafkaProducer.
 */
public class AppTest {
	private KafkaProducer adx = new KafkaProducer(
			"src/main/resources/producer.properties", "topic.adx");
	private KafkaProducer account = new KafkaProducer(
			"src/main/resources/producer.properties", "topic.adaccount");
	private KafkaProducer vertica = new KafkaProducer(
			"src/main/resources/producer.properties", "topic.vertica");

	/**
	 * Rigourous Test :-)
	 * @throws InterruptedException 
	 */
	@Test
	public void testApp() throws InterruptedException {

		boolean adxResult = adx.produce("Hussain");
		System.out.println(adxResult);
		assertTrue(adxResult);

		boolean accountResult = account.produce("Hussain");
		System.out.println(accountResult);
		assertTrue(accountResult);

		boolean verticaResult = vertica.produce("Hussain");
		System.out.println(verticaResult);
		assertTrue(verticaResult);
		
		
	}
}
