package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/19/2017.
 */
public class XOR extends Encryption {

    @Override
    public int encrypt(int oneByte, int key) {
        oneByte ^= key;
        return oneByte;
    }

    @Override
    public int decrypt(int oneByte, int key) {
        oneByte ^= key;
        return oneByte;
    }
}
