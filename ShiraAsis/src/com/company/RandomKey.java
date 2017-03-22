package com.company;

import java.util.Random;

/**
 * Created by hackeru on 3/20/2017.
 */
public class RandomKey implements Key {
    @Override
    public int getKey() {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(255);
    }


}
