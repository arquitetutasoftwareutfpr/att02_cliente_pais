/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author caah_
 */
public class Register {
    private List<Customer> customers = new ArrayList();
    private List<Country> countries = new ArrayList();
    
    public boolean checkName(String s){
        
        for(Customer cliente : customers){
            if(cliente.getName().equals(s)){
                return true;
            }
        }
        if(s.length() > 5){
            return true;
        }
        
        return false;
    }
    
    public boolean checkCountry(String s){
        
        for(Customer cliente : customers){
            if(cliente.getCountry().getName().equals(s)){
                return true;
            }
        }
        for(Country pais : countries ){
             if(pais.getName().equals(s)){
                 return true;
             }   
        }
        return false;
    }
    public void addCountry(String name , String initials, int ddi){
        try{
            if(!checkCountry(name)){
                Country country = new Country(name, initials, ddi);
                countries.add(country);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Name less than 5 characters or already registered!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void addCustomer(String name, Date birthDate , String telephone , Country country){
        try{
            if(!checkName(name) && checkTelephone(country, telephone)){
                Customer client = new Customer(name, birthDate, telephone, country);
                customers.add(client);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Name less than 5 characters or already registered!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public int getCustomerSize(){
       return customers.size();
    }
    
    public boolean checkTelephone(Country country, String telephone){
        String  ddi = String.valueOf(country.getTelephoneCode());
        if(ddi.equalsIgnoreCase(telephone.substring(0, ddi.length()-2))){
            return true;
        }
        return false;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Country> getCountries() {
        return countries;
    }
    
}

