package com.sundsvall.midalva;

import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.model.Person;
import com.sundsvall.midalva.gen.PersonGenerator;
import com.sundsvall.midalva.utils.PersonalIdUtil;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author ohhhhjoh
 */
public class Application {

    public static void main(String[] args) throws IOException {

        PersonGenerator gen = new PersonGenerator(
                new DAO("females.txt", "males.txt", "lastnames.txt", "address.csv"));
        List<Person> persons = gen.getCustomers(1000);
        List<Person> maximiliams = persons
                .stream()
                .filter(hasName("Maximiliam"))
                .filter(isFemale().negate())
                .filter(isOlderThen21())
                .collect(Collectors.toList());
        maximiliams.forEach(customer -> System.out.println(customer));

    }

    public static Predicate<Person> hasName(String name) {
        return person -> 
                        person.getLastName().equalsIgnoreCase(name)
                        || person.getFirstName().equalsIgnoreCase(name)
                        || person.getMiddleName().equalsIgnoreCase(name);
    }

    public static Predicate<Person> isOlderThen21() {
        return isOlderThan(21);
    }

    public static Predicate<Person> isFemale() {
        return person -> PersonalIdUtil.isFemale(person.getLegalId());
    }
    
    public static Predicate<Person> isOlderThan(int age){
        return person -> PersonalIdUtil.ageFromPersonalId(person.getLegalId()) > age;
    } 
    
    public static List<Person> filterPersons(List<Person> persons, Predicate<Person> predicate){
        return persons.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}
