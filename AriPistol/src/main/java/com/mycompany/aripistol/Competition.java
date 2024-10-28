/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aripistol;

import com.mycompany.models.Athlete;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Competition {
    private List<Athlete> athletes;
    private List<List<Athlete>> groups;
    
    public Competition(List<Athlete> athletes) {
        this.athletes = athletes;
        this.groups = new ArrayList<>();
    }
    
    // Phương thức sắp xếp vận động viên và phân chia thành các nhóm
    public void sortAndGroupAthletes() {
        athletes.sort(Comparator.comparingInt(Athlete::getWorldRank).reversed());
        
        for (int i = 0; i < 5; i++) {
            int groupSize = (i == 4) ? 4 : 10;
            groups.add(new ArrayList<>(athletes.subList(i * 10, i * 10 + groupSize)));
        }
    }

    public List<List<Athlete>> getGroups() {
        return groups;
    }
}
