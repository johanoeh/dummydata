/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.dao;

import com.sundsvall.midalva.model.Address;
import com.sundsvall.midalva.parser.AddressParser;
import com.sundsvall.midalva.parser.NameParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ohhhhjoh
 */
public class DAO {

    private  String maleNameFile;
    private  String femaleNameFile;
    private  String lastNameFile;
    private  String addressFile;

    private static BufferedReader getResource(String resource) throws UnsupportedEncodingException {
        System.out.println(resource);
        InputStream is = ClassLoader.getSystemResourceAsStream(resource);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        return br;
    }

    public DAO(String femaleNameFile, String maleNameFile, String lastNameFile, String addressFile) {

        this.maleNameFile = maleNameFile;
        this.femaleNameFile = femaleNameFile;
        this.lastNameFile = lastNameFile;
        this.addressFile = addressFile;
    }

    private  DAO() {

    }

    public static DAO create(){
        return new DAO();
    }


    public DAO withMaleNameFile(String maleNameFile) {
        this.maleNameFile = maleNameFile;
        return this;
    }

    public DAO withFemaleNameFile(String femaleNameFile) {
        this.femaleNameFile = femaleNameFile;
        return this;
    }

    public DAO withLastNameFile(String lastNameFile) {
        this.lastNameFile = lastNameFile;
        return this;
    }

    public DAO withAddressFile(String addressFile) {
        this.addressFile = addressFile;
        return this;
    }

    public List<String> getLastNames() throws IOException {
        return getNames(lastNameFile);
    }

    public List<String> getMaleNames() throws IOException {
        return getNames(maleNameFile);
    }

    public List<String> getFemaleNames() throws IOException {
        return getNames(femaleNameFile);
    }

    private List<String> getNames(String names) throws IOException {
        String firstName = "";
        List<String> firstNames = new ArrayList<>();
        NameParser nameParser = new NameParser(getResource(names));
        while ((firstName = nameParser.nextName()) != null) {
            firstNames.add(firstName);
        }
        return firstNames;
    }

    public List<Address> getAdrresses() throws IOException {

        List<Address> addresses = new ArrayList<>();
        InputStream is = ClassLoader.getSystemResourceAsStream(addressFile);
        AddressParser parser = new AddressParser(new BufferedReader(new InputStreamReader(is, "UTF-8")));
        Address address = null;
        while ((address = parser.nextAdress()) != null) {
            addresses.add(address);
        }
        return addresses;
    }

}
