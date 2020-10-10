/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ohhhhjoh
 */
public abstract class AbstractParser<T> implements Parser<T>{
    
    protected BufferedReader br;
    public AbstractParser(BufferedReader br) {
        this.br = br;
    }

    public List<T> parseToObjects() throws IOException {

        List<T> objects = new ArrayList<>();
        String line;
        while ((line = br.readLine()) !=null){
            T object = parseNext(line);
            if(object != null){
                objects.add(object);
            }
        }
        return objects;
    }

}
