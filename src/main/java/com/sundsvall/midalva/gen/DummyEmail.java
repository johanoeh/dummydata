/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Todo create more strategies for generating emails
 * @author johan
 */
public class DummyEmail {
    
    public final static String [] DOMAINS = {"gmail.com","outlook.com","yahoo.com","aol.com","yandex.com","mail.com"};
    
    public static String create(Person person,String domain) {
        return fixName(person.getFirstName())+"."+fixName(person.getLastName())+"@"+domain;
    }

    public static String create(String firstName, String lastName){
        return fixName(firstName)+"."+fixName(lastName)+"@"+getRandomDomain(Arrays.asList(DOMAINS));
    }

    public static String create(Person person) {
        return create(person, getRandomDomain(Arrays.asList(DOMAINS)));
    }
    
    public static String getRandomDomain(List<String> domains){
        return domains.get(ThreadLocalRandom.current().nextInt(0, domains.size()));
    }
     
    private static String fixName(String name){
         return name
                 .toLowerCase()
                 .replaceAll("å", "a")
                 .replaceAll("ä", "a")
                 .replaceAll("ö","o");
     }      
}
