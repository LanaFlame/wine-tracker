package com.example.wine_tracker.controller;

import com.example.wine_tracker.model.Wine;
import com.example.wine_tracker.service.WineService;
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
    public List<Wine> getAllWines() {
        return wineService.getAllWines();
    }

    @GetMapping("/{id}")
    public Wine getWineById(@PathVariable Long id) {
        return wineService.getWineById(id);
    }

    @PostMapping
    public Wine createWine(@RequestBody Wine wine) {
        return wineService.saveWine(wine);
    }

}
