package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */
public enum AlgorithmKind {
   CAESAR, XOR, REVERSE, MULTIPLICATION;
    public static AlgorithmKind getAlgorithmKind(String choice)
    {
        switch (choice){
            case "a":
                return CAESAR;
            case "b":
                return XOR;
            case "c":
                return MULTIPLICATION;
            case "d":
                return REVERSE;
            default:
                return null;
        }
    }
}
