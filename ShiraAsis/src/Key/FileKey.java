package Key;

import File.FileHandler;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created by hackeru on 3/26/2017.
 */
public class FileKey<T> implements Key<T> {

    FileHandler fileHandlerKey;

    public FileKey(FileHandler fileHandler) {

        String begin = fileHandler.getFile().getPath();
        begin = begin.substring(0, begin.lastIndexOf("\\")) + "\\key.bin";
        this.fileHandlerKey = new FileHandler(begin);

    }

    @Override
    public T getKey() {
        InputStream inputStream = fileHandlerKey.openInput();
        ObjectInputStream objectInputStream = fileHandlerKey.openObjectInput(inputStream);
        T key = fileHandlerKey.readFromFile(objectInputStream);
        fileHandlerKey.closeObjectInput(objectInputStream);
        fileHandlerKey.closeInput(inputStream);
        return key;
    }

    @Override
    public void setKey(T key) {
        OutputStream outputStream = fileHandlerKey.openOutput();
        ObjectOutputStream objectOutputStream = fileHandlerKey.openObjectOutput(outputStream);
        fileHandlerKey.writeToFile(objectOutputStream, key);
        fileHandlerKey.closeObjectOutput(objectOutputStream);
        fileHandlerKey.closeOutput(outputStream);


    }
}
