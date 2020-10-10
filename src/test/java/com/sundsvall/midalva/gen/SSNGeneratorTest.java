package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Gender;
import com.sundsvall.midalva.model.SSNWrapper;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SSNGeneratorTest extends TestCase {


    public void testCreateDummyLegalId() {
    }

    @Test
    public void testCreateDummyFemaleLegalId() {
        for (int i = 0; i < 10000; i++) {
            SSNWrapper wrapper = SSNGenerator.createSSN(Gender.FEMALE,18,100);
            String ssn10Digits = wrapper.getSSN10Digits();
            boolean isEven = Integer.parseInt(String.valueOf(ssn10Digits.charAt(8))) % 2 == 0;
            Assert.assertTrue(isEven);
            Assert.assertEquals(ssn10Digits.length(),10);
            Assert.assertEquals(wrapper.getSSN12Digits().length(),12);
        }
    }

    public void testCreateDummyMaleLegalId() {

        for (int i = 0; i < 10000; i++) {
            SSNWrapper wrapper = SSNGenerator.createSSN(Gender.MALE,18,100);
            String ssn10Digits = wrapper.getSSN10Digits();
            boolean isEven = Integer.parseInt(String.valueOf(ssn10Digits.charAt(8))) % 2 == 0;
            Assert.assertFalse(isEven);
            Assert.assertEquals(ssn10Digits.length(),10);
            Assert.assertEquals(wrapper.getSSN12Digits().length(),12);
        }
    }
}