package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Customer;
import com.sundsvall.midalva.dao.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class CustomerGenerator {

    public static final String FIRST_NAME_FILE = "";

    private final NameGenerator nameGenerator;
    private final AddressGenerator addressGenerator;
    private final DAO dao = new DAO("females.txt","males.txt", "lastname.txt", "address.csv");

    public CustomerGenerator() throws IOException {

        nameGenerator = new NameGenerator(dao.getMaleNames(), dao.getFemaleNames(), dao.getLastNames());
        addressGenerator = new AddressGenerator(dao.getAdrresses());
    }

    public List<Customer> getCustomers(int n) {

        List<Customer> customers = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> customers.add(createCustomer()));
        return customers;
    }

    public Customer createCustomer() {

        Customer customer = Customer.create();
        if (!isFemale()) {
            customer.setFirstName(nameGenerator.getNextRandomMaleName());
            customer.setMiddleName(Optional.of(nameGenerator.getNextRandomMaleName()));
        } else {
            customer.setFirstName(nameGenerator.getNextRandomFemaleName());
            customer.setMiddleName(Optional.of(nameGenerator.getNextRandomFemaleName()));
        }
        customer.setLastName(nameGenerator.getNextRandomLastName());
       
        customer.setAddress(addressGenerator.nextRandomAddress());
        customer.setPhone(Optional.of(DummyPhone.generateNumString(7, DummyPhone.NumBegin.BEGIN_4670)));

        return customer;
    }

    public static boolean isFemale() {
        return ThreadLocalRandom.current().nextInt(2) == 0;
    }
}
