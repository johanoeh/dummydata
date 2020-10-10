package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Gender;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author johan
 */
public class SSNGeneratorFacade extends SSNGenerator {

    private final int minAge;
    private final int maxAge;


    public SSNGeneratorFacade(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public SSNGeneratorFacade() {
        minAge = 18;
        maxAge = 100;
    }

    public String createRandomSSN() {
        if (ThreadLocalRandom.current().nextInt(2) == 0) {
            return createSSN(Gender.FEMALE,minAge,maxAge).getSSN10Digits();
        } else {
            return createSSN(Gender.MALE,minAge,maxAge).getSSN10Digits();
        }
    }

    public String createFemaleLegalId10Digits() {
        return createSSN(Gender.FEMALE,minAge,maxAge).getSSN10Digits();
    }

    public String createMaleLegalId10Digits() {
        return createSSN(Gender.MALE,minAge,maxAge).getSSN10Digits();
    }
}
