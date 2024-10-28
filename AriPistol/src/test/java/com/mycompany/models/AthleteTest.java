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
public class AthleteTest {
    
//    public AthleteTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//
//    @Test
//    public void testGetFirstName() {
//    }
//
//    @Test
//    public void testGetLastName() {
//    }
//
//    @Test
//    public void testGetID() {
//    }
//
//    @Test
//    public void testGetCountry() {
//    }
//
//    @Test
//    public void testGetScore() {
//    }
//
//    @Test
//    public void testGetWorldRank() {
//    }
//
//    @Test
//    public void testSetScore() {
//    }
//
//    @Test
//    public void testToString() {
//    }
    
//    Kiểm tra họ và tên   
    @Test
    public void testInvalidName() {
        //        Test case 1
        assertTrue(Athlete.isValidName("Nguyen"), "Tên không hợp lệ: có chứa số");
        
        //        Test case 2
        assertFalse(Athlete.isValidName("Nguyen123"), "Tên không hợp lệ: có chứa số");
        
        //        Test case 3
        assertFalse(Athlete.isValidName("Thu@Vinh"), "Tên không hợp lệ: có chứa ký tự đặc biệt");
        
        //        Test case 4
        assertFalse(Athlete.isValidName(""), "Tên không hợp lệ: rỗng");
    }
    


//    Kiểm tra mã vẫn động viên   
    @Test
    public void testValidAthleteID() {
        //        Test case 5
        assertTrue(Athlete.isValidAthleteID(12345), "Mã số hợp lệ: 12345");
        
        //        Test case 6
        assertFalse(Athlete.isValidAthleteID(1234), "Mã số hợp lệ: 1234");
        
        //        Test case 7
        assertFalse(Athlete.isValidAthleteID(123456), "Mã số hợp lệ: 123456");
        
        //        Test case 8
        assertFalse(Athlete.isValidAthleteID(-1234), "Mã số hợp lệ: -1234");
    }
    
// Kiểm tra quốc gia hợp lệ
    @Test
    public void testValidCountry() {
        //        Test case 9
        assertTrue(Athlete.isValidCountry("Vietnam"), "Quốc gia hợp lệ: Vietnam");
        
        //        Test case 10
        assertFalse(Athlete.isValidCountry("Viet@nam"), "Quốc gia không hợp lệ: có chứa ký tự đặc biệt");
        
        //        Test case 11
        assertFalse(Athlete.isValidCountry("Country123"), "Quốc gia không hợp lệ: có chứa số");
        
        //        Test case 12
        assertFalse(Athlete.isValidCountry(""), "Quốc gia không hợp lệ: rỗng");
    }
    
    //        Kiểm tra các quốc gia bị hạn chế
    @Test
    public void testRestrictedCountryAthlete(){
        //        Test case 13
        Athlete a = new Athlete(1, "A", "Nguyen Van", "Russia", 168, 4, true);
        assertTrue(a.isRestrictedCountry(), "Vận động viên từ quốc gia bị hạn chế phải có restrictedCountry == true");
        assertEquals("Neutral Athletes", a.getCountry(), "Vận động viên từ quốc gia bị hạn chế phải thi đấu dưới danh nghĩa 'Neutral Athletes'");
    }
    
    
}
