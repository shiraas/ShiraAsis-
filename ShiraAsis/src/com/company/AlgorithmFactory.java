package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */
public class AlgorithmFactory {

        public Encryption getAlgorithm(AlgorithmKind type){
            if(type == null)
                return null;
            switch (type){
                case CAESAR:
                    return new Caesar();
                case XOR:
                    return new XOR();
                case MULTIPLICATION:
                    return new Multiplication();
                default:
                    return null;
            }
        }

        public Encryption getReverseAlgorithm (AlgorithmKind type){
            return new Reverse(getAlgorithm(type));
        }

}
