/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author caah_
 */
public class Country {
    private String name;
    private String initials;
    private int telephoneCode; //Código de área internacional
    
    public Country(String name , String initials, int ddi){
        this.name = name;
        this.initials = initials;
        this.telephoneCode = ddi;
    }
    
    public Country (){}
    
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

    /**
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * @param initials the initials to set
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getTelephoneCode(){
       return this.telephoneCode;
    }
    
    public void setTelephoneCode(int ddi){
         this.telephoneCode = ddi;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
