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
public class PersonGenerator {


    private  NameGenerator nameGenerator;
    private  AddressGenerator addressGenerator;
    
    private final DAO dao;

    public PersonGenerator(DAO dao) {
        this.dao = dao;     
        try {
            nameGenerator = new NameGenerator(dao.getMaleNames(), dao.getFemaleNames(), dao.getLastNames());
            addressGenerator = new AddressGenerator(dao.getAdrresses());
        } catch (IOException ex) {
            Logger.getLogger(PersonGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Person> getCustomers(int n) {
        List<Person> customers = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> customers.add(createCustomer()));
        return customers;
    }

    public Person createCustomer() {

        Person person = Person.create();
        
        person.setLastName(nameGenerator.getNextRandomLastName());
        person.setAddress(addressGenerator.nextRandomAddress());
        person.setPhone(DummyPhone.generateNumString());
        
        if (!isFemale()) {
            person.setFirstName(nameGenerator.getNextRandomMaleName());
            person.setMiddleName(nameGenerator.getNextRandomMaleName());
            person.setLegalId(DummyLegalId.createDummyFemaleLegalId());
        } else {
            person.setFirstName(nameGenerator.getNextRandomFemaleName());
            person.setMiddleName(nameGenerator.getNextRandomFemaleName());
            person.setLegalId(DummyLegalId.createDummyMaleLegalId());
        }
       
         person.setEmail(DummyEmail.create(person));
      
        return person;
    }

    public static boolean isFemale() {
        return ThreadLocalRandom.current().nextInt(2) == 0;
    }
    
}
