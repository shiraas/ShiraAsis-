package com.company;

/**
 * Created by hackeru on 3/19/2017.
 */
public class Reverse extends Encryption {

    private Encryption encryption;

    public Reverse(Encryption encryption) {
        this.encryption = encryption;
    }


    @Override
    public int encrypt(int oneByte, int key) {
        return encryption.decrypt(oneByte,key);
    }

    @Override
    public int decrypt(int oneByte, int key) {
        return encryption.encrypt(oneByte,key);
    }
}
