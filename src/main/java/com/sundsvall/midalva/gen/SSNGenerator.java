package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Gender;
import com.sundsvall.midalva.model.SSNWrapper;
import com.sundsvall.midalva.utils.PersonalIdUtil;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author johan
 */
public class SSNGenerator {

    private static final DateTimeFormatter DTF_10 = DateTimeFormatter.ofPattern("yyMMdd");

    public static int getBirthYear(int minAge, int maxAge) {
        return LocalDate.now().getYear() - ThreadLocalRandom.current().nextInt(minAge, maxAge);
    }

    /**
     * Creates a Wrapper for ssn and initializes values randomly
     * @return
     */
     static SSNWrapper createSSNWrapper(int minAge, int maxAge) {

        SSNWrapper ssnWrapper = new SSNWrapper();
        YearMonth yearMonth = YearMonth.of(getBirthYear(minAge,maxAge), getRandomBirthMonth());
        int randomDayInMonth = ThreadLocalRandom.current().nextInt(1, yearMonth.lengthOfMonth() + 1);
        LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), randomDayInMonth);
        ssnWrapper.setBirtDate(localDate);
        ssnWrapper.setSsnPart(localDate.format(DTF_10).concat(generateRandomFirstTwoOfLastFourDigits()));
        return ssnWrapper;
    }

    public static SSNWrapper createSSN(Gender gender, int minAge, int maxAge ){

        SSNWrapper wrapper = createSSNWrapper(minAge,maxAge);
        // Create and append a single random gender digit odd for male even female
        String ssnPart = wrapper.getSsnPart().concat(getSingleRandomGenderDigit(gender));
        ssnPart = ssnPart + PersonalIdUtil.checksumFirstNineDigits(ssnPart);
        String lastFourDigits = ssnPart.substring(6, 10);
        wrapper.setLastFourDigits(lastFourDigits);
       return wrapper;
    }


    static String getSingleRandomGenderDigit(Gender gender){
       return String.valueOf(gender == Gender.FEMALE ? getRandomEvenNumber(): getRandomOddNumber());
    }

    /**
     * Returns a random moth as an integer range 1-12
     * @return
     */
    public static int getRandomBirthMonth() {
        return ThreadLocalRandom.current().nextInt(1, 13);
    }

    /**
     * Creates a random odd gender digit in range 1-9
     * @return
     */
    public static int getRandomOddNumber() {
        return 2 * ThreadLocalRandom.current().nextInt(0, 4) + 1;
    }

    /**
     * Creates a random even gender digit in range 1-9
     * @return
     */
    public static int getRandomEvenNumber() {
        return 2 * ThreadLocalRandom.current().nextInt(0, 4);
    }

    /**
     * Generates a two digit number randomly
     * @return String
     */
    public static String generateRandomFirstTwoOfLastFourDigits() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(0, 10));
        }
        return sb.toString();
    }
}
