package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television("Sony", 10, DisplayType.LED);
        tv2 = new Television("Sony", 10, DisplayType.LED);
    }

    @Test(expected = IllegalArgumentException.class) //first option easy
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1); //should trigger exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        tv.setVolume(101); //should trigger exception
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() {
        try {
            tv.changeChannel(0); //should trigger exception
            fail("should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }


    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound() {
        try {
            tv.changeChannel(1000); //should trigger exception
            fail("should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

    //compareTo

    @Test //Channel compare test??
    public void testCompareTo_trueWhenChannelIsTheSame() {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        assertEquals(0, compares.compare(tv, tv2));
    }

    @Test
    public void testCompareTo_differentBrand_false() {
        Television tv3 = new Television("LG");
        Television tv4 = new Television("Sony");
        assertNotEquals(0, tv3.compareTo(tv4));
//        assertFalse(false);
    }


    //Hash code test when same
    @Test
    public void hashCode_shouldBeEqual_whenEqualObjects() {
        assertEquals(tv.hashCode(), tv2.hashCode());
    }


    //Equals when same
    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(tv, tv2);
        assertTrue(tv.equals(tv2));
    }

    //Equals when different
    @Test
    public void equals_shouldReturnFalse_differentBrand_differentVolume_differentScreen() {
        Television tv3 = new Television("LG", 25, DisplayType.LCD);
        Television tv4 = new Television("Sony", 28, DisplayType.LED);
        assertNotEquals(tv3, tv4);
        assertFalse(tv3.equals(tv4));
    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_differentScreen() {
        Television tv3 = new Television("LG", 25, DisplayType.LCD);
        Television tv4 = new Television("Sony", 25, DisplayType.LED);
        assertNotEquals(tv3, tv4);
        assertFalse(tv3.equals(tv4));
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_differentVolume_differentScreen() {
        Television tv3 = new Television("LG", 25, DisplayType.LCD);
        Television tv4 = new Television("LG", 28, DisplayType.LED);
        assertNotEquals(tv3, tv4);
        assertFalse(tv3.equals(tv4));
    }

}