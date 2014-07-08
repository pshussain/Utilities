package org.hussain.async.handler.impl;

import java.lang.reflect.Method;

import org.hussain.async.event.Message;
import org.hussain.async.event.JobMessage;
import org.hussain.async.handler.Handler;
import org.hussain.async.system.AsyncSystem;
import com.lmax.disruptor.EventFactory;

public class JobHandler extends Handler {
	final AsyncSystem async;

	public JobHandler() {
		async = new AsyncSystem(this, AsyncSystem.getFactory(new JobMessage()));
	}

	public void onEvent(final Message event, final long sequence,
			final boolean endOfBatch) throws Exception {
		JobMessage jobEvent = (JobMessage) event;
		try {
			System.out.println("Job Process Completed : " + jobEvent.getId());
		} catch (Throwable err) {
			err.printStackTrace();

		}
	}

	public void produce(Message event) {
		try {
			JobMessage m = (JobMessage) event;
			long sequence = async.getSequence();
			JobMessage e = (JobMessage) async.getNext(sequence);
			e.id = m.id;
			e.service = m.service;
			e.status = m.status;
			async.publish(sequence);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}