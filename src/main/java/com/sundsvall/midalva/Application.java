package com.sundsvall.midalva;

import com.sundsvall.midalva.model.Address;
import com.sundsvall.midalva.model.Customer;
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
    
    private static void printMSISDN(List<String> msisdns){
        String tmp ="{ ";
        
        for (String msisdn : msisdns) { 
            tmp+=("\""+msisdn+"\",\n");
        }
        tmp = tmp.substring(0, tmp.lastIndexOf(","));
        tmp+= "\n}";
        
        System.out.print(tmp);
   }

    public static void main(String[] args) throws IOException {

        CustomerGenerator gen = new CustomerGenerator();
        List<Customer> customers = gen.getCustomers(100);

        customers.forEach(s->System.out.println(s.toString()));

        IntStream.range(0,100).mapToObj(i -> new Customer()).forEach(customer -> {
            customer.setFirstName("Carl"); customer.setLastName("Carlsson"); System.out.println("created customer");
        });

        String a ="Hello world";
        a.startsWith("h");



        /*MSISDNMockData mock = new MSISDNMockData();
        List<String> msisdn = mock.getMSISDN(20);
        printMSISDN(msisdn);*/

        
       /* DAO dao = new DAO("name.csv", "lastname.csv");
        NameGenerator ng = new NameGenerator(dao.getFirstNames(), dao.getLastNames(), dao.getFirstNames());
        for (int i = 0; i < 100; i++) {
            System.out.println(ng.getNextRandomFirstName()+" : "+ ng.getNextRandomMiddleName()+ " : "+ ng.getNextRandomLastName());
        }*/
        

        /*List<String> myList = Stream.of("a", "b")
        .map(String::toUpperCase)
        .collect(Collectors.toList());
        List<String> collect = myList.stream().map((string) -> {
        return string.toUpperCase().concat("x");
        }).collect(Collectors.toList());
        System.out.println(collect);
        Customer customer = new Customer();
        //customer.setMiddleName(Optional.of("Gustav"));
        System.out.println(customer.getMiddleName());*/
    }

}
