/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caah_
 */
public class Register {

    private final List<Customer> CUSTOMERS = new ArrayList();
    private final List<Country> COUNTRIES = new ArrayList();

    public boolean checkName(String s) {
        if (s.length() < 5) {
            return false;
        }
        return CUSTOMERS.stream().noneMatch((cliente) -> (cliente.getName().equals(s)));
    }

    public boolean checkCountry(String s) {
        return COUNTRIES.stream().noneMatch((pais) -> (pais.getName().equalsIgnoreCase(s)));
    }

    public void addCountry(String name, String initials, int ddi) {
        if (checkCountry(name)) {
            Country country = new Country(name, initials, ddi);
            COUNTRIES.add(country);
        }
    }

    public void addCustomer(Customer client) {
        CUSTOMERS.add(client);
    }

    public List<Customer> getCustomers() {
        return CUSTOMERS;
    }

    public List<Country> getCountries() {
        return COUNTRIES;
    }

}
