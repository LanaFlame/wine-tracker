package com.example.wine_tracker.repository;
import com.example.wine_tracker.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Long> {

}
