package com.sundsvall.midalva.facade;

import com.sundsvall.midalva.model.Person;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class DummyDataFacadeTest extends TestCase {

    DummyDataFacade facade = new DummyDataFacade();

    public void testCreateRandomDummmyLegalId() {

    }

    public void testCreateDummyPersonalInfo() {

        List<Person> dummyPersonalInfo = facade.createDummyPersonalInfo(72);
        Assert.assertEquals(dummyPersonalInfo.size(),72);

        dummyPersonalInfo.forEach(System.out::println);

    }
}