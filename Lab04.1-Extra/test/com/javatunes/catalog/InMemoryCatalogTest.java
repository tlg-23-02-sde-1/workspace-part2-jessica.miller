package com.javatunes.catalog;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findSelfTitled_shouldReturnCorrectResult() {
        Collection<MusicItem> items = catalog.findSelfTitled(); //call the method to be tested
        //size should be 2, ids are 6, 7 <-----RESULT SHOULD BE
        //1) get size and make sure it's 2
        assertEquals(2, items.size());
        //2)extract the first one and make sure its id is 6
        List<MusicItem> itemsList = new ArrayList<>(items);
        itemsList.sort(null);
        assertEquals(6L, itemsList.get(0).getId().longValue());
        assertEquals(7L, itemsList.get(1).getId().longValue());

    }

    @Test(expected = UnsupportedOperationException.class)
    public void getAll_shouldReturnReadOnlyCollection() {
        Collection<MusicItem> items = catalog.getAll();
        items.clear();
        
    }


    @Test
    public void findById_shouldReturnMusicItem_whenIDFound() {
        MusicItem item = catalog.findById(12L);
        assertEquals(12, item.getId().longValue());
        //assertTrue(12 == item.getId());
    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(1000L);
        assertNull(item);
    }
}