package org.hussain.async.system;

import org.hussain.async.event.Message;
import org.hussain.async.event.JobMessage;

/*
 * Singleton implmentation for AsyncSystem
 * This is a wrapper over Disruptor - used in publisher - subscriber mode
 * This will be used to Async Calls to Facebook API
 * UI - Async Calls
 */

public class JobService {

	public JobService() {

	}

	public void receive(Message event) {
		JobMessage s = (JobMessage) event;
		System.out.println("receive :" + s.getService());
	}
}