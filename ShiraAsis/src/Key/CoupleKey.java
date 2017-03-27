package Key;

import java.io.Serializable;

/**
 * Created by hackeru on 3/26/2017.
 */
public class CoupleKey<T,K> implements Serializable {
    T key1;
    K key2;

    public CoupleKey(T key1, K key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public K getKey2() {
        return key2;
    }

    public T getKey1() {

        return key1;
    }

    public void setKey2(K key2) {
        this.key2 = key2;
    }

    public void setKey1(T key1) {

        this.key1 = key1;
    }
}
