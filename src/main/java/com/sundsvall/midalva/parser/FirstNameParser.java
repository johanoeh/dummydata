/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.parser;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author ohhhhjoh
 */
public class FirstNameParser extends AbstractParser{

    public FirstNameParser(BufferedReader br) {
        super(br);
    }
    
    @Override
    public String nextName() throws IOException {
        String line = br.readLine();
        String name = null;
        if (line == null) {
            return null;
        }
        String[] split = line.split(";");
        if (split != null && split.length >= 3) {
            name = split[2];
        }
        return name;
    }
    
}
