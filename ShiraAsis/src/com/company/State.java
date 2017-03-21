package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */
public enum State {
    MENU, ENCRYPTION, DECRYPTION, EXIT;
    public static State getState(String choice){
        switch (choice){
            case "0":
                return MENU;
            case "1":
                return ENCRYPTION;
            case "2":
                return DECRYPTION;
            case "3":
                return EXIT;
            default:
                return null;

        }
    }

}
