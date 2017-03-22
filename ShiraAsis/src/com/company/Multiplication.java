package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/19/2017.
 */
public class Multiplication extends Encryption {





    @Override
    public int encrypt(int oneByte, int key) {
        oneByte = (key * oneByte) & 0x000000FF;
        return oneByte;
    }

    @Override
    public int decrypt(int oneByte, int key) {
        int decKey = 0;
        for (int i = 0; i < 256; i++) {
            if(((i*key)& 0x000000FF)==1) {
                decKey = i;
                break;
            }
        }
        return decKey*oneByte;
    }
}
