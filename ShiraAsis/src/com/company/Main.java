package com.company;

import java.nio.ByteBuffer;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ScreenInterface screen = new ScreenInterface();
       Menu m = new Menu(screen, screen);
        m.start();
    }
}
