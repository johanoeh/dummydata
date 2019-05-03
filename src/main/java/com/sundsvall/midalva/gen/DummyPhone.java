/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author ohhhhjoh
 */
public class DummyPhone {
    
    public enum NumBegin{
        
        BEGIN_4670("4670"),
        BEGIN_4673("4673"),
        BEGIN_4676("4676");
        
        private final String numBegin;
        
        NumBegin(String numBegin){
           this.numBegin= numBegin;
        }

        public String getNumBegin() {
            return numBegin;
        }  
    }

    /**
     * @param len
     * @param numBegin
     * @return
     */
    public static String generateNumString(int len, NumBegin numBegin) {
        StringBuilder sb = new StringBuilder();
        sb.append(numBegin.getNumBegin());
        for (int i = 0; i < len; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(0, 10));
        }
        return sb.toString();
    }

    public static List<String> getNumbers(int numOfmsisdn, NumBegin numBegin,int numLength) {
        List<String> msisdns = new ArrayList<>();
        for (int i = 0; i < numOfmsisdn; i++) {
            msisdns.add(generateNumString(numLength,numBegin));
        }
        return msisdns;
    }

}
