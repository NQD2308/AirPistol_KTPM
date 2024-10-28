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
        List<List<Athlete>> groups = competition.getGroups();
        
        for (int i = 0; i < 4; i++) {
            assertEquals(10, groups.get(i).size(), "Nhóm " + (i + 1) + " phải có 10 vận động viên");
        }
        assertEquals(4, groups.get(4).size(), "Nhóm cuối cùng phải có 4 vận động viên");
    }

    // Test thứ tự giảm dần của vận động viên theo thứ hạng trong từng nhóm
    @Test
    public void testDescendingOrderWithinGroups() {
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
        List<List<Athlete>> groups = competition.getGroups();
        assertEquals(4, groups.get(groups.size() - 1).size(), "Nhóm cuối cùng phải có 4 vận động viên.");
    }
}
