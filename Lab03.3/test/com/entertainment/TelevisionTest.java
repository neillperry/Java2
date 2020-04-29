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
    }

    @Test
    public void setVolumeTest() {
        tv1.setVolume(22);
        assertEquals(22, tv1.getVolume());
    }

    @Test
    public void setVolumeIllegalArgumentTest() throws IllegalArgumentException {
        try {
            tv1.setVolume(-22);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: -22. Allowed range: [0,100].", e.getMessage());
        }
    }


    @Test
    public void changeChannelTest() throws InvalidChannelException {
        tv1.changeChannel(202);
        assertEquals(202, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannelInvalidChannelTest() {
        try {
            tv1.changeChannel(-20);
            fail("Should have thrown an InvalidChannelException");
        } catch(InvalidChannelException e) {
            assertEquals("Invalid channel: -20. Allowed range: [1,999].", e.getMessage());
        }
    }


    @Test
    public void compareToTest() {
        tv2 = new Television("Apple", 20, DisplayType.LCD);
        tv3 = new Television("Toshiba", 40, DisplayType.LED);

        // compare two identical instances via the compareTo method
        int comparison1 = tv1.compareTo(tv2);
        assertEquals(0, comparison1);

        // compare two dissimilar instances via the compareTo method
        int comparison2 = tv1.compareTo(tv3);
        assertNotEquals(0, comparison2);
    }

    @Test
    public void equalsTest() {
        tv2 = new Television("Apple", 20, DisplayType.LCD);
        tv3 = new Television("Toshiba", 40, DisplayType.LED);
        assertTrue(tv1.equals(tv2));
        assertFalse(tv1.equals(tv3));
    }

    @Test
    public void hashCodeTest() {
        tv2 = new Television("Apple", 20, DisplayType.LCD);
        tv3 = new Television("Toshiba", 40, DisplayType.LED);
        assertEquals(tv1.hashCode(), tv2.hashCode());
        assertNotEquals(tv1.hashCode(), tv3.hashCode());
    }
}


