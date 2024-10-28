/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.aripistol;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Admin
 */
public class caculatorTest {
    caculator cal;

    public caculatorTest() {
        cal = new caculator();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }

    @Test
    public void testAdd() {
        int expectedResult = 11;
        int actualResult = cal.add(5, 6); 
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testIncorrect() {
        int expectedResult = 10;
        int actualResult = cal.add(5, 6); 
        assertNotEquals(expectedResult, actualResult);
    }
}
