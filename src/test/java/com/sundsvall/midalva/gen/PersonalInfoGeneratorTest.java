package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.dao.DAO;
import com.sundsvall.midalva.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DummyPersonalInfoGeneratorTest {

    @Test
    public void createDummyPersonalInfos() {
        DummyPersonalInfoGenerator dummyPersonalInfoGenerator = new DummyPersonalInfoGenerator(new DAO("females.txt", "males.txt", "lastnames.txt", "address.csv") );
        List<Person> dummyPersonalInfos = dummyPersonalInfoGenerator.createDummyPersonalInfos(100);
        Assert.assertEquals(dummyPersonalInfos.size(),100);
    }
}