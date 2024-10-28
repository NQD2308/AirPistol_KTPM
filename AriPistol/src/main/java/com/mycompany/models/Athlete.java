/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author ASUS
 */
public class Athlete {
    private int id;
    private String firstName;   
    private String lastName;
    private String country;
    private double score;
    private int worldRank;
    private Boolean restrictedCountry;
    
    // Danh sách các quốc gia bị hạn chế
    private static final Set<String> RESTRICTED_COUNTRIES = Set.of("Russia", "Belarus");
    
    // Constructor
    public Athlete(int id, String firstName, String lastName, String country, double score, int worldRank,
    Boolean restrictedCountry){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.score = score;
        this.worldRank = worldRank;
        this.restrictedCountry = RESTRICTED_COUNTRIES.contains(country);
        
        // Nếu vận động viên đến từ quốc gia bị hạn chế, họ sẽ thi đấu dưới danh nghĩa "Neutral Athletes"
        if (this.restrictedCountry) {
            this.country = "Neutral Athletes";
        }
    }
    
    // Constructor
    public Athlete(int id, String firstName, String lastName, String country, double score, int worldRank){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.score = score;
        this.worldRank = worldRank;
        this.restrictedCountry = RESTRICTED_COUNTRIES.contains(country);
        
        // Nếu vận động viên đến từ quốc gia bị hạn chế, họ sẽ thi đấu dưới danh nghĩa "Neutral Athletes"
        if (this.restrictedCountry) {
            this.country = "Neutral Athletes";
        }
    }
    
    // Getters and Setters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getID() { return id; }
    public String getCountry() { return country; }
    public double getScore() { return score; }
    public int getWorldRank() { return worldRank; }
    public void setScore(double score) { this.score = score; }
    public Boolean isRestrictedCountry() { return restrictedCountry; }
    
//    @Override
//    public String toString() {
//        return String.format("Athlete: %s %s, ID: %d, Country: %s, Score: %.1f, Rank: %d",
//            firstName, lastName, id, country, score, worldRank);
//    }
    
    // Kiểm tra tính hợp lệ của tên
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-z\\s]{1,50}$");
    }
    
    // Kiểm tra tính hợp lệ của mã số vận động viên (5 chữ số)
    public static boolean isValidAthleteID(int id) {
        return String.valueOf(id).matches("^\\d{5}$");
    }
    
    // Kiểm tra tính hợp lệ của quốc gia
    public static boolean isValidCountry(String country) {
        return country != null && country.matches("^[A-Za-z\\s]{1,50}$");
    }
}
