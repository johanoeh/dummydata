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
 * @author johan
 */
public class NameParser extends AbstractParser {

    public NameParser(BufferedReader br) {
        super(br);
    }

    @Override
    public String nextName() throws IOException {
        String name = br.readLine();
        if (name == null) {return null;}
        return name.replaceAll("\\s", "");
    }

}
