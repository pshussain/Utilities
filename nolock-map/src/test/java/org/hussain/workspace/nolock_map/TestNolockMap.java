package org.hussain.workspace.nolock_map;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class TestNolockMap extends TestCase {
	@Test
	public void testIntNolockMap() {
		NolockMap<Integer, Integer> map = new NolockMap<Integer, Integer>();
		for (int i = 0; i < 100; i++) {
			map.put(i + 1, i + 100);
		}
		assertEquals(new Integer(109), map.get(10));
		assertEquals(100, map.size());
		assertNotNull(map);
	}
	
	@Test
	public void testStringNolockMap() {
		NolockMap<String, String> map = new NolockMap<String, String>();
		for (int i = 0; i < 100; i++) {
			map.put(String.valueOf(i),String.valueOf(i+100));
		}
		assertEquals("110",map.get("10"));
		assertEquals(100, map.size());
		assertNotNull(map);
	}
	
	
	@Test
	public void testLongNolockMap() {
		NolockMap<Long, Long> map = new NolockMap<Long, Long>();
		for (int i = 0; i < 100; i++) {
			map.put(i,(long)i+100);
		}
		assertEquals(new Long(110),map.get(10));
		assertEquals(100, map.size());
		assertNotNull(map);
	}
	
	@Test
	public void testListNolockMap() {
		NolockMap<Long, ArrayList<String>> map = new NolockMap<Long, ArrayList<String>>();
		for (int i = 0; i < 100; i++) {
			final int j=i;
			map.put(i,new ArrayList<String>(){{add(String.valueOf(j+100));}});
		}
//		assertEquals(String.valueOf(110),map.get(10));
		assertTrue(map.containsValue(map.get(10)));
		assertEquals(100, map.size());
		assertNotNull(map);
	}
}

