package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/15/2017.
 */
public class Caesar extends Encryption{


    @Override
    public int encrypt(int oneByte, int key) {
        oneByte += key;
        return oneByte;
    }

    @Override
    public int decrypt(int oneByte, int key) {
        oneByte -=  key;
        return oneByte;
    }
}
