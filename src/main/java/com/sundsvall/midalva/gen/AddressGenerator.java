package com.sundsvall.midalva.gen;

import com.sundsvall.midalva.model.Address;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AddressGenerator {

    public List<Address> addresses;

    public AddressGenerator(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Address nextRandomAddress() {
        if (addresses.isEmpty()) {
            return null;
        }
        return addresses.get(ThreadLocalRandom.current().nextInt(0, addresses.size()));
    }
}
