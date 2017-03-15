package com.company;

import java.io.File;

/**
 * Created by hackeru on 2/28/2017.
 */
public class Decryption implements Operation {
    public MyFile createFile(String begin){
       return  new MyFile(begin+"_decrypted.txt");
    }
    public String en_dec_cryption_1(MyFile file){
        //System.out.println("decryption succeeded");
        return "succeeded";
    }
    public void byKey(MyFile file, int key){
        String newFile = file.getFile().getPath();
        MyFile decryptionFile = createFile(newFile.substring(0, newFile.lastIndexOf('.')));


    }
}
