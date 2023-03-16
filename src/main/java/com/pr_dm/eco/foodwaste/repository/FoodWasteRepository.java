package com.pr_dm.eco.foodwaste.repository;

import com.pr_dm.eco.foodwaste.entity.FoodWaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface FoodWasteRepository extends JpaRepository<FoodWaste, Long> {
    List<FoodWaste> findAllByDateBetweenAndLocation(Date start, Date end, String location);

    @Query("SELECT DISTINCT location FROM FoodWaste ORDER BY location")
    List<FoodWaste> getDistinctLocationOrderByLocation();
}
