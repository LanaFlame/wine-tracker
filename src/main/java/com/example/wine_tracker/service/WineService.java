package com.example.wine_tracker.service;

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

    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    public Wine getWineById(Long id) {
        return wineRepository.findById(id).orElse(null);
    }

    public Wine saveWine(Wine wine) {
        wine.setCreatedAt(LocalDateTime.now());
        return wineRepository.save(wine);
    }

}
