package Algorithm;

import Algorithm.EncryptionListener;
import com.company.Menu;

/**
 * Created by hackeru on 3/27/2017.
 */
public class TimeListener implements EncryptionListener {
    private long time;
    Menu menu;

    public TimeListener(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void start() {
        time = System.nanoTime();
        menu.printUser("start:\n" +time+" nano seconds\n" );

    }

    @Override
    public void finish() {
        time = System.nanoTime() - time;
        menu.printUser("end:\ntotal time: " +  time + " nano seconds\n");
    }
}
