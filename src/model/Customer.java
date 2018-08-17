/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author caah_
 */
public class Customer {

    private String name;
    private Date birthDate;
    private String telephone;
    private float creditLimit;
    private Country country;
    
    public Customer(String name, Date birthDate , String telephone , Country country){
        this.name = name;
        this.birthDate = birthDate;
        this.telephone = telephone;
        this.creditLimit = this.generateLimitCredit(this.calcAge(birthDate), country.getName());
        this.country = country;
    }
    public Customer() {
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    /**
     * @return the telphone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telphone the telphone to set
     */
    public void setTelephone(String telphone) {
        this.telephone = telphone;
    }

    /**
     * @return the creditLimit
     */
    public float getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param creditLimit the creditLimit to set
     */
    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    public int calcAge(Date date) {

        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(date);
        Calendar hoje = Calendar.getInstance();

        int age = hoje.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)) {
            age--;
        } else {
            if (hoje.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH)
                    && hoje.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH)) {
                age--;
            }
        }

        return age;
    }

    public float generateLimitCredit(int age, String country) {

        float limit = 0;

        if (age < 18) {
            limit += 100;

        } else if (age > 17 && age <= 35) {
            limit += 300;
        } else {
            limit += 500;
        }

        if ("Brasil".equals(country)) {
            limit += 100;
        }
        return limit;
    }
    
}
