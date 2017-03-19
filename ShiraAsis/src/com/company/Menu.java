package com.company;
import java.util.Random;
/**
 * Created by hackeru on 2/28/2017.
 */

public class Menu {

    Input input;
    Output output;


    public Menu(Input input, Output output) {
        this.output = output;
        this.input = input;
    }

    public void start() {
        printMenu();
        String select = input.input();
        operationBySelect(select);
    }



    public MyFile getPath() {
        output.output("Enter a file path: ");
        String path = input.input();
        if (path == "3")
            return null;
        MyFile myFile = new MyFile(path);
        if (!myFile.checkMyFile()){
            output.output("The file doesn't exist.\n press 3 to exit or");
            getPath();
        }
            return myFile;
    }

    private void printMenu(/*MyFile file*/) {
        output.output("please choose:\n" +
                        "0. return to menu\n"+
                        "1. encryption\n"+
                        "2. decryption\n"+
                        "3. exit\n"+
                        "your choice: \n");
    }



    public void operationBySelect(String select){
        //Decryption decryption = new Decryption();
        //Encryption encryption = new Encryption();
        MyFile file;
        switch (select) {
            case "0":
                start();
                break;
            case "1":
                file = getPath();
                if (file == null)
                    return;
                encryption(file);
                output.output("Encryption succeeded \n");
                start();
                break;
            case "2":
                file = getPath();
                if (file == null)
                    return;
                decryption(file);
                output.output("Decryption succeeded \n");
                start();
                break;
            case "3":
                return;
            default:
                output.output("Key does not exist \n");
                start();

        }
    }

    public int randomNum(){
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(255);
    }

    public void encryption(MyFile file){
        int num = randomNum();
        output.output("key: " + num);
        Encryption en = new Caesar();
        en.encrypt(file,num);
    }

    public void decryption(MyFile file){
        Encryption de = new Caesar();
        output.output("enter key:");
        String num_string = input.input();
        int num;
        try {
            num = Integer.parseInt(num_string);

            de.decrypt(file, num);

        }
        catch (Exception e){
            output.output("not number, try again");
            decryption(file);
        }
    }
}
