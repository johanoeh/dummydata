package com.sundsvall.midalva.facade;


import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.gen.SSNGeneratorFacade;
import com.sundsvall.midalva.gen.PersonalInfoGenerator;
import com.sundsvall.midalva.model.Person;

import java.util.List;

public class DummyDataFacade {

    private PersonalInfoGenerator gen = new PersonalInfoGenerator(
            DAO.create()
                    .withFemaleNameFile("females.txt")
                    .withMaleNameFile("males.txt")
                    .withLastNameFile("lastnames.txt")
                    .withAddressFile("address.csv"));

    private final SSNGeneratorFacade SSNGeneratorFacade = new SSNGeneratorFacade();

    public String createRandomDummmyLegalId() {
        return SSNGeneratorFacade.createRandomSSN();
    }

    public List<Person> createDummyPersonalInfo(int numOfEntries) {

        return gen.createDummyPersonalInfos(numOfEntries);
    }

}
