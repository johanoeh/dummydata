/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.parser;

import com.sundsvall.midalva.model.Address;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author ohhhhjoh
 */
public class AddressParser {

    private BufferedReader br;

    public AddressParser(BufferedReader br) {
        this.br = br;
    }

    public Address nextAdress() throws IOException {
        
        String line = br.readLine();
        
        if (line == null) { return null; }
        
        String[] split = line.split(";");
        
        if (!(split != null && split.length >= 4)) { return null; }
        
        return new Address(split[3], split[4], split[0]);
    }
}
