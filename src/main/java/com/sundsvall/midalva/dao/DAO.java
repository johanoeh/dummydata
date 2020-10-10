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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class DAO {

    private String maleNameFile;
    private String femaleNameFile;
    private String lastNameFile;
    private String addressFile;

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

    private DAO() {

    }

    public static DAO create() {
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

    public List<String> getLastNames() throws Exception {
        return getNames(lastNameFile);
    }

    public List<String> getMaleNames() throws Exception {
        return getNames(maleNameFile);
    }

    public List<String> getFemaleNames() throws Exception {
        return getNames(femaleNameFile);
    }

    private static final Logger LOG = Logger.getLogger(DAO.class.getName());

    private static List<String> getNames(String names) throws Exception {
       try (FileUtil fileUtil = new FileUtil(names)){
           NameParser nameParser = new NameParser(fileUtil.getBufferedReader());
           return nameParser.parseToObjects();
       }catch (Exception e){
           LOG.log(Level.SEVERE,"Caught exception while parsing file",e);
           throw e;
       }
    }

    public List<Address> getAddressList() throws Exception {
        try(FileUtil fileUtil = new FileUtil(addressFile)){
            AddressParser parser = new AddressParser(fileUtil.getBufferedReader());
            return parser.parseToObjects();
        }catch (Exception e){
            LOG.log(Level.SEVERE,"Caught exception while parsing file",e);
            throw e;
        }
    }

    public static class FileUtil implements AutoCloseable {

        private InputStream is;
        private BufferedReader br;
        private String resource;

        public FileUtil(String resource) {
            this.resource = resource;
        }

        public BufferedReader getBufferedReader() {
            is = ClassLoader.getSystemResourceAsStream(resource);
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            return br;
        }

        @Override
        public void close() throws IOException {
            if (br != null)
                br.close();
            if (is != null)
                is.close();
        }
    }
}
