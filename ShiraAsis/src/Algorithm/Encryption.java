package Algorithm;

import java.io.*;

/**
 * Created by hackeru on 3/21/2017.
 */
public abstract class Encryption <T> {

    EncryptionListener timeListener;
    EncryptionListener messageListener;

    public Encryption(EncryptionListener listener) {
        this.timeListener = new TimeLisener();
        messageListener = listener;
    }

    public void setListener(EncryptionListener listener) {
        this.messageListener = listener;
    }

    public abstract int encrypt(int oneByte, T key);

    public abstract int decrypt(int oneByte, T key);

    public void start () {
        if (timeListener != null)
            timeListener.start();
        if (messageListener != null)
            messageListener.start();
    }

    public void finish () {
        if (timeListener != null)
            timeListener.finish();
        if (messageListener != null)
            messageListener.finish();
    }

    /*public boolean action(FileHandler file, boolean isEncrypted){
        start();
        OutputStream outputStream_newFile = null;
        InputStream inputStream_file = null;
        OutputStream outputStream_keyFile = null;
        ObjectOutputStream objectOutputStream = null;
        InputStream inputStream_keyFile = null;
        ObjectInputStream objectInputStream = null;
       FileHandler newFile = file.createEncryptionFile(isEncrypted);
        FileHandler keyFile = file.createKeyEncryptionFile();


        try {
            outputStream_newFile = new FileOutputStream(newFile.getFile());
            inputStream_file = new FileInputStream(file.getFile());


            if (isEncrypted) {
                outputStream_keyFile = new FileOutputStream(keyFile.getFile());
                objectOutputStream = new ObjectOutputStream(outputStream_keyFile);
                writeKeyToFile( objectOutputStream);
            }
            else {
                inputStream_keyFile = new FileInputStream(keyFile.getFile());
                objectInputStream = new ObjectInputStream(inputStream_keyFile);
                readKeyFromFile(objectInputStream);
            }

            int oneByte;
            if (isEncrypted)
                while ((oneByte = inputStream_file.read()) != -1)
                    outputStream_newFile.write(encrypt(oneByte));
            else
                while ((oneByte = inputStream_file.read()) != -1)
                    outputStream_newFile.write(decrypt(oneByte));

            finish();
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }catch (IOException e) {
            e.getMessage();
            return false;

        } finally {
            newFile.closeOutput(outputStream_newFile);
            file.closeInput(inputStream_file);
            keyFile.closeOutput(outputStream_keyFile);
            keyFile.closeObjectOutput(objectOutputStream);
            keyFile.closeInput(inputStream_keyFile);
            keyFile.closeObjectInput(objectInputStream);
        }
        return true;
    }*/

    public boolean action( T key, boolean isEncrypted, OutputStream outputStream, InputStream inputStream) {
        start();
        int oneByte;
        try {
        if (isEncrypted) {
            while ((oneByte = inputStream.read()) != -1)
                outputStream.write(encrypt(oneByte, key));
        }

        else {
            while ((oneByte = inputStream.read()) != -1)
                outputStream.write(decrypt(oneByte,key));
        }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        finish();
        return true;
    }

   /* public void writeKeyToFile(ObjectOutputStream objectOutputStream) {

        try {
            objectOutputStream.writeObject(key);
            System.out.println(key.getKey());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/

    /*public void readKeyFromFile( ObjectInputStream objectInputStream){

        EncryptionKey encryptionKey;

        try {
            if ((encryptionKey = (EncryptionKey) objectInputStream.readObject()) != null)
                key.setKey(encryptionKey.getKey());
            System.out.println(key.getKey());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }*/

}
