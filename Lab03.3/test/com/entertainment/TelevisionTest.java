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
    public void changeChannelException() {
        try {
            tv1.changeChannel(-20);
            fail("Should have thrown an InvalidChannelException");
        } catch(InvalidChannelException e) {
            assertEquals("Invalid channel: -20. Allowed range: [1,999].", e.getMessage());
        }
    }


    @Test
    public void compareToTest() {

    }

    @Test
    public void equalsTest() {

    }

    @Test
    public void hashCodeTest() {

    }
}


