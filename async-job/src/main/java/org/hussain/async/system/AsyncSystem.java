package org.hussain.async.system;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.hussain.async.event.Message;
import org.hussain.async.handler.Handler;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.MultiThreadedClaimStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;

public class AsyncSystem {

	private final int ringSize;
	private final ExecutorService executorService = Executors
			.newCachedThreadPool();
	private final RingBuffer<Message> ringBuffer;

	Disruptor<Message> disruptor;

	public <T> AsyncSystem(Handler handler, EventFactory<Message> factory) {
		this.ringSize = 1024;
		disruptor = new Disruptor<Message>(factory, executorService,
				new MultiThreadedClaimStrategy(this.ringSize),
				new YieldingWaitStrategy());
		disruptor.handleEventsWith(handler);
		disruptor.start();
		this.ringBuffer = disruptor.getRingBuffer();

	}

	public void onShutdown() {
		disruptor.shutdown();
		executorService.shutdownNow();
	}

	public void onStart() {
		// TODO Auto-generated method stub

	}

	public void handleEventException(Throwable arg0, long arg1, Object arg2) {
		System.out.println(arg0.getMessage());

	}

	public void handleOnShutdownException(Throwable arg0) {
		System.out.println(arg0.getMessage());

	}

	public void handleOnStartException(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	public long getSequence() {
		return ringBuffer.next();
	}

	public Message getNext(long sequence) {
		return ringBuffer.get(sequence);
	}

	public void publish(long sequence) {
		ringBuffer.publish(sequence);
	}

	public static EventFactory<Message> getFactory(final Message m) {
		return new EventFactory<Message>() {
			public Message newInstance() {
				return m;
			}
		};
	}

}
