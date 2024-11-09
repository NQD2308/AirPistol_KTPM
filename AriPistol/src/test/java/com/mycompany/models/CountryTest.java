/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ASUS
 */
public class CountryTest {
    
    public CountryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }

    @Test
    public void testGetName() {
    }
    
    // Kiểm tra quốc gia hợp lệ
    @Test
    public void testValidCountry() {
        //        Test case 9
        assertTrue(Country.isValidCountry("Vietnam"), "Quốc gia hợp lệ: Vietnam");
    }
    
    @Test
    public void testValidCountryWithSymbol() {
        assertFalse(Country.isValidCountry("Viet@nam"), "Quốc gia không hợp lệ: có chứa ký tự đặc biệt");
    }
    
    @Test
    public void testValidCountryWithNumber() {
        assertFalse(Country.isValidCountry("Country123"), "Quốc gia không hợp lệ: có chứa số");
    }
    
    @Test
    public void testEmptyCountry() {
        assertFalse(Country.isValidCountry(""), "Quốc gia không hợp lệ: rỗng");
    }
    
    //        Kiểm tra các quốc gia bị hạn chế
    @Test
    public void testRestrictedCountryAthlete(){
        //        Test case 13
        Country c = new Country("Russia", true);
        String expect = "Neutral Athletes";
        String actual = c.getName();
        assertEquals(expect, actual);
    }
    
    @Test
    public void testCountryAthlete() {
        Country c = new Country("Vietnam", false);
        String expect = "Neutral Athletes";
        String actual = c.getName();
        assertNotEquals(expect, actual);
    }
}
