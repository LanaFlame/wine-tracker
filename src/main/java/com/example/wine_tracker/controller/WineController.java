package com.example.wine_tracker.controller;

import com.example.wine_tracker.dto.WineRequest;
import com.example.wine_tracker.dto.WineResponse;
import com.example.wine_tracker.service.WineService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wines")
public class WineController {

    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping
    public List<WineResponse> getAllWines() {
        return wineService.getAllWines();
    }

    @GetMapping("/{id}")
    public WineResponse getWineById(@PathVariable Long id) {
        return wineService.getWineById(id);
    }

    @PostMapping
    public WineResponse createWine(@Valid @RequestBody WineRequest request) {
        return wineService.saveWine(request);
    }

    @PutMapping("/{id}")
    public WineResponse updateWine(@PathVariable Long id, @Valid @RequestBody WineRequest request) {
        return wineService.updateWine(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteWine(@PathVariable Long id) {
        wineService.deleteWine(id);
    }
}
