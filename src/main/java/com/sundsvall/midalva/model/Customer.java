
package com.sundsvall.midalva.model;

import java.util.Optional;

/**
 *
 * @author ohhhhjoh
 */
public class Customer {
    
    private String firstName;
    private String lastName;
    private Address address;
    private Optional<String> middleName = Optional.empty();
    private Optional<String> phone = Optional.empty();
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Optional<String> getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Optional<String> middleName) {
        this.middleName = middleName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Optional<String> getPhone() {
        return phone;
    }

    public void setPhone(Optional<String> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Customer[ firstname=%s, middleName=%s ,lastName=%s, phone=%s, ]", firstName, middleName, lastName, phone)+"\n\t" +address;
    }
    
    
  
}
