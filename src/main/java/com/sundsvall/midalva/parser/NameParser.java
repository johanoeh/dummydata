/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.parser;

import com.sundsvall.midalva.dao.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

/**
 *
 * @author johan
 */
public class NameParser extends AbstractParser<String> {


    public NameParser(BufferedReader bufferedReader) {
        super(bufferedReader);
    }

    @Override
    public String parseNext(String line){
        if (line == null) {return null;}
        return line.replaceAll("\\s", "");
    }
}
