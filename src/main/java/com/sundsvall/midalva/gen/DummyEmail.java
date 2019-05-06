/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Person;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Todo create more strategies for generating emails
 * @author johan
 */
public class DummyEmail {
    
    private final static String [] DOMAINS = {"gmail.com","outlook.com","yahoo.com","aol.com","yandex.com","mail.com"};
    
    public static String create(Person customer,String domain) { 
        return fixName(customer.getFirstName())+"."+fixName(customer.getLastName())+"@"+domain; 
    }

    public static String create(String firstName, String lastName){
        return fixName(firstName)+"."+fixName(lastName)+"@"+getRandomDomain();
    }

    public static String create(Person person) {
        return create(person, getRandomDomain());
    }
    
    public static String getRandomDomain(){
        return DOMAINS[ThreadLocalRandom.current().nextInt(0, DOMAINS.length)];
    }
     
    private static String fixName(String name){
         return name
                 .toLowerCase()
                 .replaceAll("å", "a")
                 .replaceAll("ä", "a")
                 .replaceAll("ö","o");
     }      
}
