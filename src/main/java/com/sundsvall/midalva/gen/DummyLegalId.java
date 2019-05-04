package com.sundsvall.midalva.gen;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author johan
 */
public class DummyLegalId {

    private static final String DATE_FORMAT = "yyMMdd";
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static int getBirthYear() {
        return LocalDate.now().getYear() - ThreadLocalRandom.current().nextInt(18, 100);
    }

    public static int getBirthMonth() {
        return ThreadLocalRandom.current().nextInt(1, 13);
    }

    public static int getRandomOddNumber() {
        return 2 * ThreadLocalRandom.current().nextInt(0, 4) + 1;
    }
    
    public static int getRandomEvenNumber(){
        return 2 * ThreadLocalRandom.current().nextInt(0, 4);
    }

    public static String getLastDigits() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(0, 10));
        }
        return sb.toString();
    }

    public static int checkSum(String birthStr) {

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
        sum = values.stream().map((value) -> value / 10 + value % 10).reduce(sum, Integer::sum);
        return (10 - sum % 10)%10;
    }

    public static String createDummyLegalId() {
        YearMonth yearMonth = YearMonth.of(getBirthYear(), getBirthMonth());
        int randomDayInMonth = ThreadLocalRandom.current().nextInt(1, yearMonth.lengthOfMonth() + 1);
        LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), randomDayInMonth);
        return localDate.format(dtf) + "-" + getLastDigits();
    }
    
    public static String createFemaleLegalId(){
        String dummyLegalId = createDummyLegalId()+getRandomEvenNumber();
        return dummyLegalId+checkSum(dummyLegalId.replace("-",""));
    }
    
    
    public static String createMaleLegalId(){
        String dummyLegalId = createDummyLegalId()+getRandomOddNumber();
        return dummyLegalId+checkSum(dummyLegalId.replace("-",""));
    }

}
