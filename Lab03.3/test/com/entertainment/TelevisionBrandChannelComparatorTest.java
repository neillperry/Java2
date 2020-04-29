package com.entertainment;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class TelevisionBrandChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionBrandChannelComparator comparator;

    @Before
    public void Setup() throws Exception {
        tv1 = new Television("Apple");
        tv2 = new Television("Sony");
        comparator = new TelevisionBrandChannelComparator();
    }

    @Test
    public void testCompareByBrand_DifferentBrand() throws Exception {
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void testCompareByBrand_SameBrand_DifferentChannel() throws Exception {
        tv2.setBrand("Apple");
        tv1.changeChannel(1);
        tv2.changeChannel(2);

        assertTrue(comparator.compare(tv1, tv2) < 0);
    }
}