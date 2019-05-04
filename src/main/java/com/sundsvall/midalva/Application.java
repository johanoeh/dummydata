package com.sundsvall.midalva;

import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.model.Address;
import com.sundsvall.midalva.model.Person;
import com.sundsvall.midalva.gen.CustomerGenerator;
import com.sundsvall.midalva.parser.AddressParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
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

    public static void main(String[] args) throws IOException {

        CustomerGenerator gen = new CustomerGenerator(new DAO("females.txt", "males.txt", "lastnames.txt", "address.csv"));
        List<Person> customers = gen.getCustomers(100);

        customers.forEach(s -> System.out.println(s.toString()));
  
    }

}
