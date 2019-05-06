package com.sundsvall.midalva;

import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.model.Person;
import com.sundsvall.midalva.gen.DummyPersonalInfoGenerator;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * @author ohhhhjoh
 */
public class Application {


    
    public static void main(String[] args) throws IOException {


        String[] array = { "Geeks", "for", "Geeks" };

        Optional<String> reduce = Arrays.stream(array).reduce((s1, s2) -> s1 + s2);
        System.out.println(reduce.get());

        DummyPersonalInfoGenerator gen = new DummyPersonalInfoGenerator(new DAO("females.txt", "males.txt", "lastnames.txt", "address.csv"));
        List<Person> customers = gen.createDummyPersonalInfos(100);
        List<Person> persons = customers.stream().filter(person -> person.getFirstName().equalsIgnoreCase("mohamed") || person.getMiddleName().equalsIgnoreCase("mohamed"))
                .collect(Collectors.toList());
        persons.forEach(person->System.out.println(person));

    }
    
}
