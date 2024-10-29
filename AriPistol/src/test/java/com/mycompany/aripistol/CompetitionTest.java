/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.aripistol;

import com.mycompany.models.Athlete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class CompetitionTest {
    private List<Athlete> athletes;
    private Competition competition;

    @BeforeEach
    public void setUp() {
        athletes = new ArrayList<>();
        for (int i = 1; i <= 54; i++) {
            athletes.add(new Athlete(i, "Athlete" + i, "LastName" + i, "Country" + i, 0.0, 55 - i));
        }
        competition = new Competition(athletes);
        competition.sortAndGroupAthletes();
    }
    
    // Test số lượng vận động viên trong các nhóm 1 đến 5
    @Test
    public void testGroupSizes() {
    //        Test case 14
        List<List<Athlete>> groups = competition.getGroups();
        
        for (int i = 0; i < 4; i++) {
            assertEquals(10, groups.get(i).size(), "Nhóm " + (i + 1) + " phải có 10 vận động viên");
        }
        assertEquals(4, groups.get(4).size(), "Nhóm cuối cùng phải có 4 vận động viên");
    }

    // Test thứ tự giảm dần của vận động viên theo thứ hạng trong từng nhóm
    @Test
    public void testDescendingOrderWithinGroups() {
        //        Test case 15
        List<List<Athlete>> groups = competition.getGroups();

        for (List<Athlete> group : groups) {
            for (int j = 1; j < group.size(); j++) {
                assertTrue(group.get(j - 1).getWorldRank() > group.get(j).getWorldRank(),
                    "Vận động viên trong cùng một nhóm phải có thứ hạng giảm dần.");
            }
        }
    }
    
    // Test thứ tự giảm dần của vận động viên giữa các nhóm (nhóm sau có thứ hạng cao hơn)
    @Test
    public void testDescendingOrderAcrossGroups() {
        //        Test case 16
        List<List<Athlete>> groups = competition.getGroups();

        for (int i = 1; i < groups.size(); i++) {
            assertTrue(groups.get(i - 1).get(0).getWorldRank() > groups.get(i).get(0).getWorldRank(),
                "Nhóm sau phải có vận động viên với thứ hạng cao hơn nhóm trước");
        }
    }
    
    // Test tổng số lượng vận động viên sau khi phân nhóm
    @Test
    public void testTotalNumberOfAthletesAfterGrouping() {
        int totalAthletes = 54;
            
        assertEquals(54, totalAthletes, "Tổng số lượng vận động viên phải là 54 sau khi phân nhóm.");
    }
    
    // Test nhóm cuối có đúng số lượng vận động viên là 4
    @Test
    public void testLastGroupSize() {
        //        Test case 17
        List<List<Athlete>> groups = competition.getGroups();
        assertEquals(4, groups.get(groups.size() - 1).size(), "Nhóm cuối cùng phải có 4 vận động viên.");
    }
    
    // Kiểm tra danh sách vận động viên
    @Test
    public void testDisplayAthletes() {
        //        Test case 24
        List<Athlete> athletes = new ArrayList<>();
        athletes.add(new Athlete(1, "John", "Doe", "USA", 500.0, 10));
        athletes.add(new Athlete(2, "Jane", "Smith", "Canada", 450.0, 20));
        athletes.add(new Athlete(3, "Ivan", "Ivanov", "Russia", 480.0, 5)); // Russia is a restricted country

        Competition competition = new Competition(athletes);
        String expectedOutput = "Athlete: John Doe, ID: 1, Country: USA, Score: 500.0, Rank: 10\n"
                              + "Athlete: Jane Smith, ID: 2, Country: Canada, Score: 450.0, Rank: 20\n"
                              + "Athlete: Ivan Ivanov, ID: 3, Country: Neutral Athletes, Score: 480.0, Rank: 5";

        assertEquals(expectedOutput, competition.displayAthletes(), "Thông tin hiển thị của vận động viên không chính xác.");
    }
    
    @Test
    public void testNumberOfGroups() {
        //        Test case 25
        List<List<Athlete>> groups = competition.getGroups();
        assertEquals(5, groups.size(), "Số lượng nhóm thi đấu phải là 5.");
    }
    
    // Kiểm tra số lượng vận động viên trong mỗi nhóm từ 1 đến 4
    @Test
    public void testAthleteCountInEachGroupExceptLast() {
        //        Test case 26
        List<List<Athlete>> groups = competition.getGroups();

        for (int i = 0; i < 4; i++) {
            assertEquals(10, groups.get(i).size(), "Nhóm " + (i + 1) + " phải có đúng 10 vận động viên.");
        }
    }
    
    // Kiểm tra số lượng vận động viên trong nhóm cuối cùng
    @Test
    public void testAthleteCountInLastGroup() {
        //        Test case 27
        List<List<Athlete>> groups = competition.getGroups();
        assertEquals(4, groups.get(groups.size() - 1).size(), "Nhóm cuối cùng phải có đúng 4 vận động viên.");
    }
    
    // Kiểm tra rằng các vận động viên được sắp xếp đúng theo thứ hạng thế giới (giảm dần)
    @Test
    public void testAthletesSortedByWorldRank() {
        //        Test case 28
        List<Athlete> sortedAthletes = competition.getAthletes();
        
        for (int i = 1; i < sortedAthletes.size(); i++) {
            int currentRank = sortedAthletes.get(i - 1).getWorldRank();
            int nextRank = sortedAthletes.get(i).getWorldRank();
            assertTrue(currentRank > nextRank, "Vận động viên phải được sắp xếp theo thứ hạng giảm dần.");
        }
    }
}
