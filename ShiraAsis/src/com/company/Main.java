package com.company;

import InputAndOutput.Screen;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Screen screen = new Screen();
       Menu m = new Menu(screen, screen);
        m.startMenu();
    }
}
