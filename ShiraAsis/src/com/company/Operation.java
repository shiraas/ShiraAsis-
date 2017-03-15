package com.company;

/**
 * Created by hackeru on 3/1/2017.
 */
public interface Operation {

    public String en_dec_cryption_1(MyFile file);
    public void byKey(MyFile file, int key);
    public MyFile createFile(String begin);
}
