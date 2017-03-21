package com.company;
import java.util.Random;
/**
 * Created by hackeru on 2/28/2017.
 */

public class Menu implements Encryption.EncryptionListener {

    public static final Key key = new RandomKey();
    Input input;
    Output output;

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
                        "your choice: \n");
    }

    public void operationBySelect(State select){
        MyFile file;
        switch (select) {
            case MENU:
                startMenu();
                break;
            case ENCRYPTION:
                file = getPath();
                if (file == null)
                    return;
                encryption(file);
                startMenu();
                break;
            case DECRYPTION:
                file = getPath();
                if (file == null)
                    return;
                decryption(file);
                startMenu();
                break;
            case EXIT:
                return;
            default:
                output.output("Key does not exist \n");
                startMenu();

        }
    }
    public MyFile getPath() {
        output.output("Enter a file path: ");
        String path = input.input();
        if (path == "0")//return menu
        {
            startMenu();
            return null;
        }
        MyFile myFile = new MyFile(path);
        if (!myFile.checkMyFile()){
            output.output("The file doesn't exist.\n press 0 to menu or");
            getPath();
        }
        return myFile;
    }


    public void encryption(MyFile file){

        Key key = new RandomKey();
        output.output("key: " + key.getKey());

        if (operation( true, key.getKey(), file) == 1)
            output.output("Encryption succeeded \n");
    }

    public void decryption(MyFile file){
        boolean flag = true;
        while (flag) {

            output.output("enter key:");
            String key_string = input.input();
            int key;
            try {
                key = Integer.parseInt(key_string);
                flag = false;
                if (operation(false, key, file) == 1)
                    output.output("Decryption succeeded \n");

            } catch (Exception e) {
                output.output("not number, try again");
            }
        }

    }
    public AlgorithmKind getAlgorithmKind(){
        AlgorithmKind algorithmKind = null;
        while (algorithmKind == null) {
            printAlgorithmsKind();
            String select = input.input();
            if (select == "0")
                break;
            algorithmKind = AlgorithmKind.getAlgorithmKind(select);
            if (algorithmKind == null)
                output.output("Key does not exist\npress 0 to menu or");
            else
                return algorithmKind;

        }
        return null;

    }
    public AlgorithmKind getAlgorithmKindWithoutReverse(){
        AlgorithmKind algorithmKind = null;
        while (algorithmKind == null) {
            printAlgorithmsKindWithoutReverse();
            String select = input.input();
            if (select == "0")
                break;
            algorithmKind = AlgorithmKind.getAlgorithmKind(select);
            if (algorithmKind == null || algorithmKind == AlgorithmKind.REVERSE)
            {
                output.output("Key does not exist\npress 0 to menu or");
                algorithmKind = null;
            }
            else
                return algorithmKind;

        }
        return null;

    }

    public int operation(boolean kind, int key, MyFile file){
        Encryption encryption;
        AlgorithmFactory factory = new AlgorithmFactory();
        AlgorithmKind algorithmKind = getAlgorithmKind();
        if (algorithmKind == null)
            return -1;
        else if (algorithmKind != AlgorithmKind.REVERSE)
            encryption = factory.getAlgorithm(algorithmKind);
        else {
               algorithmKind = getAlgorithmKindWithoutReverse();
               if (algorithmKind == null)
                   return -1;
               encryption = factory.getReverseAlgorithm(algorithmKind);
           }
        encryption.setListener(this);
        encryption.action(file, key,kind);
        return 1;

    }
    public void printAlgorithmsKind(){
        output.output("please choose:\n" +
                        "a. Caesar Algorithm\n" +
                        "b. XOR Algorithm\n" +
                        "c. Multiplication Algorithm\n" +
                        "d. Reverse Algorithm\n" +
                        "your choice: \n");
    }
    public void printAlgorithmsKindWithoutReverse() {
        output.output("please choose:\n" +
                "a. Caesar Algorithm\n" +
                "b. XOR Algorithm\n" +
                "c. Multiplication Algorithm\n" +
                "your choice: \n");
    }

    @Override
    public void start() {
        output.output("start:");
        output.output(System.nanoTime()+"");
    }

    @Override
    public void finish() {
        output.output("end");
        output.output(System.nanoTime()+"");

    }
}
