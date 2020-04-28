package com.entertainment.client;

import com.entertainment.ChannelDisallowedException;
import com.entertainment.InvalidChannelException;
import com.entertainment.Television;

public class TelevisionParentalControlTest {

    public static void main(String[] args) throws ChannelDisallowedException, InvalidChannelException {

        Television tv1 = new Television("RCA", 10);  // invalid volume, should remain 0 (the default)
        System.out.println(tv1);

        tv1.changeChannel(550);
        System.out.println(tv1);



        tv1.setParentalControl();
        System.out.println(tv1);

    }

}
