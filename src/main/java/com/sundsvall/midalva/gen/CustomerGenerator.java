package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Customer;
import com.sundsvall.midalva.dao.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class CustomerGenerator {

    public static final String FIRST_NAME_FILE ="";

    private final NameGenerator nameGenerator;
    private final AddressGenerator addressGenerator;
    private final DAO dao = new DAO("name.csv", "lastname.csv","address.csv");

    public CustomerGenerator() throws IOException {

        nameGenerator   = new NameGenerator(dao.getNames(), dao.getNames(), dao.getLastNames());
        addressGenerator = new AddressGenerator(dao.getAdrresses());
    }

    public List<Customer> getCustomers(int n){

        List<Customer> customers = new ArrayList<>();
        IntStream.range(0, n).mapToObj(i -> new Customer()).forEach(customer -> {
            customer.setFirstName(nameGenerator.getNextRandomFirstName());
            customer.setLastName(nameGenerator.getNextRandomLastName());
            customer.setMiddleName(Optional.of(nameGenerator.getNextRandomMiddleName()));
            customer.setAddress(addressGenerator.nextRandomAddress());
            customers.add(customer);
        });
        return customers;
    }
}
