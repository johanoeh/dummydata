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
public class MSISDNMockData {

    private static final String NUM_BEGIN = "4670";

    /**
     * @param len
     * @return
     */
    private String generateNumString(int len) {
        String str = NUM_BEGIN;
        for (int i = 0; i < len; i++) {
            str += ThreadLocalRandom.current().nextInt(0, 10);
        }
        return str;
    }

    public List<String> getMSISDN(int numOfmsisdn) {

        Date date = new Date();
        List<String> msisdns = new ArrayList<>();
        for (int i = 0; i < numOfmsisdn; i++) {
            msisdns.add(generateNumString(7));
        }
        return msisdns;
    }

}
