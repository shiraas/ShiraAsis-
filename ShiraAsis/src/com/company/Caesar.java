package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/15/2017.
 */
public class Caesar implements Encryption{

    public MyFile createFile(String begin, boolean kind) {
       if (kind)
           return  new MyFile(begin +"_encrypted.txt");
        return new MyFile(begin + "_decrypted.txt");
    }


     void byKey(MyFile file, int key, boolean kind) {

        String newFile = file.getFile().getPath();
        MyFile decryptionFile = createFile(newFile.substring(0, newFile.lastIndexOf('.')), kind);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int oneByte;
        try {
            outputStream = new FileOutputStream(decryptionFile.getFile());
            inputStream = new FileInputStream(file.getFile());

            while ((oneByte = inputStream.read()) != -1) {

                if (kind) {
                    oneByte +=  key;
                }
                else {
                    oneByte -=  key;
                }
                outputStream.write(oneByte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }


    @Override
    public void decrypt(MyFile file, int key) {
        byKey(file, key, false);
    }

    @Override
    public void encrypt(MyFile file, int key) {
        byKey(file, key, true);
    }
}
