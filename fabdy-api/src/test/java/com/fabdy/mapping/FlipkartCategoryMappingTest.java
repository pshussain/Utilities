package com.fabdy.mapping;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlipkartCategoryMappingTest {

    @Test
    public void testGetMappingKeys() throws Exception {
        final FlipkartCategoryMapping mapping = new FlipkartCategoryMapping(1, 1);
        assertTrue(mapping.getFieldMapping().containsKey("name"));
//        assertTrue(mapping.getFieldMapping().containsKey("age"));
//        assertTrue(mapping.getFieldMapping().containsKey("sex"));
    }
    @Test (expected = NullPointerException.class)
    public void testGetMappingNoFileFound() throws Exception {
        final FlipkartCategoryMapping mapping = new FlipkartCategoryMapping(1, 2);
//        assertFalse(mapping.getFieldMapping().containsKey("name"));
    }

    @Test
    public void testGetMappingValues() throws Exception {
        final FlipkartCategoryMapping mapping = new FlipkartCategoryMapping(1, 1);
//        assertTrue(mapping.getFieldMapping().containsValue("hussain"));
//        assertTrue(mapping.getFieldMapping().containsValue("33"));
//        assertTrue(mapping.getFieldMapping().containsValue("male"));
    }
}