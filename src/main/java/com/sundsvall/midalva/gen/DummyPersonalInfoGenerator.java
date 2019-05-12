package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Person;
import com.sundsvall.midalva.dao.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
/**
 * Generates a 
 * @author johan
 */
public class DummyPersonalInfoGenerator {


    private  NameGenerator nameGenerator;
    private  AddressGenerator addressGenerator;
    private final DummyPersonalIdGenerator personalIdGenerator;
    
    private final DAO dao;

    public DummyPersonalInfoGenerator(DAO dao) {

        this.personalIdGenerator = new DummyPersonalIdGenerator();
        this.dao = dao;     
        try {
            nameGenerator = new NameGenerator(dao.getMaleNames(), dao.getFemaleNames(), dao.getLastNames());
            addressGenerator = new AddressGenerator(dao.getAdrresses());
        } catch (IOException ex) {
            Logger.getLogger(DummyPersonalInfoGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Person> createDummyPersonalInfos(int n) {

        List<Person> customers = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> customers.add(createPersonalInfo()));
        return customers;
    }

    public Person createPersonalInfo() {

        Person person = Person.create();
        
        person.setLastName(nameGenerator.getNextRandomLastName());
        person.setAddress(addressGenerator.nextRandomAddress());
        person.setPhone(DummyPhone.generateNumString());
        
        if (!isFemale()) {
            person.setFirstName(nameGenerator.getNextRandomMaleName());
            person.setMiddleName(nameGenerator.getNextRandomMaleName());
            person.setLegalId(personalIdGenerator.createFemaleLegalId10Digits());
        } else {
            person.setFirstName(nameGenerator.getNextRandomFemaleName());
            person.setMiddleName(nameGenerator.getNextRandomFemaleName());
            person.setLegalId(personalIdGenerator.createMaleLegalId10Digits());
        }
       
         person.setEmail(DummyEmail.create(person));
      
        return person;
    }

    private static boolean isFemale() {
        return ThreadLocalRandom.current().nextInt(2) == 0;
    }
    
}
