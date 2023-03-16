package com.pr_dm.eco.foodwaste.controller;

import com.pr_dm.eco.foodwaste.dto.FoodWasteLocationResponseDto;
import com.pr_dm.eco.foodwaste.dto.FoodWasteResponseDto;
import com.pr_dm.eco.foodwaste.service.FoodWasteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FoodWasteController {

    private final FoodWasteService foodWasteService;

    // /api/v1/foodwaste?start=2021-01-01&end=2021-01-31
    @GetMapping("/api/v1/foodwaste")
    @ResponseBody
    public List<FoodWasteResponseDto> getFoodWaste(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end,
            @RequestParam String location
    ) {
        return foodWasteService.getFoodWaste(start, end, location);
    }

    @GetMapping("/api/v1/foodwaste/locations")
    @ResponseBody
    public List<FoodWasteLocationResponseDto> getLocations() {
        return foodWasteService.getLocations();
    }
}
