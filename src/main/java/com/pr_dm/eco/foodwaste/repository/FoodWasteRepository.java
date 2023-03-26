package com.pr_dm.eco.foodwaste.repository;

import com.pr_dm.eco.foodwaste.entity.FoodWaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface FoodWasteRepository extends JpaRepository<FoodWaste, Long> {

    List<FoodWaste> findAllByDateBetweenAndCityDo(Date start, Date end, String cityDo);

    @Query("SELECT DISTINCT cityDo FROM FoodWaste ORDER BY cityDo")
    List<String> getDistinctLocationOrderByCity();

    @Query("SELECT DISTINCT cityGu FROM FoodWaste WHERE cityDo = ?1 ORDER BY cityGu")
    List<String> getDistinctLocationOrderByGu(String CityDo);

    /*@Query("SELECT DISTINCT cityGu FROM FoodWaste ORDER BY cityGu")
    List<FoodWaste> getDistinctLocationOrderByLocation();*/
}
