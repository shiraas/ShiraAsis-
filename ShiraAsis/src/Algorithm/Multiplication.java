package Algorithm;

/**
 * Created by hackeru on 3/19/2017.
 */
public class Multiplication extends Encryption<Integer> {


    @Override
    public int encrypt(int oneByte, Integer key) {
        oneByte = (key * oneByte) & 0x000000FF;
        return oneByte;
    }

    @Override
    public int decrypt(int oneByte, Integer key) {
        int decKey = 0;
        for (int i = 0; i < 256; i++) {
            if(((i*key)& 0x000000FF)==1) {
                decKey = i;
                break;
            }
        }
        return decKey*oneByte;
    }
}
