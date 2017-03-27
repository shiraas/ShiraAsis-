package Algorithm;

/**
 * Created by hackeru on 3/15/2017.
 */
public class Caesar extends Encryption <Integer>{

    @Override
    public int encrypt(int oneByte, Integer key) {
        oneByte += key;
        return oneByte;
    }

    @Override
    public int decrypt(int oneByte, Integer key) {
        oneByte -=  key;
        return oneByte;
    }


}
