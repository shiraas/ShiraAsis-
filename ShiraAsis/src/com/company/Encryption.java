package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/21/2017.
 */
public abstract class Encryption {

    EncryptionListener listener;

    public void setListener(EncryptionListener listener) {
        this.listener = listener;
    }

    public abstract int encrypt(int oneByte, int key);

    public abstract int decrypt(int oneByte, int key);

    interface EncryptionListener{

        void start();
        void finish();
    }

    public void start (){
        if(listener != null)
            listener.start();
    }

    public void finish (){
        if(listener != null)
            listener.finish();
    }

    void action(MyFile file, int key, boolean kind){
        start();
        OutputStream outputStream = null;
        InputStream inputStream = null;
       MyFile newFile = file.createEncryptionFile(kind);
        try {
            outputStream = new FileOutputStream(newFile.getFile());
            inputStream = new FileInputStream(file.getFile());
            int oneByte;
            while ((oneByte = inputStream.read()) != -1) {
                if (kind)
                    outputStream.write(encrypt(oneByte, key));
                else
                    outputStream.write(decrypt(oneByte, key));
            }
            finish();
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            newFile.closeOutput(outputStream);
            file.closeInput(inputStream);
        }
    }
}
