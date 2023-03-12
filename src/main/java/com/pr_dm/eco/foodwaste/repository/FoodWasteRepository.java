package com.pr_dm.eco.foodwaste.repository;

import com.pr_dm.eco.foodwaste.entity.FoodWaste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface FoodWasteRepository extends JpaRepository<FoodWaste, Long> {
    List<FoodWaste> findAllByDateBetween(Date start, Date end);
}
