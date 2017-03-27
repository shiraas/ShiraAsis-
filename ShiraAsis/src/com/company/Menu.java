package com.company;

import Algorithm.*;
import Algorithm.Double;
import File.FileEncryptionHandler;
import File.FileHandler;
import InputAndOutput.Input;
import InputAndOutput.Output;

import java.util.Random;

import Key.*;

/**
 * Created by hackeru on 2/28/2017.
 */

public class Menu implements EncryptionListener {

    private Input input;
    private Output output;



    public Menu(Input input, Output output) {
        this.output = output;
        this.input = input;
    }

    public void startMenu() {
        printMenu();
        String select = input.input();
        operationBySelect(State.getState(select));
    }

    private void printMenu() {
        output.output("please choose:\n" +
                        "0. return to menu\n" +
                        "1. encryption\n" +
                        "2. decryption\n" +
                        "3. exit\n" +
                        "your choice:");
    }

    public void operationBySelect(State select){
        FileHandler file;
        switch (select) {
            case MENU:
                break;
            case ENCRYPTION:
                file = getPath();
                if (file == null)
                    break;
                encrypt_decrypt(file,true);
                break;
            case DECRYPTION:
                file = getPath();
                if (file == null)
                   break;
                encrypt_decrypt(file, false);
                break;
            case EXIT:
                return;
            default:
                output.output("choice does not exist \n");


        }
        startMenu();
    }

    public FileHandler getPath() {
        output.output("Enter a file path: ");
        String path = input.input();
        if (path.equals(String.valueOf(State.MENU.ordinal())))
            return null;
        FileHandler myFile = new FileHandler(path);
        if (!myFile.checkMyFile()){
            output.output("The file doesn't exist.\n press 0 to menu or");
            getPath();
        }
        return myFile;
    }


    /*public EncryptionKey getKeyfromUser(){
        boolean askNumber = true;
        int key = 0;
        while (askNumber) {
            output.output("enter key:");
            String key_string = input.input();

            try {
                key = Integer.parseInt(key_string);
                askNumber = false;
            } catch (NumberFormatException e) {
                output.output("not number, try again");
            }
        }
        EncryptionKey encryptionKey = new EncryptionKey(key);
        return encryptionKey;
    }*/

    public  void encrypt_decrypt(FileHandler file, boolean isEncrypted) {
        Double d = new Double(new XOR(), new Reverse(new Double(new Caesar(), new Multiplication())));
        d.setListener(this);
        CaupleKey<Integer, CaupleKey<Integer, Integer>> key = getKey(isEncrypted, file);
        FileEncryptionHandler fileEncryptionHandler = new FileEncryptionHandler(file, isEncrypted);
        if (fileEncryptionHandler.fileEncryption(key, d,file)) {
            if (isEncrypted)
                output.output("Encryption succeeded \n");
            else
                output.output("Decryption succeeded \n");
        } else {
            output.output("fail");
        }
    }

    public CaupleKey<Integer, CaupleKey<Integer, Integer>> getKey(boolean isEncrypted, FileHandler file){
        CaupleKey<Integer, CaupleKey<Integer, Integer>> key;
        FileKey<CaupleKey<Integer, CaupleKey<Integer, Integer>>> fileKey = new FileKey(file);
        if (isEncrypted) {
            Random randomNum = new Random(System.currentTimeMillis());
            key = new CaupleKey<Integer, CaupleKey<Integer, Integer>>
                    (randomNum.nextInt(255), new CaupleKey<Integer, Integer>(randomNum.nextInt(255), randomNum.nextInt(255)));
            fileKey.setKey(key);
        } else {
            key = fileKey.getKey();
        }
        return key;
    }

    @Override
    public void start() {
        output.output("start:");
        time = System.nanoTime();
        output.output(time+" nano seconds\n");
    }

    @Override
    public void finish() {
        time = System.nanoTime() - time;
        output.output("end:\ntotal time: " +  time + " nano seconds\n");

    }


    /*public String chooseDoubleAlgorithmKind(){
        String select = null;
        while (select == null) {
            printDoubleAlgorithmsKind();
            select = input.input();
            if (select.equals(String.valueOf(State.MENU.ordinal())))
                break;
            if (select.equals("a") || select.equals("b"))
                return select;
            else {
                output.output("Key does not exist\npress 0 to menu or");
                select = null;
            }

        }
        return null;


    }
  /*  public AlgorithmKind chooseAlgorithmKind(){

        AlgorithmKind algorithmKind = null;
        while (algorithmKind == null) {
            printAlgorithmsKind();
            String select = input.input();
            if (select.equals(String.valueOf(State.MENU.ordinal())))
                break;
            algorithmKind = AlgorithmKind.getAlgorithmKind(select);
            if ((algorithmKind == null) || (algorithmKind.equals(AlgorithmKind.REVERSE))) {
                output.output("Key does not exist\npress 0 to menu or");
                algorithmKind = null;
            }
            else
                return algorithmKind;

        }
        return null;


    }

    public boolean operation(boolean ifEncrypt, int key1, int key2,String select, AlgorithmKind algorithmKind, MyFile file){
        Encryption encryption1;
        Encryption encryption2;
        AlgorithmFactory factory = new AlgorithmFactory();
        if (select.equals("a")) {
            encryption1 = factory.getAlgorithm(AlgorithmKind.CAESAR);
            encryption1.setKey(key1);
            encryption2 = factory.getAlgorithm(AlgorithmKind.MULTIPLICATION);
            encryption2.setKey(key2);
        }
        else{
            encryption1 = factory.getAlgorithm(AlgorithmKind.XOR);
            encryption1.setKey(key1);
            encryption2 = factory.getReverseAlgorithm(algorithmKind);
            encryption2.setKey(key2);
        }
        Double doubleAlgorithm = new Double(encryption1,encryption2);
        doubleAlgorithm.setListener(this);

        return doubleAlgorithm.action(file,ifEncrypt);

    }
   /* public AlgorithmKind chooseAlgorithmKind(boolean ifReverse){

        AlgorithmKind algorithmKind = null;
        while (algorithmKind == null) {
            printAlgorithmsKind(ifReverse);
            String select = input.input();
            if (select.equals(String.valueOf(State.MENU.ordinal())))
                break;
            algorithmKind = AlgorithmKind.getAlgorithmKind(select);
            if ((algorithmKind == null) || ((algorithmKind.equals(AlgorithmKind.REVERSE)) && (!ifReverse))) {
                output.output("Key does not exist\npress 0 to menu or");
                algorithmKind = null;
            }
            else
                return algorithmKind;

        }
        return null;


    }*/

   /* public void printAlgorithmsKind(boolean ifReverse){
        output.output("please choose:\n" +
                        "a. Caesar Algorithm\n" +
                        "b. XOR Algorithm\n" +
                        "c. Multiplication Algorithm");
        if (ifReverse)
            output.output("d. Reverse Algorithm");
        output.output("your choice:");

    }*/
  /* public void printDoubleAlgorithmsKind(){
       output.output("please choose:\n" +
               "a. Caesar Algorithm and  Multiplication Algorithm\n" +
               "b. XOR Algorithm and  Reverse Algorithm\n"+
               "your choice:");

   }
    public void printAlgorithmsKind(){
        output.output("please choose:\n" +
                "a. Caesar Algorithm\n" +
                "b. XOR Algorithm\n" +
                "c. Multiplication Algorithm\n"+
                "your choice:");


    }*/



}
