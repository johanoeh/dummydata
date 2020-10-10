/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.parser;

import com.sundsvall.midalva.model.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

/**
 *
 */
public class AddressParser extends AbstractParser<Address> {

    public AddressParser(BufferedReader br) {
        super(br);
    }

    public Address parseNext(String line) throws IOException {
        if (line == null) { return null; }
        String[] split = line.split(";");
        if (!(split != null && split.length >= 4)) { return null; }
        return new Address(split[3], split[4], split[0]);
    }
}
