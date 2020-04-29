package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;
    private Television tv2;
    private Television tv3;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Apple", 20, DisplayType.LCD);
        tv2 = new Television("Apple", 20, DisplayType.LCD);
        tv3 = new Television("Toshiba", 40, DisplayType.LED);
    }

    @Test
    public void setVolumeTest() {
        // Lower Bound
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());

        // Upper Bound
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }

    @Test
    public void setVolumeIllegalArgumentTest_LowerBound() throws IllegalArgumentException {
        try {
            tv1.setVolume(-22);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: -22. Allowed range: [0,100].", e.getMessage());
        }
    }

    @Test
    public void setVolumeIllegalArgumentTest_UpperBound() throws IllegalArgumentException {
        try {
            tv1.setVolume(105);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: 105. Allowed range: [0,100].", e.getMessage());
        }
    }
    @Test
    public void changeChannelTest() throws InvalidChannelException {
        tv1.changeChannel(202);
        assertEquals(202, tv1.getCurrentChannel());
    }

    @Test (expected=InvalidChannelException.class)
    public void changeChannelInvalidChannelTest_LowerBound() throws InvalidChannelException {
         tv1.changeChannel(-20);
    }

    @Test (expected=InvalidChannelException.class)
    public void changeChannelInvalidChannelTest_UpperBound() throws InvalidChannelException {
            tv1.changeChannel(4030);
    }

    @Test
    public void compareToSameTest() {
        // compare two identical instances via the compareTo method
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareToDifferentTest() {
        // compare two dissimilar instances via the compareTo method
        assertNotEquals(0, tv1.compareTo(tv3));
    }

    @Test
    public void equalsSameTest() {
        assertTrue(tv1.equals(tv2));
    }

    @Test
    public void equalsDifferentTest() {
        assertFalse(tv1.equals(tv3));
    }

    @Test
    public void hashCodeSameTest() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCodeDifferentTest() {
        assertNotEquals(tv1.hashCode(), tv3.hashCode());
    }


    @Test
    public void testComparableByBrand() {
        assertTrue(tv1.compareTo(tv3) < 0);
    }
}


