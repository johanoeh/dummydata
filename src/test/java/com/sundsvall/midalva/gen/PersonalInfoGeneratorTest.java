package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PersonalInfoGeneratorTest {

    @Test
    public void createDummyPersonalInfos() {
        PersonalInfoGenerator personalInfoGenerator = new PersonalInfoGenerator(new DAO("females.txt", "males.txt", "lastnames.txt", "address.csv") );
        List<Person> dummyPersonalInfos = personalInfoGenerator.createDummyPersonalInfos(100);
        Assert.assertEquals(dummyPersonalInfos.size(),100);
    }
}