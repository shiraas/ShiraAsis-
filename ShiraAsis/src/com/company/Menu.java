package com.company;
import java.util.Random;
/**
 * Created by hackeru on 2/28/2017.
 */

public class Menu implements Encryption.EncryptionListener {

    private Input input;
    private Output output;

    private long time;

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
        MyFile file;
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

    public MyFile getPath() {
        output.output("Enter a file path: ");
        String path = input.input();
        if (path.equals(String.valueOf(State.MENU.ordinal())))
            return null;
        MyFile myFile = new MyFile(path);
        if (!myFile.checkMyFile()){
            output.output("The file doesn't exist.\n press 0 to menu or");
            getPath();
        }
        return myFile;
    }

    public int getKey(){
        Key key = new RandomKey();
        output.output("key: " + key.getKey()+"\n");
        return key.getKey();
    }

    public int setKey(){
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
        return key;
    }

    public void encrypt_decrypt(MyFile file, boolean ifEncrypt){
        boolean ifReverse = true;
        AlgorithmKind algorithmKind = chooseAlgorithmKind(ifReverse);
        if (algorithmKind.equals(AlgorithmKind.REVERSE)){
            algorithmKind = chooseAlgorithmKind(false);
        }
        else
            ifReverse = false;
        int key;
        if (ifEncrypt)
            key = getKey();
        else
            key =setKey();
        if ((algorithmKind.equals(AlgorithmKind.MULTIPLICATION)) && (key%2 == 0))
            key = key +1;


        if (operation(ifEncrypt, key, algorithmKind, file,ifReverse)) {
            if (ifEncrypt)
                output.output("Encryption succeeded \n");
            else
                output.output("Decryption succeeded \n");
        }
        else
            output.output("fail");
    }

    public AlgorithmKind chooseAlgorithmKind(boolean ifReverse){

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


    }

    public boolean operation(boolean ifEncrypt, int key, AlgorithmKind algorithmKind, MyFile file, boolean ifReverse){
        Encryption encryption;
        AlgorithmFactory factory = new AlgorithmFactory();
        if (algorithmKind == null)
            return false;
        else if (!ifReverse)
            encryption = factory.getAlgorithm(algorithmKind);
        else
            encryption = factory.getReverseAlgorithm(algorithmKind);

        encryption.setListener(this);

        return encryption.action(file, key, ifEncrypt);

    }

    public void printAlgorithmsKind(boolean ifReverse){
        output.output("please choose:\n" +
                        "a. Caesar Algorithm\n" +
                        "b. XOR Algorithm\n" +
                        "c. Multiplication Algorithm");
        if (ifReverse)
            output.output("d. Reverse Algorithm");
        output.output("your choice:");

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
}
