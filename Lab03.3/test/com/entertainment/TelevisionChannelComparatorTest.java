package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TelevisionChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private Television tv3;

    private TelevisionChannelComparator comparator;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television();
        tv2 = new Television();
        tv3 = new Television();

        comparator = new TelevisionChannelComparator();
    }


    @Test
    public void testCompareByChannel() throws Exception {
        tv1.changeChannel(1);
        tv2.changeChannel(2);

        assertTrue(comparator.compare(tv1, tv2) < 0 );

        tv2.changeChannel(1);
        assertTrue(comparator.compare(tv1, tv2) == 0 );

    }
}
