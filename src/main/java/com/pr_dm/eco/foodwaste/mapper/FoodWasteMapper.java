package com.pr_dm.eco.foodwaste.mapper;


import com.pr_dm.eco.foodwaste.dto.FoodWasteLocationResponseDto;
import com.pr_dm.eco.foodwaste.dto.FoodWasteResponseDto;
import com.pr_dm.eco.foodwaste.entity.FoodWaste;

public class FoodWasteMapper {
    public static FoodWasteResponseDto toFoodWasteResponseDto(FoodWaste entity) {
        return FoodWasteResponseDto.builder()
                .wasteId(entity.getWasteId())
                .cityDo(entity.getCityDo())
                .cityGu(entity.getCityGu())
                .amount(entity.getAmount())
                .date(entity.getDate())
                .build();
    }
    public static FoodWasteLocationResponseDto toFoodWasteLocationResponseDto(FoodWaste entity) {
        return FoodWasteLocationResponseDto.builder()
                .cityDo(entity.getCityDo())
                .cityGu(entity.getCityGu())
                .build();
    }
}
