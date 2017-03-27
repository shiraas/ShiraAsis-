package Algorithm;

import Key.CaupleKey;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by hackeru on 3/22/2017.
 */
public class Double<T,K> extends Encryption<CaupleKey<T,K>> {

    Encryption<T> encryption1;
    Encryption<K> encryption2;

    public Double(Encryption<T> encryption1, Encryption<K> encryption2) {
        this.encryption1 = encryption1;
        this.encryption2 = encryption2;
    }

    @Override
    public int encrypt(int oneByte, CaupleKey<T,K> key ) {

        return encryption2.encrypt(encryption1.encrypt(oneByte, key.getKey1()),key.getKey2());
    }

    @Override
    public int decrypt(int oneByte, CaupleKey<T,K> key) {

        return encryption1.decrypt(encryption2.decrypt(oneByte,key.getKey2()), key.getKey1());
    }
  /*  @Override
    public void writeKeyToFile(ObjectOutputStream objectOutputStream){
        encryption2.writeKeyToFile( objectOutputStream);
        encryption1.writeKeyToFile(objectOutputStream);
    }
    @Override
    public void readKeyFromFile(ObjectInputStream objectInputStream){
        encryption2.readKeyFromFile(objectInputStream);
        encryption1.readKeyFromFile(objectInputStream);
    }*/
}
