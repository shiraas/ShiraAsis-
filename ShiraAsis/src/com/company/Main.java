package com.company;

import java.nio.ByteBuffer;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ScreenInterface s = new ScreenInterface();
       Menu m = new Menu(s, s);
        m.start();
    }
}
