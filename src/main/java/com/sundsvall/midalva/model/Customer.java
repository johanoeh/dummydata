
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
    private String email;
    private Optional<String> middleName = Optional.empty();
    private Optional<String> phone = Optional.empty();

    private Customer(){
        
    }
    
    
     public static Customer create() {
        return new Customer();
    }

    
    
     public Customer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Customer withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    
    public Customer withEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer withAddress(Address address) {
        this.address = address;
        return this;
    }

    public Customer withMiddleName(Optional<String> middleName) {
        this.middleName = middleName;
        return this;
    }

    public Customer withPhone(Optional<String> phone) {
        this.phone = phone;
        return this;
    }
    
   
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

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    /* @Override
    public String toString() {
    return String.format("Customer[ firstname=%s, middleName=%s ,lastName=%s, phone=%s, ]", firstName, middleName, lastName, phone)+"\n\t" +address;
    }*/

    @Override
    public String toString() {
        return "Customer{" +
                "firstName=" + firstName +
                ", middleName=" +middleName +
                ", lastName=" + lastName + 
                ", email=" + email + 
                ", phone=" + phone +
                ", address=" + address
           + '}';
    }
    
    
  
}
