package org.hussain.async.sample;

import java.util.Random;

import org.hussain.async.event.JobMessage;
import org.hussain.async.handler.impl.JobHandler;

public class Snippet {
	public static void main(String[] args) {

		final JobHandler handler = new JobHandler();
		
		final Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			final JobMessage job = new JobMessage();
			long randomInt = (long )(Math.random() * 50 + 1);
			
			job.id = randomInt;
			job.status = "1";
			job.service = "com.komli.async.system.JobService";

			handler.produce(job);
		}

	}
}
