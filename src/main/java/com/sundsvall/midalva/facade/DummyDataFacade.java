package com.sundsvall.midalva.facade;


import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.gen.DummyPersonalIdGenerator;
import com.sundsvall.midalva.gen.DummyPersonalInfoGenerator;
import com.sundsvall.midalva.model.Person;

import java.util.List;

public class DummyDataFacade {

    private DummyPersonalInfoGenerator gen = new DummyPersonalInfoGenerator(
            DAO.create()
                    .withFemaleNameFile("females.txt")
                    .withMaleNameFile("males.txt")
                    .withLastNameFile("lastnames.txt")
                    .withAddressFile("address.csv"));

    private final DummyPersonalIdGenerator dummyPersonalIdGenerator = new DummyPersonalIdGenerator();

    public String createRandomDummmyLegalId() {
        return dummyPersonalIdGenerator.createRandomDummyLegalId10Digits();
    }

    public List<Person> createDummyPersonalInfo(int numOfEntries) {

        return gen.createDummyPersonalInfos(numOfEntries);
    }

}
