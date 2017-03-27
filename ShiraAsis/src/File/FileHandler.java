package File;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by hackeru on 2/28/2017.
 */
public class FileHandler {

    private File file;

    public FileHandler(String pathname) {
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
    public FileHandler createEncryptionFile(boolean isEncrypted) {
        String begin = file.getPath();
        begin = begin.substring(0, begin.lastIndexOf('.'));
        if (isEncrypted)
            return  new FileHandler(begin +"_encrypted.txt");
        return new FileHandler(begin + "_decrypted.txt");
    }


    public OutputStream openOutput(){
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return outputStream;
    }
    public ObjectOutputStream openObjectOutput(OutputStream outputStream){
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectOutputStream;
    }
    public InputStream openInput(){
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
    public ObjectInputStream openObjectInput(InputStream inputStream){
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectInputStream;
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
    public void closeObjectOutput(ObjectOutputStream objectOutputStream) {
        if (objectOutputStream != null)
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void closeObjectInput(ObjectInputStream objectInputStream) {
        if(objectInputStream != null)
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public <T> void writeToFile(ObjectOutputStream objectOutputStream, T object) {

        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public <T> T readFromFile( ObjectInputStream objectInputStream){
        T object;

        try {
            if ((object = (T) objectInputStream.readObject()) != null)
                return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }




}