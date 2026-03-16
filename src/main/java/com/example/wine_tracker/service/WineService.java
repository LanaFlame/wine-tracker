package com.example.wine_tracker.service;

import com.example.wine_tracker.dto.WineRequest;
import com.example.wine_tracker.dto.WineResponse;
import com.example.wine_tracker.exception.WineNotFoundException;
import com.example.wine_tracker.model.Wine;
import com.example.wine_tracker.repository.WineRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WineService {

    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public List<WineResponse> getAllWines() {
        return wineRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public WineResponse getWineById(Long id) {
        Wine wine = wineRepository.findById(id)
                .orElseThrow(() -> new WineNotFoundException(id));

        return mapToResponse(wine);
    }

    public WineResponse saveWine(WineRequest request) {
        Wine wine = new Wine();
        wine.setName(request.getName());
        wine.setWinery(request.getWinery());
        wine.setCountry(request.getCountry());
        wine.setYear(request.getYear());
        wine.setRating(request.getRating());
        wine.setNotes(request.getNotes());
        wine.setCreatedAt(LocalDateTime.now());

        Wine savedWine = wineRepository.save(wine);

        return mapToResponse(savedWine);
    }

    public WineResponse updateWine(Long id, WineRequest request) {
        Wine existingWine = wineRepository.findById(id)
                .orElseThrow(() -> new WineNotFoundException(id));

        existingWine.setName(request.getName());
        existingWine.setWinery(request.getWinery());
        existingWine.setCountry(request.getCountry());
        existingWine.setYear(request.getYear());
        existingWine.setRating(request.getRating());
        existingWine.setNotes(request.getNotes());

        Wine updatedWine = wineRepository.save(existingWine);

        return mapToResponse(updatedWine);
    }

    public void deleteWine(Long id) {
        Wine existingWine = wineRepository.findById(id)
                .orElseThrow(() -> new WineNotFoundException(id));

        wineRepository.delete(existingWine);
    }

    private WineResponse mapToResponse(Wine wine) {
        WineResponse response = new WineResponse();
        response.setId(wine.getId());
        response.setName(wine.getName());
        response.setWinery(wine.getWinery());
        response.setCountry(wine.getCountry());
        response.setYear(wine.getYear());
        response.setRating(wine.getRating());
        response.setNotes(wine.getNotes());
        response.setCreatedAt(wine.getCreatedAt());
        return response;
    }
}
