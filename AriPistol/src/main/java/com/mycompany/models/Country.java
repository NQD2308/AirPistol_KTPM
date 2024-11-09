/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

/**
 *
 * @author ASUS
 */
public class Country {
    
    private String name;
    private Boolean isLimit;
    
    public Country(String name, Boolean isLimit) {
        this.name = name;
        this.isLimit = isLimit;
        
        if(this.isLimit) {
            this.name = "Neutral Athletes";
        }
        
        
    }
    
    public String getName() { return name; }
    
    static boolean isValidCountry(String name) {
        return name != null && name.matches("^[A-Za-z\\s]{1,50}$");
    }
}
