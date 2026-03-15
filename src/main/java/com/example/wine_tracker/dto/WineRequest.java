package com.example.wine_tracker.dto;

public class WineRequest {

    private String name;
    private String winery;
    private String country;
    private Integer year;
    private Integer rating;
    private String notes;

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
}
