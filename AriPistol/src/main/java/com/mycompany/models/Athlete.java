/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

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
    private List<Double> shots;
    
    // Danh sách các quốc gia bị hạn chế
    private static final Set<String> RESTRICTED_COUNTRIES = Set.of("Russia", "Belarus");
    
    // Constructor
    public Athlete(int id, String firstName, String lastName, String country, double score, int worldRank,
    Boolean restrictedCountry){
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty.");
        }
        if (score < 0 || score > 654.0) {
            throw new IllegalArgumentException("Score must be between 0 and 654.0.");
        }
        if (worldRank <= 0) {
            throw new IllegalArgumentException("World rank must be a positive integer.");
        }
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.score = score;
        this.worldRank = worldRank;
        this.shots = new ArrayList<>();
        this.restrictedCountry = RESTRICTED_COUNTRIES.contains(country);
        
        // Nếu vận động viên đến từ quốc gia bị hạn chế, họ sẽ thi đấu dưới danh nghĩa "Neutral Athletes"
        if (this.restrictedCountry) {
            this.country = "Neutral Athletes";
        }
    }
    
    // Constructor
    public Athlete(int id, String firstName, String lastName, String country, double score, int worldRank){
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty.");
        }
        if (score < 0 || score > 654.0) {
            throw new IllegalArgumentException("Score must be between 0 and 654.0.");
        }
        if (worldRank <= 0) {
            throw new IllegalArgumentException("World rank must be a positive integer.");
        }
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.score = score;
        this.worldRank = worldRank;
        this.shots = new ArrayList<>();
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
    
    @Override
    public String toString() {
        return String.format("Athlete: %s %s, ID: %d, Country: %s, Score: %.1f, Rank: %d",
            firstName, lastName, id, country, score, worldRank);
    }
    
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
    
    // Thêm điểm bắn
    public void addShot(double shotScore) {
        if (shots.size() >= 60) {
            throw new IllegalArgumentException("Each athlete can have only 60 shots.");
        }
        shots.add(shotScore);
    }
    
    // Tính điểm dựa trên khoảng cách từ tâm
    public double calculateScore(double distanceFromCenter) {
        if (distanceFromCenter <= 5.75) return 10.9; // Vòng 10
        else if (distanceFromCenter <= 13.75) return 9.0; // Vòng 9
        else if (distanceFromCenter <= 21.75) return 8.0; // Vòng 8
        else if (distanceFromCenter <= 29.75) return 7.0; // Vòng 7
        else if (distanceFromCenter <= 37.75) return 6.0; // Vòng 6
        else if (distanceFromCenter <= 45.75) return 5.0; // Vòng 5
        else if (distanceFromCenter <= 53.75) return 4.0; // Vòng 4
        else if (distanceFromCenter <= 61.75) return 3.0; // Vòng 3
        else if (distanceFromCenter <= 69.75) return 2.0; // Vòng 2
        else if (distanceFromCenter <= 77.75) return 1.0; // Vòng 1
        else return 0.0; // Bắn trượt
    }
    
    // Kiểm tra số lượng phát bắn hợp lệ
    public boolean hasValidShotCount() {
        return shots.size() == 60;
    }

    public List<Double> getShots() {
        return shots;
    }
}
