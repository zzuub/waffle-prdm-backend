package com.pr_dm.eco.foodwaste.service;

import com.pr_dm.eco.foodwaste.dto.FoodWasteResponseDto;
import com.pr_dm.eco.foodwaste.entity.FoodWaste;
import com.pr_dm.eco.foodwaste.mapper.FoodWasteMapper;
import com.pr_dm.eco.foodwaste.repository.FoodWasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodWasteService {
    private final FoodWasteRepository foodWasteRepository;

    public List<FoodWasteResponseDto> getFoodWaste(Date start, Date end) {
        List<FoodWaste> foodWaste = foodWasteRepository.findAllByDateBetween(start, end);
        return foodWaste.stream().map(FoodWasteMapper::toFoodWasteResponseDto).collect(Collectors.toList());
    }
}
