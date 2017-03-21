package com.company;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by hackeru on 2/28/2017.
 */
public class MyFile {

    private File file;



    public MyFile(String pathname) {
        file = new File(pathname);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean checkMyFile() {
        if (file.exists() && (file.isFile()))
            return true;
        return false;

    }
    public MyFile createEncryptionFile(boolean kind) {
        String begin = file.getPath();
        begin = begin.substring(0, begin.lastIndexOf('.'));
        if (kind)
            return  new MyFile(begin +"_encrypted.txt");
        return new MyFile(begin + "_decrypted.txt");
    }

    public void closeOutput(OutputStream outputStream){
        if (outputStream != null)
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void closeInput(InputStream inputStream){
        if (inputStream != null)
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }



}