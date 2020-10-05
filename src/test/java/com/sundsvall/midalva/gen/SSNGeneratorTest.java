package com.sundsvall.midalva.gen;

import junit.framework.TestCase;
import org.junit.Test;

public class DummyLegalIdTest extends TestCase {


    public void testCreateDummyLegalId() {
    }

    @Test
    public void testCreateDummyFemaleLegalId() {
        for (int i = 0; i < 100; i++) {
            System.out.println(DummyLegalId.createDummyFemaleLegalId());
        }
    }

    public void testCreateDummyMaleLegalId() {
    }
}