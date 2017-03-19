package com.company;

import java.io.*;

/**
 * Created by hackeru on 2/28/2017.
 */
public interface Encryption {

    public void encrypt(MyFile file, int key);
    public void decrypt(MyFile file, int key);

}
