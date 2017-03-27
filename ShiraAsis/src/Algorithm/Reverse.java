package Algorithm;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by hackeru on 3/19/2017.
 */
public class Reverse<T> extends Encryption<T>  {

    private Encryption encryption;

    public Reverse(Encryption encryption) {
        this.encryption = encryption;
    }

    @Override
    public int encrypt(int oneByte, T key) {
        return encryption.decrypt(oneByte, key);
    }

    @Override
    public int decrypt(int oneByte, T key) {
        return encryption.encrypt(oneByte, key);
    }
    /*@Override
    public void writeKeyToFile(ObjectOutputStream objectOutputStream){
        encryption.writeKeyToFile(objectOutputStream);
    }
    @Override
    public void readKeyFromFile(ObjectInputStream objectInputStream){
         encryption.readKeyFromFile(objectInputStream);
    }*/
}
