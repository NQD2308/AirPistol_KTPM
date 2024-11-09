/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.models;

import java.util.stream.IntStream;
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
    
    // Kiểm tra điểm hợp lệ và xếp hạng hợp lệ
//    @Test
//    public void testValidScoreAndWorldRank() {
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        //        Test case 18
//        assertEquals(500.0, athlete.getScore(), 0.1, "Điểm phải hợp lệ trong phạm vi.");
//        
//        //        Test case 19
//        assertEquals(10, athlete.getWorldRank(), "Xếp hạng thế giới phải hợp lệ.");
//    }
//    
//    // Kiểm tra điểm không hợp lệ (âm)
//    @Test
//    public void testInvalidScoreNegative() {
//        //        Test case 20
//        assertThrows(IllegalArgumentException.class, () -> {
//            new Athlete(2, "Jane", "Smith", "USA", -10.0, 15);
//        }, "Điểm không thể là số âm.");
//    }
//    
//    // Kiểm tra điểm vượt quá giới hạn
//    @Test
//    public void testInvalidScoreAboveLimit() {
//        //        Test case 21
//        assertThrows(IllegalArgumentException.class, () -> {
//            new Athlete(3, "Alice", "Brown", "USA", 700.0, 20);
//        }, "Điểm không thể vượt quá giới hạn tối đa là 654.0.");
//    }
//    
//    // Kiểm tra xếp hạng không hợp lệ (âm)
//    @Test
//    public void testInvalidWorldRankNegative() {
//        //        Test case 22
//        assertThrows(IllegalArgumentException.class, () -> {
//            new Athlete(4, "Tom", "Wilson", "USA", 300.0, -5);
//        }, "Xếp hạng thế giới phải là số nguyên dương.");
//    }
//    
//    // Kiểm tra xếp hạng bằng 0 (không hợp lệ)
//    @Test
//    public void testInvalidWorldRankZero() {
//        //        Test case 23
//        assertThrows(IllegalArgumentException.class, () -> {
//            new Athlete(5, "Bob", "Johnson", "USA", 200.0, 0);
//        }, "Xếp hạng thế giới không thể là 0.");
//    }
//    
//    // Kiểm tra vận động viên có đúng 60 phát bắn hợp lệ
//    @Test
//    public void testValidShotCount() {
//        //        Test case 29
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//
//        // Thêm 60 phát bắn hợp lệ
//        IntStream.range(0, 60).forEach(i -> athlete.addShot(10.0)); // Mỗi phát bắn giả định có điểm 10.0
//        assertTrue(athlete.hasValidShotCount(), "Mỗi vận động viên phải có đúng 60 phát bắn.");
//        assertEquals(60, athlete.getShots().size(), "Số lượng phát bắn phải là 60.");
//    }
//    
//    // Kiểm tra vận động viên với ít hơn 60 phát bắn (không hợp lệ)
//    @Test
//    public void testInvalidShotCountLessThan60() {
//        //        Test case 30
//        Athlete athlete = new Athlete(2, "Jane", "Smith", "Canada", 450.0, 20);
//
//        // Thêm 59 phát bắn (không đủ 60 phát bắn)
//        IntStream.range(0, 59).forEach(i -> athlete.addShot(9.5));
//        assertFalse(athlete.hasValidShotCount(), "Vận động viên có ít hơn 60 phát bắn không hợp lệ.");
//    }
//    
//    // Kiểm tra vận động viên với hơn 60 phát bắn (không hợp lệ)
//    @Test
//    public void testInvalidShotCountMoreThan60() {
//        //        Test case 31
//        Athlete athlete = new Athlete(3, "Ivan", "Ivanov", "Russia", 480.0, 5);
//
//        // Thêm 60 phát bắn hợp lệ
//        IntStream.range(0, 60).forEach(i -> athlete.addShot(9.0));
//
//        // Thêm phát bắn thứ 61 để kiểm tra ngoại lệ
//        assertThrows(IllegalArgumentException.class, () -> athlete.addShot(10.0), 
//            "Không thể thêm quá 60 phát bắn cho mỗi vận động viên.");
//    }
//    
//    // Test bắn trúng vòng 10
//    @Test
//    public void testHitRing10() {
//        //        Test case 32
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(10.9, athlete.calculateScore(5.5), 0.1, "Phát bắn trong vòng 10 phải đạt điểm 10.9");
//    }
//    
//    // Test bắn trúng vòng 9
//    @Test
//    public void testHitRing9() {
//        //        Test case 33
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(9.0, athlete.calculateScore(12.5), 0.1, "Phát bắn trong vòng 9 phải đạt điểm 9.0");
//    }
//
//    // Test bắn trúng vòng 8
//    @Test
//    public void testHitRing8() {
//        //        Test case 34
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(8.0, athlete.calculateScore(20.0), 0.1, "Phát bắn trong vòng 8 phải đạt điểm 8.0");
//    }
//
//    // Test bắn trúng vòng 7
//    @Test
//    public void testHitRing7() {
//        //        Test case 35
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(7.0, athlete.calculateScore(27.5), 0.1, "Phát bắn trong vòng 7 phải đạt điểm 7.0");
//    }
//
//    // Test bắn trúng vòng 6
//    @Test
//    public void testHitRing6() {
//        //        Test case 36
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(6.0, athlete.calculateScore(35.5), 0.1, "Phát bắn trong vòng 6 phải đạt điểm 6.0");
//    }
//
//    // Test bắn trúng vòng 5
//    @Test
//    public void testHitRing5() {
//        //        Test case 37
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(5.0, athlete.calculateScore(43.5), 0.1, "Phát bắn trong vòng 5 phải đạt điểm 5.0");
//    }
//
//    // Test bắn trúng vòng 4
//    @Test
//    public void testHitRing4() {
//        //        Test case 38
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(4.0, athlete.calculateScore(51.5), 0.1, "Phát bắn trong vòng 4 phải đạt điểm 4.0");
//    }
//
//    // Test bắn trúng vòng 3
//    @Test
//    public void testHitRing3() {
//        //        Test case 39
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(3.0, athlete.calculateScore(59.5), 0.1, "Phát bắn trong vòng 3 phải đạt điểm 3.0");
//    }
//
//    // Test bắn trúng vòng 2
//    @Test
//    public void testHitRing2() {
//        //        Test case 40
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(2.0, athlete.calculateScore(67.5), 0.1, "Phát bắn trong vòng 2 phải đạt điểm 2.0");
//    }
//
//    // Test bắn trúng vòng 1
//    @Test
//    public void testHitRing1() {
//        //        Test case 41
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(1.0, athlete.calculateScore(75.0), 0.1, "Phát bắn trong vòng 1 phải đạt điểm 1.0");
//    }
//
//    // Test bắn trượt mục tiêu (0 điểm)
//    @Test
//    public void testMissTarget() {
//        //        Test case 42
//        Athlete athlete = new Athlete(1, "John", "Doe", "USA", 500.0, 10);
//        assertEquals(0.0, athlete.calculateScore(80.0), 0.1, "Phát bắn trượt mục tiêu phải có điểm 0");
//    }
}
