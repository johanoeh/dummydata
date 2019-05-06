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
public class DummyPersonalIdGenerator {

    private static final String DATE_FORMAT_10 = "yyMMdd";
    private static final String DATE_FORMAT_12 ="yyyyMMdd";
    private static DateTimeFormatter dtf10 = DateTimeFormatter.ofPattern(DATE_FORMAT_10);
    private static DateTimeFormatter dtf12 = DateTimeFormatter.ofPattern(DATE_FORMAT_12);

    private final int minAge;
    private final int maxAge;

    public DummyPersonalIdGenerator(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public DummyPersonalIdGenerator(){
        minAge =18;
        maxAge = 100;
    }


    public  String createRandomDummyLegalId10Digits(){
        if(ThreadLocalRandom.current().nextInt(2) == 0){
            return createFemaleLegalId10Digits();
        }else{
            return createMaleLegalId10Digits();
        }
    }

    public  String createFemaleLegalId10Digits(){
        String dummyLegalId = prepareDummyLegalId(dtf10)+getRandomEvenNumber();
        return dummyLegalId+checkSum(dummyLegalId.replace("-",""));
    }


    public  String createMaleLegalId10Digits(){
        String dummyLegalId = prepareDummyLegalId(dtf10)+getRandomOddNumber();
        return dummyLegalId+checkSum(dummyLegalId.replace("-",""));
    }

    public  String createFemaleLegalId12Digits(){
        String dummyLegalId = prepareDummyLegalId(dtf12)+getRandomEvenNumber();
        return dummyLegalId+checkSum(dummyLegalId.replace("-",""));
    }


    public  String createMaleLegalId12Digits(){
        String dummyLegalId = prepareDummyLegalId(dtf12)+getRandomOddNumber();
        return dummyLegalId+checkSum(dummyLegalId.replace("-",""));
    }

    public  String createRandomDummyLegalId12Digits(){
        if(ThreadLocalRandom.current().nextInt(2) == 0){
            return createFemaleLegalId12Digits();
        }else{
            return createMaleLegalId12Digits();
        }
    }



    protected  int getBirthYear() {
        return LocalDate.now().getYear() - ThreadLocalRandom.current().nextInt(minAge, maxAge+1);
    }


    protected  int getBirthMonth() {
        return ThreadLocalRandom.current().nextInt(1, 13);
    }

    protected  int getRandomOddNumber() {
        return 2 * ThreadLocalRandom.current().nextInt(0, 4) + 1;
    }
    
    protected  int getRandomEvenNumber(){
        return 2 * ThreadLocalRandom.current().nextInt(0, 4);
    }

    protected  String getFirstTwoOfLastDigits() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(0, 10));
        }
        return sb.toString();
    }

    public  int checkSum(String birthStr) {

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
                .reduce((i1,i2)-> i1+i2).orElse(0);
        return (10 - sum % 10)%10;
    }

    protected  String prepareDummyLegalId(DateTimeFormatter dtf) {

        YearMonth yearMonth = YearMonth.of(getBirthYear(), getBirthMonth());
        int randomDayInMonth = ThreadLocalRandom.current().nextInt(1, yearMonth.lengthOfMonth() + 1);
        LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), randomDayInMonth);
        return localDate.format(dtf) + "-" + getFirstTwoOfLastDigits();
    }


}
