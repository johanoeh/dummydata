
package com.sundsvall.midalva.utils;

import com.sundsvall.midalva.model.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author johan
 */
public class PersonalIdUtil {
    
    private static final String DATE_FORMAT = "yyMMdd";
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(DATE_FORMAT);
    
    /**
     * Get age from personalId string
     * @param personalId
     * @return 
     */
    public static long ageFromPersonalId(String personalId){
       String yearMonthDay=personalId.substring(0,6);
       LocalDate birthDate = LocalDate.from(DTF.parse(yearMonthDay));
       LocalDate now = LocalDate.now(); 
       return ChronoUnit.YEARS.between(now,birthDate);     
    }
    /**
     * If digit 9 in the personal number is even the person is a female
     * method should return true else the person is male
     * @param personalId
     * @return 
     */
    public static boolean isFemale(String personalId){
        int genderDigit = Character.getNumericValue(personalId.charAt(8));//even number at pos 8 indicates female
        return genderDigit%2 == 0;
    }
    
    /**
     * calculate the personal id checksum (the last digit in the personal number)
     * from the first 9 digits
     * @param birthStr
     * @return
     */
    public static int checksumFirstNineDigits(String birthStr) {

        List<Integer> values = new ArrayList<>();
        int multiplier = 2;
        int sum = 0;
        
        for (int i = 0; i < birthStr.length(); i++) {
            values.add(multiplier * Character.getNumericValue(birthStr.charAt(i)));
            if (multiplier == 2) {
                multiplier = 1;
            } else {
                multiplier = 2;
            }
        }
        sum = values
                .stream()
                .map((value) -> value / 10 + value % 10)
                .reduce(sum, Integer::sum);

        return (10 - sum % 10) % 10;
    }

    public static Predicate<Person> hasName(String name) {
        return person ->
                person.getLastName().equalsIgnoreCase(name)
                        || person.getFirstName().equalsIgnoreCase(name)
                        || person.getMiddleName().equalsIgnoreCase(name);
    }

    public static Predicate<Person> isOlderThan21() {
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
