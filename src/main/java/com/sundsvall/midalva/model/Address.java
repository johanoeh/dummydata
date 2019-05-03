/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.model;

/**
 *
 * @author ohhhhjoh
 */
public class Address {

    private String postalNumber;
    private String postalAddress;
    private String address;

    public Address() {
    }
  
    public Address(String postalNumber, String postalAddress, String address) {
        
        this.postalNumber = postalNumber;
        this.postalAddress = postalAddress;
        this.address = address;
    }

    /**
     * @return the postalNumber
     */
    public String getPostalNumber() {
        return postalNumber;
    }

    /**
     * @param postalNumber the postalNumber to set
     */
    public void setPostalNumber(String postalNumber) {
        this.postalNumber = postalNumber;
    }

    /**
     * @return the postalAddress
     */
    public String getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress the postalAddress to set
     */
    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" + 
                    "postalAddress=" + postalAddress +
                    ", postalNumber=" + postalNumber + 
                    ", address=" + address 
                + '}';
    }




}
