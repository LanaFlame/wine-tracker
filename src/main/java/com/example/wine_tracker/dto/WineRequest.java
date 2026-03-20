package com.example.wine_tracker.dto;

import jakarta.validation.constraints.*;

public class WineRequest {

    @NotBlank(message = "Name must not be blank")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank(message = "Winery must not be blank")
    @Size(max = 100, message = "Winery must be at most 100 characters")
    private String winery;

    @NotBlank(message = "Country must not be blank")
    @Size(max = 50, message = "Country must be at most 50 characters")
    private String country;


    @NotNull (message = "Year must not be null")
    @Min (value = 1900, message = "Year must be at least 1900")
    @Max (value = 2100, message = "Year must be at most 2100")
    private Integer year;

    @NotNull(message = "Rating must not be null")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;

    @Size(max = 500, message = "Notes must be at most 500 characters")
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
