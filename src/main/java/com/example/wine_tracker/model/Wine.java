package com.example.wine_tracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wines")
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String winery;

    private String country;

    @Column(name = "wine_year")
    private Integer year;

    private Integer rating;

    private String notes;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWinery() {
        return winery;
    }

    public String getCountry() {
        return country;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getRating() {
        return rating;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}