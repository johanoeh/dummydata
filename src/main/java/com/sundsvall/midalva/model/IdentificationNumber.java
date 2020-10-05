package com.sundsvall.midalva.model;

public class CustomerIdentificationnumber {

    Integer birthDate;
    Integer lastFourDigits;

    @Override
    public String toString(){
        return String.valueOf(birthDate).concat(String.valueOf(lastFourDigits));
    }
}
