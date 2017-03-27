package File;

import Algorithm.Encryption;
import Key.*;

import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by hackeru on 3/27/2017.
 */
public class FileEncryptionHandler<T> {
    FileHandler fileHandler;
    boolean isEncrypted;

    public FileEncryptionHandler(FileHandler fileHandler,boolean isEncrypted) {
        String begin = fileHandler.getFile().getPath();
        begin = begin.substring(0, begin.lastIndexOf('.'));
        if (isEncrypted) {
            this.fileHandler = new FileHandler(begin + "_encrypted.txt");
        }
        else{
            this.fileHandler = new FileHandler(begin + "_decrypted.txt");
        }
        this.isEncrypted = isEncrypted;

    }


    public boolean fileEncryption(T key, Encryption encryption, FileHandler file){
        OutputStream outputStream = fileHandler.openOutput();
        InputStream inputStream = file.openInput();
        if (encryption.action(key, this.isEncrypted, outputStream, inputStream)) {
            fileHandler.closeOutput(outputStream);
            fileHandler.closeInput(inputStream);
            return true;
        }
        fileHandler.closeOutput(outputStream);
        fileHandler.closeInput(inputStream);

        return false;

    }


}
