package Algorithm;

/**
 * Created by hackeru on 3/19/2017.
 */
public class XOR extends Encryption<Integer> {


    @Override
    public int encrypt(int oneByte, Integer key) {
        oneByte ^= key;
        return oneByte;
    }

    @Override
    public int decrypt(int oneByte, Integer key) {
        oneByte ^= key;
        return oneByte;
    }




}
