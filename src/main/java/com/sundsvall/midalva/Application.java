package com.sundsvall.midalva;

import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.model.Address;
import com.sundsvall.midalva.model.Person;
import com.sundsvall.midalva.gen.CustomerGenerator;
import com.sundsvall.midalva.gen.DummyLegalId;
import com.sundsvall.midalva.parser.AddressParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author ohhhhjoh
 */
public class Application {
    
    private static void printMSISDN(List<String> msisdns) {
        String tmp = "{ ";
        
        for (String msisdn : msisdns) {
            tmp += ("\"" + msisdn + "\",\n");
        }
        tmp = tmp.substring(0, tmp.lastIndexOf(","));
        tmp += "\n}";
        
        System.out.print(tmp);
    }
    
    public static int getRandomOddNumber() {
        return 2 * ThreadLocalRandom.current().nextInt(0, 4) + 1;
    }
    
    public static void main(String[] args) throws IOException {
        
      

           System.out.println("Female: "+DummyLegalId.createFemaleLegalId());
        System.out.println("Male: "+DummyLegalId.createMaleLegalId());
        


        CustomerGenerator gen = new CustomerGenerator(new DAO("females.txt", "males.txt", "lastnames.txt", "address.csv"));
        List<Person> customers = gen.getCustomers(100);
        
        customers.forEach(s -> System.out.println(s.toString()));
    }
    
}
