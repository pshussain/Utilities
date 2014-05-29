package org.hussain.async.handler;

import org.hussain.async.event.Message;
import com.lmax.disruptor.EventHandler;


@SuppressWarnings("unused")
public abstract class Handler implements EventHandler<Message> {

	public abstract void onEvent(Message event, long sequence, boolean endOfBatch)
			throws Exception;
	public abstract void produce(Message e);
}	
