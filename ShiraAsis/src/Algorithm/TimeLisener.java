package Algorithm;

import Algorithm.EncryptionListener;

/**
 * Created by hackeru on 3/27/2017.
 */
public class TimeLisener implements EncryptionListener {
    private long time;

    @Override
    public void start() {
        time = System.nanoTime();
    }

    @Override
    public void finish() {
        time = System.nanoTime() - time;
    }
}
