package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by hackeru on 2/28/2017.
 */
public class Menu {

    public void start() {
        System.out.println("Enter a file path:");
        String path = readInput();


        MyFile myFile = new MyFile(path);
        if (myFile.checkMyFile())
            printMenu(myFile);
        else {
            System.out.println("The file doesn't exist, try again");
            start();
        }


    }

    private void printMenu(MyFile file) {

        System.out.println("please choose:");
        System.out.println("0. return to menu");
        System.out.println("1. decryption");
        System.out.println("2. encryption");
        System.out.println("3. exit");
        System.out.println("your choice: ");
        selectUser(file);

    }

    private void selectUser(MyFile file) {
        String select = readInput();
        Decryption decryption = new Decryption();
        Encryption encryption = new Encryption();

        switch (select) {
            case "0":
                start();
                break;
            case "1":
                decryption.en_dec_cryption_1(file);
                break;
            case "2":
                encryption.en_dec_cryption_1(file);
                break;
            case "3":
                return;
            default:
                System.out.println("Key does not exist");
                printMenu(file);
        }
    }

    private String readInput() {
        String input = null;
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

}
