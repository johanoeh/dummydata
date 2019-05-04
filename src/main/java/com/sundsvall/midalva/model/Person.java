package com.sundsvall.midalva.model;

/**
 *
 * @author ohhhhjoh
 */
public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private Address address;
    private String email; 
    private String phone;
    private String legalId;

    private Person() {
    }
    
    public static Person create() {
        return new Person();
    }


    public Person withLegalId(String legalId) {
        this.legalId = legalId;
        return this;
    }

    public Person withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Person withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person withEmail(String email) {
        this.email = email;
        return this;
    }

    public Person withAddress(Address address) {
        this.address = address;
        return this;
    }

    public Person withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Person withPhone(String phone) {
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
        public String getLegalId() {
        return legalId;
    }

    public void setLegalId(String legalId) {
        this.legalId = legalId;
    }
    

    @Override
    public String toString() {
        return "Person{"
                + "firstName=" + firstName
                + ", middleName=" + middleName
                + ", lastName=" + lastName
                + ", email=" + email
                + ", phone=" + phone
                + ", address=" + address
                + '}';
    }

}
