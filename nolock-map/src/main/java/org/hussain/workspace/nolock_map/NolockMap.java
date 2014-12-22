package org.hussain.workspace.nolock_map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.LifecycleAware;
import com.lmax.disruptor.MultiThreadedClaimStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;

import org.hussain.workspace.nolock_map.NolockMap.Event;

public class NolockMap<K, V> implements Map, EventHandler<Event>,
		LifecycleAware, ExceptionHandler {
	private static final EvtFactory EVT_FACTORY = new EvtFactory();
	int ringSize;
	final ExecutorService executor = Executors.newCachedThreadPool();
	RingBuffer<Event> ringBuffer;
	final ConcurrentHashMap<K, V> map;

	public NolockMap() {
		this.ringSize = 1048576;
		map = new ConcurrentHashMap<K, V>();
		Disruptor<Event> disruptor = new Disruptor<Event>(EVT_FACTORY,
				executor, new MultiThreadedClaimStrategy(this.ringSize),
				new BusySpinWaitStrategy());
		disruptor.handleEventsWith(this);
		this.ringBuffer = disruptor.start();
	}

	public Object put(Object k, Object v) {
		final long sequence = ringBuffer.next();
		final Event event = ringBuffer.get(sequence);
		event.key = k;
		event.value = v;
		ringBuffer.publish(sequence);
		return event.value;
	}

	public void handleEventException(Throwable arg0, long arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	public void handleOnShutdownException(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	public void handleOnStartException(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	public void onShutdown() {
		

	}

	public void onStart() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public void onEvent(Event evt, long seq, boolean endOfBath)
			throws Exception {
		map.put((K) evt.key, (V) evt.value);

	}

	static class EvtFactory implements EventFactory<Event> {

		public Event newInstance() {
			return new Event();
		}

	}

	static class Event {
		public Object key;
		public Object value;
	}

	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return map.containsValue(value);
	}

	public V get(Object key) {
		// TODO Auto-generated method stub
		return (V)map.get(key);
	}

	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return map.remove(key);
	}

	public void putAll(Map m) {
		// TODO Auto-generated method stub

	}

	public void clear() {
		map.clear();

	}

	public Set keySet() {
		// TODO Auto-generated method stub
		return map.keySet();
	}

	public Collection values() {
		// TODO Auto-generated method stub
		return map.values();
	}

	public Set entrySet() {
		// TODO Auto-generated method stub
		return map.entrySet();
	}

}
