/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.parser;

import java.io.BufferedReader;

/**
 *
 * @author ohhhhjoh
 */
public abstract class AbstractParser implements Parser{
    
    protected BufferedReader br;

    public AbstractParser(BufferedReader br) {
        this.br = br;
    }
    
}
