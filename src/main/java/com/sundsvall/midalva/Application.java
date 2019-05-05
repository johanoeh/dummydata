package com.sundsvall.midalva;

import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.model.Person;
import com.sundsvall.midalva.gen.PersonGenerator;
import java.io.IOException;
import java.util.List;


/**
 * @author ohhhhjoh
 */
public class Application {
    
    public static void main(String[] args) throws IOException {
        

        PersonGenerator gen = new PersonGenerator(new DAO("females.txt", "males.txt", "lastnames.txt", "address.csv"));
        List<Person> customers = gen.getCustomers(100);
        
        customers.forEach(s -> System.out.println(s.toString()));
    }
    
}
