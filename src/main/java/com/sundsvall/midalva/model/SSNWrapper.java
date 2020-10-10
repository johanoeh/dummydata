package com.sundsvall.midalva.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SSNWrapper {

    private LocalDate birtDate;
    private String ssnPart;
    private String lastFourDigits;

    private static final DateTimeFormatter DTF_10 = DateTimeFormatter.ofPattern("yyMMdd");
    private static final DateTimeFormatter DTF_12 = DateTimeFormatter.ofPattern("yyyyMMdd");

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(LocalDate birtDate) {
        this.birtDate = birtDate;
    }

    public String getSsnPart() {
        return ssnPart;
    }

    public void setSsnPart(String ssnPart) {
        this.ssnPart = ssnPart;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getSSN10Digits() {
        return DTF_10.format(birtDate).concat(lastFourDigits);
    }

    public String getSSN12Digits() {
        return DTF_12.format(birtDate).concat(lastFourDigits);
    }

}